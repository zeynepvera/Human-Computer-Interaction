package com.mycompany.human_computer;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import java.io.IOException;
import java.util.List;

public class LibrarytextView {

    private LibraryController controller;
    private Screen screen;

    public LibrarytextView(LibraryController controller) throws IOException {
        this.controller = controller;
        this.screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
    }

    public void showMainMenu() throws IOException {
        boolean loggedIn = false;

        while (!loggedIn) {
            loggedIn = showLoginOrRegisterMenu();
        }

        boolean running = true;
        while (running) {
            screen.clear();

            TextGraphics textGraphics = screen.newTextGraphics();
            textGraphics.putString(2, 2, "Library Management System (Text Mode)", SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.BLUE_BRIGHT);
            textGraphics.putString(2, 4, "Select an option:", SGR.BOLD);

            textGraphics.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);

            textGraphics.putString(2, 6, "1. Add Book");
            textGraphics.putString(2, 7, "2. List Books");
            textGraphics.putString(2, 8, "3. Search Books");
            textGraphics.putString(2, 9, "4. Delete Book");
            textGraphics.putString(2, 10, "5. Logout");
            textGraphics.putString(2, 11, "6. Exit");

            screen.refresh();

            KeyStroke key = screen.readInput();

            if (key.getKeyType() == KeyType.Character) {
                switch (key.getCharacter()) {
                    case '1':
                        addBook();
                        break;
                    case '2':
                        listBooks();
                        break;
                    case '3':
                        searchBooks();
                        break;
                    case '4':
                        deleteBook();
                        break;
                    case '5':
                        loggedIn = false;
                        return; // Logout
                    case '6':
                        running = false;
                        break;
                }
            }
        }
        screen.stopScreen();
    }

    private boolean showLoginOrRegisterMenu() throws IOException {
        screen.clear();

        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.putString(2, 2, "Login or Register", SGR.BOLD);
        textGraphics.setForegroundColor(TextColor.ANSI.BLUE_BRIGHT);

        textGraphics.putString(2, 4, "1. Register");
        textGraphics.putString(2, 5, "2. Login");
        textGraphics.putString(2, 6, "3. Exit");

        screen.refresh();

        KeyStroke key = screen.readInput();

        if (key.getKeyType() == KeyType.Character) {
            switch (key.getCharacter()) {
                case '1':
                    registerUser();
                    return false;
                case '2':
                    return loginUser();
                case '3':
                    screen.stopScreen();
                    System.exit(0);
                    break;
            }
        }
        return false;
    }

    private void registerUser() throws IOException {
        String username = readInput("Enter a username: ");
        String password = readInput("Enter a password: ");
        controller.registerUser(username, password);
        screen.clear();
        screen.newTextGraphics().putString(10, 5, "Registration successful!", SGR.BOLD);
        screen.refresh();
        screen.readInput();
    }

    private boolean loginUser() throws IOException {
        String username = readInput("Enter your username: ");
        String password = readInput("Enter your password: ");
        if (controller.authenticateUser(username, password)) {
            controller.setCurrentUser(username);
            screen.clear();
            screen.newTextGraphics().putString(10, 5, "Login successful!", SGR.BOLD);
            screen.refresh();
            screen.readInput();
            return true;
        } else {
            screen.clear();
            screen.newTextGraphics().putString(10, 5, "Invalid username or password.", SGR.BOLD);
            screen.refresh();
            screen.readInput();
            return false;
        }
    }

    private String readInput(String prompt) throws IOException {
        screen.clear();
        screen.newTextGraphics().putString(10, 5, prompt);
        screen.refresh();

        StringBuilder input = new StringBuilder();
        int cursorPosition = 10 + prompt.length();
        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Enter) {
                break;
            } else if (key.getKeyType() == KeyType.Character) {
                input.append(key.getCharacter());
                screen.clear();
                screen.newTextGraphics().putString(10, 5, prompt);
                screen.newTextGraphics().putString(cursorPosition, 5, input.toString());
                screen.refresh();
            }
        }
        return input.toString();
    }

    
    private void addBook() throws IOException {
    String title = readInput("Enter Book Title: ");
    String author = readInput("Enter Book Author: ");
    String isbn = readInput("Enter Book ISBN: ");

    // Tür seçimi için menü
    String[] genres = {"Fiction", "Non-Fiction", "Science", "History", "Mystery", "Fantasy"};
    int genreIndex = -1;

    while (genreIndex < 0 || genreIndex >= genres.length) {
        screen.clear();
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.putString(10, 5, "Select a genre:", SGR.BOLD);
        for (int i = 0; i < genres.length; i++) {
            textGraphics.putString(10, 7 + i, (i + 1) + ". " + genres[i]);
        }
        screen.refresh();

        KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.Character) {
            char choice = key.getCharacter();
            if (choice >= '1' && choice <= ('0' + genres.length)) {
                genreIndex = Character.getNumericValue(choice) - 1;
            }
        }
    }

    String selectedGenre = genres[genreIndex];

    controller.addBook(title, author, isbn, selectedGenre);
    screen.clear();
    screen.newTextGraphics().putString(10, 5, "Book added successfully!", SGR.BOLD);
    screen.refresh();
    screen.readInput();
}

    /*
    private void addBook() throws IOException {
        String title = readInput("Enter Book Title: ");
        String author = readInput("Enter Book Author: ");
        String isbn = readInput("Enter Book ISBN: ");
        String genre = readInput("Enter Book Genre (e.g., Fiction, Non-Fiction, Science): ");
        controller.addBook(title, author, isbn,genre);
        screen.clear();
        screen.newTextGraphics().putString(10, 5, "Book added successfully!", SGR.BOLD);
        screen.refresh();
        screen.readInput();
    }*/

    private void listBooks() throws IOException {
        screen.clear();
        int line = 5;
        for (Book book : controller.getBooks()) {
            screen.newTextGraphics().putString(10, line++, book.toString());
        }
        screen.refresh();
        screen.readInput();
    }

    private void searchBooks() throws IOException {
        String keyword = readInput("Enter Search Keyword: ");
        List<Book> results = controller.searchBooks(keyword);
        screen.clear();
        if (results.isEmpty()) {
            screen.newTextGraphics().putString(10, 5, "No books found for the given keyword.", SGR.BOLD);
        } else {
            int line = 5;
            for (Book book : results) {
                screen.newTextGraphics().putString(10, line++, book.toString());
            }
        }
        screen.refresh();
        screen.readInput();
    }

    private void deleteBook() throws IOException {
        String isbn = readInput("Enter Book ISBN to Delete: ");
        boolean deleted = controller.deleteBook(isbn);
        screen.clear();
        if (deleted) {
            screen.newTextGraphics().putString(10, 5, "Book deleted successfully!", SGR.BOLD);
        } else {
            screen.newTextGraphics().putString(10, 5, "Book not found.", SGR.BOLD);
        }
        screen.refresh();
        screen.readInput();
    }
}



