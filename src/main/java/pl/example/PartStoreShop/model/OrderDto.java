package pl.example.PartStoreShop.model;

import java.util.UUID;

public class OrderDto {

    private final UUID orderId;
    private final WorkerDto workerDto;
    private final PartDto partDto;
    private final int quantity;

    public OrderDto(UUID orderId, WorkerDto workerDto, PartDto partDto, int quantity) {
        this.orderId = orderId;
        this.workerDto = workerDto;
        this.partDto = partDto;
        this.quantity = quantity;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public WorkerDto getWorkerDto() {
        return workerDto;
    }

    public PartDto getPartDto() {
        return partDto;
    }

    public int getQuantity() {
        return quantity;
    }
}
