package pl.example.PartStoreShop.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.example.PartStoreShop.model.Order;
import pl.example.PartStoreShop.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void addOrder(Order order) {
        orderService.addOrder(order);
    }

    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    public Order getOrderById(UUID orderid) {
        return orderService.getOrderById(orderid)
                .orElseThrow(() -> new IllegalArgumentException("Order is not in Database"));
    }

    public void deleteOrder(UUID orderid) {
        orderService.deleteOrder(orderid);
    }

    public void updateOrder(UUID orderid, Order orderToUpdate) {
        orderService.updateOrder(orderid, orderToUpdate);
    }

}
