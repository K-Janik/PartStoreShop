package pl.example.PartStoreShop.model;

import java.util.UUID;

public class Part {

    private final UUID partnr;
    private final String partname;
    int quantity;
    double price;

    public Part(UUID partnr, String partname, int quantity, double price) {
        this.partnr = partnr;
        this.partname = partname;
        this.quantity = quantity;
        this.price = price;
    }

    public UUID getPartnr() {
        return partnr;
    }

    public String getPartname() {
        return partname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
