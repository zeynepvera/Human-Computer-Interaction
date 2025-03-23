package com.mycompany.human_computer;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        LibraryController controller = new LibraryController();
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose he mode that u want it");
        System.out.println("1==> TEXT MODE ");
        System.out.println("2==> GUI MODE");
        int number = scan.nextInt();

        if (number == 1) {

            LibrarytextView textview = new LibrarytextView(controller);
            textview.showMainMenu();

        } else if (number == 2) {
            new MainPage(controller).setVisible(true);

        } else {

            System.out.println("invalid choice");
        }

    }

}
