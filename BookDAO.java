
package com.library;

import java.sql.*;

public class BookDAO {

    // CREATE
    public void addBook(String title, String author,
                        int quantity) throws SQLException {

        String sql = "INSERT INTO books " +
            "(title, author, quantity) VALUES (?, ?, ?)";

        try (Connection con =
                 DatabaseConnection.getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);

            ps.executeUpdate();
            System.out.println("Book added successfully.");
        }
    }

    // READ
    public void viewBooks() throws SQLException {

        String sql = "SELECT * FROM books";

        try (Connection con =
                 DatabaseConnection.getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("book_id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | " +
                    rs.getInt("quantity")
                );
            }
        }
    }

    // UPDATE
    public void updateBook(int id, String title,
                           String author, int quantity)
                           throws SQLException {

        String sql = "UPDATE books SET title=?, " +
            "author=?, quantity=? WHERE book_id=?";

        try (Connection con =
                 DatabaseConnection.getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            System.out.println(
                rows > 0 ? "Book updated." : "Book not found."
            );
        }
    }

    // DELETE
    public void deleteBook(int id) throws SQLException {

        String sql = "DELETE FROM books WHERE book_id=?";

        try (Connection con =
                 DatabaseConnection.getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(
                rows > 0 ? "Book deleted." : "Book not found."
            );
        }
    }
}
