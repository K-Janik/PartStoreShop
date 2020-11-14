package pl.example.PartStoreShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.example.PartStoreShop.dao.OrderDao;
import pl.example.PartStoreShop.dao.PartDao;
import pl.example.PartStoreShop.dao.WorkerDao;
import pl.example.PartStoreShop.model.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderDao orderDao;
    private final WorkerDao workerDao;
    private final PartDao partDao;

    @Autowired
    public OrderService(@Qualifier("PartStoreShop") OrderDao orderDao,@Qualifier("PartStoreShop") WorkerDao workerDao,@Qualifier("PartStoreShop") PartDao partDao) {
        this.orderDao = orderDao;
        this.workerDao = workerDao;
        this.partDao = partDao;

    }

    public int addOrder (Order order) {
        return orderDao.insertOrder(order);
    }

    public List<OrderDto> getAllOrders(){
        final List<Order> orders = orderDao.selectAllOrders();
        return orders.stream()
                .map(order -> {
                    WorkerDto workerDto=workerDao.selectWorkerById(order.getWorkerId());
                    PartDto partDto = partDao.selectPartById(order.getPartId());
                    return OrderMapper.toDto(order, workerDto, partDto);
                })
                .collect(Collectors.toUnmodifiableList());
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
