package pl.example.PartStoreShop.model;

import java.util.UUID;

public class PartDto {

    private final UUID id;
    private final String name;
    private final double price;

    public PartDto(UUID id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
