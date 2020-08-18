package pl.example.PartStoreShop.model;

import java.util.UUID;

public class Part {

    private final UUID partnr;
    private final String partname;
    double price;

    public Part(UUID partnr, String partname, double price) {
        this.partnr = partnr;
        this.partname = partname;
        this.price = price;
    }

    public UUID getPartnr() {
        return partnr;
    }

    public String getPartname() {
        return partname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
