package pl.example.PartStoreShop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Order {
    private final UUID orderId;
    private final UUID workerId;
    private final UUID partId;
    private final int quantity;

    public Order(@JsonProperty("orderId") UUID orderId, @JsonProperty("workerId") UUID workerId, @JsonProperty("partId") UUID partId, @JsonProperty("quantity") int quantity) {
        this.orderId = orderId;
        this.workerId = workerId;
        this.partId = partId;
        this.quantity = quantity;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getWorkerId() {
        return workerId;
    }

    public UUID getPartId() {
        return partId;
    }

    public int getQuantity() {
        return quantity;
    }
}

