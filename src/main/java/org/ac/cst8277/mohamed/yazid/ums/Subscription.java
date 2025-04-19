package org.ac.cst8277.mohamed.yazid.ums;

import java.util.UUID;

public class Subscription {
    private UUID subscriberId;
    private UUID producerId;

    // Getters and setters
    public UUID getSubscriberId() { return subscriberId; }
    public void setSubscriberId(UUID subscriberId) { this.subscriberId = subscriberId; }

    public UUID getProducerId() { return producerId; }
    public void setProducerId(UUID producerId) { this.producerId = producerId; }
}
