package pl.example.PartStoreShop.api;

import pl.example.PartStoreShop.model.Part;
import pl.example.PartStoreShop.model.Worker;

public class Order {
    private final double orderid;
    private final Worker worker;
    private final Part part;
    private final int quantity;

    public Order(double orderid, Worker worker, Part part, int quantity) {
        this.orderid = orderid;
        this.worker = worker;
        this.part = part;
        this.quantity = quantity;
    }

    public double getOrderid() {
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
