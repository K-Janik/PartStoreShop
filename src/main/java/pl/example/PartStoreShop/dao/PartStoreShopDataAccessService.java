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
    public int insertOrder(UUID orderid, Order order) {
        return 0;
    }

    @Override
    public List<Order> selectAllOrders() {
        return null;
    }

    @Override
    public Optional<Order> selectOrderById(UUID orderid) {
        return Optional.empty();
    }

    @Override
    public int deleteOrderById(UUID orderid) {
        return 0;
    }

    @Override
    public int updateOrderById(UUID orderid, Order order) {
        return 0;
    }
}
