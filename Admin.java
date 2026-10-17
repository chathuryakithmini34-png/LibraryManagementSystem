
package com.library;

public class Admin extends User {

    public Admin(int id, String username) {
        super(id, username);
    }

    @Override
    public void showDashboard() {
        System.out.println("Admin Dashboard");
        System.out.println("Manage users and books.");
    }
}
