package org.ac.cst8277.mohamed.yazid.ums;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;

    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
