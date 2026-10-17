
package com.library;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LoginService login = new LoginService();
        BookDAO books = new BookDAO();

        try {
            System.out.println("=== LIBRARY MANAGEMENT ===");
            System.out.print("Username: ");
            String username = input.nextLine();

            System.out.print("Password: ");
            String password = input.nextLine();

            if (!login.login(username, password)) {
                System.out.println("Login failed.");
                return;
            }

            System.out.println("Welcome, " + username);

            boolean running = true;

            while (running) {
                System.out.println("\n1. Add book");
                System.out.println("2. View books");
                System.out.println("3. Update book");
                System.out.println("4. Delete book");
                System.out.println("5. Exit");
                System.out.print("Choose: ");

                int choice = Integer.parseInt(
                    input.nextLine()
                );

                switch (choice) {
                    case 1:
                        System.out.print("Title: ");
                        String title = input.nextLine();

                        System.out.print("Author: ");
                        String author = input.nextLine();

                        System.out.print("Quantity: ");
                        int quantity = Integer.parseInt(
                            input.nextLine()
                        );

                        if (quantity < 0) {
                            System.out.println(
                                "Quantity cannot be negative."
                            );
                            break;
                        }

                        books.addBook(title, author, quantity);
                        break;

                    case 2:
                        books.viewBooks();
                        break;

                    case 3:
                        System.out.print("Book ID: ");
                        int updateId = Integer.parseInt(
                            input.nextLine()
                        );

                        System.out.print("New title: ");
                        String newTitle = input.nextLine();

                        System.out.print("New author: ");
                        String newAuthor = input.nextLine();

                        System.out.print("New quantity: ");
                        int newQuantity = Integer.parseInt(
                            input.nextLine()
                        );

                        if (newQuantity < 0) {
                            System.out.println(
                                "Quantity cannot be negative."
                            );
                            break;
                        }

                        books.updateBook(
                            updateId, newTitle,
                            newAuthor, newQuantity
                        );
                        break;

                    case 4:
                        System.out.print("Book ID to delete: ");
                        int deleteId = Integer.parseInt(
                            input.nextLine()
                        );

                        books.deleteBook(deleteId);
                        break;

                    case 5:
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println(
                            "Please select 1 to 5."
                        );
                }
            }

        } catch (SQLException e) {
            System.out.println(
                "Database error: " + e.getMessage()
            );
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } finally {
            input.close();
        }
    }
}
