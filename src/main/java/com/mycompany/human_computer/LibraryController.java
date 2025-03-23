package com.mycompany.human_computer;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryController {

    private List<Book> books = new ArrayList<>();
    private final String booksFile = "C:\\Users\\WINCHESTER\\OneDrive\\Masaüstü\\Yeni klasör\\books_file.dat";

    private List<User> users = new ArrayList<>();
    private final String usersFile = "C:\\Users\\WINCHESTER\\OneDrive\\Masaüstü\\Yeni klasör\\users_file.dat";
    private User currentUser; // Şu anda giriş yapan kullanıcı

    public LibraryController() {
        loadBooksFromFile(); // Kitapları yükle
        loadUsersFromFile(); // Kullanıcıları yükle
    }

    // Kullanıcı İşlemleri
   public void registerUser(String username, String password) {
    // Eğer aynı kullanıcı ismi varsa hata ver
    if (users.stream().anyMatch(user -> user.getUsername().equals(username))) {
        System.err.println("User already exists: " + username);
        return;
    }
    // Kullanıcı ekle ve dosyaya kaydet
    users.add(new User(username, password));
    saveUsersToFile(); // Kullanıcıyı dosyaya kaydet
    System.out.println("User registered successfully!");
}


    public boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }
    public void setCurrentUser(String username) {
    for (User user : users) {
        if (user.getUsername().equals(username)) {
            currentUser = user; // Şu anda giriş yapan kullanıcıyı ayarla
            return;
        }
    }
    System.err.println("User not found: " + username);
}


    public User getCurrentUser() {
        return currentUser;
    }
private void saveUsersToFile() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(usersFile))) {
        oos.writeObject(users); // Kullanıcı listesini dosyaya yaz
        System.out.println("Users saved to file successfully.");
    } catch (IOException e) {
        System.err.println("Error saving users to file: " + e.getMessage());
    }
}

private void loadUsersFromFile() {
    
       File file = new File(usersFile);
    System.out.println("User file exists: " + file.exists()); // Dosya var mı kontrol et

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(usersFile))) {
        users = (ArrayList<User>) ois.readObject(); // Dosyadan kullanıcıları oku
        System.out.println("Users loaded from file successfully.");
    } catch (FileNotFoundException e) {
        System.err.println("User file not found. Starting with an empty user list.");
        users = new ArrayList<>(); // Dosya bulunamazsa boş bir liste oluştur
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error loading users from file: " + e.getMessage());
    }
}



    // Kitap İşlemleri
    public void addBook(String title, String author, String isbn,String genre) {
        if (currentUser == null) {
            System.err.println("You must be logged in to add a book.");
            return;
        }
        books.add(new Book(title, author, isbn,genre));
        saveBooksToFile();
        System.out.println("Book added successfully!");
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> searchBooks(String keyword) {
        if (currentUser == null) {
            System.err.println("You must be logged in to search books.");
            return new ArrayList<>();
        }
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }
    
    public List<Book> searchBooksByTitle(String title) {
    return books.stream()
        .filter(book -> book.getTitle().equalsIgnoreCase(title))
        .collect(Collectors.toList());
}

public List<Book> searchBooksByAuthor(String author) {
    return books.stream()
        .filter(book -> book.getAuthor().equalsIgnoreCase(author))
        .collect(Collectors.toList());
}

public List<Book> searchBooksByGenre(String genre) {
    return books.stream()
        .filter(book -> book.getGenre().equalsIgnoreCase(genre))
        .collect(Collectors.toList());
}

public List<Book> searchBooksByISBN(String isbn) {
    return books.stream()
        .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
        .collect(Collectors.toList());
}


    public boolean deleteBook(String isbn) {
        if (currentUser == null) {
            System.err.println("You must be logged in to delete a book.");
            return false;
        }
        boolean removed = false;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                removed = true;
            }
        }
        if (removed) {
            saveBooksToFile();
            System.out.println("Book deleted successfully!");
        } else {
            System.err.println("Book not found with ISBN: " + isbn);
        }
        return removed;
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(booksFile))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.err.println("Error saving books to file: " + e.getMessage());
        }
    }

    private void loadBooksFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(booksFile))) {
            books = (ArrayList<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Books file not found. Starting with an empty library.");
            books = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading books from file: " + e.getMessage());
        }
    }
}




















