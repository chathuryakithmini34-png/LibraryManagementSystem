
package com.library;

import java.sql.*;

public class LoginService {

    public boolean login(String username, String password)
            throws SQLException {

        String sql = "SELECT password_hash FROM users " +
                     "WHERE username = ?";

        try (Connection con =
                 DatabaseConnection.getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String storedHash =
                        rs.getString("password_hash");

                    String enteredHash =
                        PasswordUtil.hash(password);

                    return storedHash.equals(enteredHash);
                }
            }
        }

        return false;
    }
}
