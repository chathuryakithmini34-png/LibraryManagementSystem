
package com.library;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateDemoUser {

    public static void main(String[] args) throws Exception {

        String sql = "INSERT INTO users " +
            "(username, password_hash, role) " +
            "VALUES (?, ?, ?)";

        try (Connection con =
                 DatabaseConnection.getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setString(1, "admin");
            ps.setString(2, PasswordUtil.hash("Admin123!"));
            ps.setString(3, "ADMIN");

            ps.executeUpdate();
            System.out.println("Demo account created.");
        }
    }
}
