package pl.example.PartStoreShop.dao;

import pl.example.PartStoreShop.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderDao {
    int insertOrder(UUID orderid, Order order);

    default int insertOrder(Order order) {
        UUID orderid = UUID.randomUUID();
        return insertOrder(orderid, order);
    }

    List<Order> selectAllOrders();

    Optional<Order> selectOrderById(UUID orderid);

    int deleteOrderById(UUID orderid);

    int updateOrderById(UUID orderid, Order order);
}
