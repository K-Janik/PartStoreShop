package pl.example.PartStoreShop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Order {
    private final UUID orderid;
    private final Worker worker;
    private final Part part;
    private final int quantity;

    public Order(@JsonProperty("id") UUID orderid, @JsonProperty("name") Worker worker, @JsonProperty("partname") Part part, @JsonProperty("quantity") int quantity) {
        this.orderid = orderid;
        this.worker = worker;
        this.part = part;
        this.quantity = quantity;
    }

    public UUID getOrderid() {
        return orderid;
    }

    public Worker getWorker() {
        return worker;
    }

    public Part getPart() {
        return part;
    }

    public int getQuantity() {
        return quantity;
    }
}

