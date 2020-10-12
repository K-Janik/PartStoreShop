package pl.example.PartStoreShop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pl.example.PartStoreShop.model.Order;
import pl.example.PartStoreShop.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void addOrder(@Valid @NonNull @RequestBody Order order) {
        orderService.addOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(path="{id}")
    public Order getOrderById(@PathVariable("id") UUID orderid) {
        return orderService.getOrderById(orderid)
                .orElseThrow(() -> new IllegalArgumentException("Order is not in Database"));
    }

    @DeleteMapping(path="{id}")
    public void deleteOrder(@PathVariable("id") UUID orderid) {
        orderService.deleteOrder(orderid);
    }

    @PutMapping(path="{id}")
    public void updateOrder(@PathVariable("id") UUID orderid, @Valid@NonNull@RequestBody Order orderToUpdate) {
        orderService.updateOrder(orderid, orderToUpdate);
    }

}
