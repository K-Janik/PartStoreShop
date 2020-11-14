package pl.example.PartStoreShop.model;

import java.util.UUID;

public class WorkerDto {

    private final UUID id;
    private final String name;

    public WorkerDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
