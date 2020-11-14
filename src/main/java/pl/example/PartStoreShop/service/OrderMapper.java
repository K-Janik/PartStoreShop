package pl.example.PartStoreShop.service;

import pl.example.PartStoreShop.model.Order;
import pl.example.PartStoreShop.model.OrderDto;
import pl.example.PartStoreShop.model.PartDto;
import pl.example.PartStoreShop.model.WorkerDto;

public class OrderMapper {

    static Order toDao(OrderDto orderDto) {
        return new Order(orderDto.getOrderId(), orderDto.getPartDto().getId(), orderDto.getWorkerDto().getId(), orderDto.getQuantity());
    }

    static OrderDto toDto(Order order, WorkerDto workerDto, PartDto partDto) {
        return new OrderDto(order.getOrderId(), workerDto, partDto,order.getQuantity());
    }
}
