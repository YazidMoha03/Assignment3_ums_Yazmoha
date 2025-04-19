package org.ac.cst8277.mohamed.yazid.ums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.*;

@Repository
public class JdbcUmsRepository implements UmsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all users
    @Override
    public Map<UUID, User> findAllUsers() {
        Map<UUID, User> users = new HashMap<>();
        String sql = "SELECT * FROM users";

        List<User> userList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(UUID.fromString(rs.getString("user_id")));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        });

        for (User user : userList) {
            users.put(user.getId(), user);
        }

        return users;
    }

    // Get user by ID
    @Override
    public User findUserByID(UUID userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId.toString()}, (rs, rowNum) -> {
            User user = new User();
            user.setId(UUID.fromString(rs.getString("user_id")));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }

    // Create new user
    @Override
    public UUID createUser(User user) {
        UUID userId = UUID.randomUUID();
        String sql = "INSERT INTO users (user_id, username, password) VALUES (?, ?, ?)";
        int rows = jdbcTemplate.update(sql, userId.toString(), user.getUsername(), user.getPassword());
        return rows > 0 ? userId : null;
    }

    // Delete user
    @Override
    public int deleteUser(UUID userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        return jdbcTemplate.update(sql, userId.toString());
    }

    // Find user by username and password
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT user_id as id, username, password FROM users WHERE username = ? AND password = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username, password}, (rs, rowNum) -> {
                User user = new User();
                user.setId(UUID.fromString(rs.getString("id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            });
        } catch (Exception e) {
            e.printStackTrace(); // Debug purpose
            return null;
        }
    }

    @Override
    public void saveMessage(Message message) {
        String sql = "INSERT INTO messages (user_id, content, timestamp) VALUES ( )";
        jdbcTemplate.update(sql,
            message.getUserId().toString(),
            message.getContent(),
            Timestamp.valueOf(message.getTimestamp()));
    }

    @Override
    public List<Message> findAllMessagesByUserId(UUID userId) {
        String sql = "SELECT * FROM messages WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId.toString()}, (rs, rowNum) -> {
            Message message = new Message();
            message.setMessageId(rs.getInt("message_id"));
            message.setUserId(UUID.fromString(rs.getString("user_id")));
            message.setContent(rs.getString("content"));
            message.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
            return message;
        });
    }
}

