package org.ac.cst8277.mohamed.yazid.ums;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UmsRepository {
    // User Management
    Map<UUID, User> findAllUsers();
    User findUserByID(UUID userId);
    UUID createUser(User user);
    int deleteUser(UUID userId);
    User findByUsernameAndPassword(String username, String password);

    // Message Handling
    List<Message> findAllMessagesByUserId(UUID userId);
    void saveMessage(Message message);


}
