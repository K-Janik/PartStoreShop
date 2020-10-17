package pl.example.PartStoreShop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Order {
    private final UUID orderid;
    private final String worker;
    private final String part;
    private final int quantity;

    public Order(@JsonProperty("id") UUID orderid, @JsonProperty("name") String worker, @JsonProperty("partname") String part, @JsonProperty("quantity") int quantity) {
        this.orderid = orderid;
        this.worker = worker;
        this.part = part;
        this.quantity = quantity;
    }

    public UUID getOrderid() {
        return orderid;
    }

    public String getWorker() {
        return worker;
    }

    public String getPart() {
        return part;
    }

    public int getQuantity() {
        return quantity;
    }
}

