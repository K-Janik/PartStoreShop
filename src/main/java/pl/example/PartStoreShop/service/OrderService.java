package pl.example.PartStoreShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.example.PartStoreShop.dao.OrderDao;
import pl.example.PartStoreShop.dao.PartDao;
import pl.example.PartStoreShop.dao.WorkerDao;
import pl.example.PartStoreShop.model.Order;
import pl.example.PartStoreShop.model.Worker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderDao orderDao;
    private final WorkerDao workerDao;
    private final PartDao partDao;

    @Autowired
    public OrderService(@Qualifier("PartStoreShop") OrderDao orderDao, WorkerDao workerDao, PartDao partDao) {
        this.orderDao = orderDao;
        this.workerDao = workerDao;
        this.partDao = partDao;
    }

    public int addOrder (Order order) {
        return orderDao.insertOrder(order);
    }

    public List<Order> getAllOrders(){
        final List<Order> orders = orderDao.selectAllOrders();
        return orders.stream()
                .map(order -> {
                    Worker worker = orderDao.selectOrderById()
                })
                //orderDao.selectAllOrders();
    }

    public Optional<Order> getOrderById(UUID orderid) {
        return orderDao.selectOrderById(orderid);
    }

    public int deleteOrder(UUID orderid) {
        return orderDao.deleteOrderById(orderid);
    }

    public int updateOrder(UUID orderid, Order order) {
        return orderDao.updateOrderById(orderid, order);
    }

}
