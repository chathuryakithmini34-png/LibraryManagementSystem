
package com.library;

public class Librarian extends User {

    public Librarian(int id, String username) {
        super(id, username);
    }

    @Override
    public void showDashboard() {
        System.out.println("Librarian Dashboard");
        System.out.println("Manage books and loans.");
    }
}
