package org.ac.cst8277.mohamed.yazid.ums;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private int messageId;
    private UUID userId;
    private String content;
    private LocalDateTime timestamp;

    // Getters and setters
    public int getMessageId() { return messageId; }
    public void setMessageId(int messageId) { this.messageId = messageId; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
