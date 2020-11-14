package pl.example.PartStoreShop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.example.PartStoreShop.model.Order;
import pl.example.PartStoreShop.model.Part;
import pl.example.PartStoreShop.model.Worker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PartStoreShop")
public class PartStoreShopDataAccessService implements PartDao,WorkerDao, OrderDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PartStoreShopDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int insertPart(UUID partnr, Part part) {
        final String sql = "INSERT INTO part VALUES(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{
                partnr,
                part.getPartname(),
                part.getPrice()
        });
    }

    @Override
    public List<Part> selectAllParts() {
        final String sql = "SELECT nr, name, price FROM part";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID partnr = UUID.fromString(resultSet.getString("nr"));
            String partname = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            return new Part(partnr, partname, price);
        });
    }

    @Override
    public Optional<Part> selectPartById(UUID partid) {
        final String sql = "SELECT nr, name, price WHERE nr = ?";
        Part part = jdbcTemplate.queryForObject(
                sql,
                new Object[]{partid},
                (resultSet, i) -> {
                    UUID partnr = UUID.fromString(resultSet.getString("nr"));
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    return new Part(partnr,name,price);
                });
        return Optional.ofNullable(part);
    }

    @Override
    public int deletePartByID(UUID partid) {
        final String sql = "DELETE FROM part WHERE nr = ?";
        return jdbcTemplate.update(sql, partid);
    }

    @Override
    public int updatePartById(UUID partid, Part part) {
        final String sql = "UPDATE part SET name=?, price=? WHERE nr=?";
        return jdbcTemplate.update(sql, part.getPartname(), part.getPrice(), partid);
    }

    @Override
    public int insertWorker(UUID id, Worker worker) {
        final String sql = "INSERT INTO worker VALUES(?,?)";
        return jdbcTemplate.update(sql, new Object[]{
                id,
                worker.getName(),
        });
    }

    @Override
    public List<Worker> selectAllWorkers() {
        final String sql = "SELECT id, name FROM worker";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Worker(id, name);
        });
    }

    @Override
    public Optional<Worker> selectWorkerById(UUID id) {
        final String sql = "SELECT id, name WHERE id = ?";
        Worker worker = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID workerid = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    return new Worker(workerid, name);
                });
        return Optional.ofNullable(worker);
    }

    @Override
    public int deleteWorkerById(UUID id) {
        final String sql = "DELETE FROM worker WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateWorkerById(UUID id, Worker worker) {
        final String sql = "UPDATE worker SET name=? WHERE id=?";
        return jdbcTemplate.update(sql, worker.getName());
    }

    @Override
    public int insertOrder(UUID orderId, Order order) {
        final String insert_sql = "INSERT INTO partorder(order_id,part_name,order_quantity,worker_name,worker_id,part_id,part_price) VALUES (" +
                "?,?,?,?," +
                "(SELECT id FROM worker WHERE name=?)," +
                "(SELECT nr FROM part WHERE name=?)," +
                "(SELECT price FROM part WHERE name=?))";
        return jdbcTemplate.update(insert_sql, new Object[]{
                orderId,
                order.getPartId(),
                order.getQuantity(),
                order.getWorkerId(),
                order.getWorkerId(),
                order.getPartId(),
                order.getPartId()
        });
    }

    @Override
    public List<Order> selectAllOrders() {
        final String sqlPartOrder = "SELECT * FROM partorder";
        final String sqlWorker = "SELECT worker_id FROM partorder";
        final String sqlPart = "SELECT part_id, part_price FROM partorder";
        return jdbcTemplate.query(sqlPartOrder, (resultSet, i) -> {
           UUID order_id = UUID.fromString(resultSet.getString("order_id"));
           UUID part_id = UUID.fromString(resultSet.getString("part_id"));
           UUID worker_id = UUID.fromString(resultSet.getString("worker_id"));
           double part_price = resultSet.getDouble("part_price");
           String part_name=resultSet.getString("part_name");
           int order_quantity=resultSet.getInt("order_quantity");
           String worker_name=resultSet.getString("worker_name");
           return new Order(order_id,worker_id,part_id,order_quantity);
        });
    }

    @Override
    public Optional<Order> selectOrderById(UUID orderid) {
        final String sql = "SELECT * FROM partorder WHERE order_id=?";
        Order order = jdbcTemplate.queryForObject(
                sql,
                new Object[] {orderid},
                (resultSet, i) -> {
                    UUID orderId = UUID.fromString(resultSet.getString("order_id"));
                    UUID partId = UUID.fromString(resultSet.getString("part_name"));
                    int orderQuantity = resultSet.getInt("order_quantity");
                    UUID workerId = UUID.fromString(resultSet.getString("worker_name"));
                    return new Order(orderId, workerId,partId,orderQuantity);
                });
        return Optional.ofNullable(order);
    }

    @Override
    public int deleteOrderById(UUID orderid) {
        final String sql = "DELETE FROM partorder WHERE order_id=?";
        return jdbcTemplate.update(sql, orderid);
    }

    @Override
    public int updateOrderById(UUID orderid, Order order) {
        return 0;
    }
}
