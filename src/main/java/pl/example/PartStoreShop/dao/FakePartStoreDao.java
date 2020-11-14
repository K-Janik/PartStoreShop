package pl.example.PartStoreShop.dao;

import org.springframework.stereotype.Repository;
import pl.example.PartStoreShop.model.Order;
import pl.example.PartStoreShop.model.Part;
import pl.example.PartStoreShop.model.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePartStoreDao implements PartDao,WorkerDao,OrderDao {

    private static List<Part> PartDB = new ArrayList<>();
    private static List<Worker> WorkerDB = new ArrayList<>();
    private static List<Order> OrderDB = new ArrayList<>();

    @Override
    public int insertPart(UUID partnr, Part part) {
        PartDB.add(new Part(partnr, part.getPartname(), part.getPrice()));
        return 1;
    }

    @Override
    public List<Part> selectAllParts() {
        return PartDB;
    }

    @Override
    public Optional<Part> selectPartById(UUID partid) {
        return PartDB.stream()
                .filter(part -> part.getPartnr().equals(partid))
                .findFirst();
    }

    @Override
    public int deletePartByID(UUID partid) {
        Optional<Part> partMaybe = selectPartById(partid);
        if (partMaybe.isEmpty()) {
            return 0;
        }
        PartDB.remove(partMaybe.get());
        return 1;
    }

    @Override
    public int updatePartById(UUID partid, Part update) {
        return selectPartById(partid)
                .map(part -> {
                    int indexOfPartToUpdate = PartDB.indexOf(part);
                    if (indexOfPartToUpdate >= 0) {
                        PartDB.set(indexOfPartToUpdate, new Part(partid, update.getPartname(), update.getPrice()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int insertWorker(UUID id, Worker worker) {
        WorkerDB.add(new Worker(id, worker.getName()));
        return 1;
    }

    @Override
    public List<Worker> selectAllWorkers() {
        return WorkerDB;
    }

    @Override
    public Optional<Worker> selectWorkerById(UUID id) {
        return WorkerDB.stream()
                .filter(worker -> worker.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteWorkerById(UUID id) {
        Optional<Worker> workerMaybe = selectWorkerById(id);
        if (workerMaybe.isEmpty()) {
            return 0;
        }
        WorkerDB.remove(workerMaybe.get());
        return 1;
    }

    @Override
    public int updateWorkerById(UUID id, Worker update) {
        return selectWorkerById(id)
                .map(worker -> {
                    int indexOfWorkerToUpdate = WorkerDB.indexOf(worker);
                    if (indexOfWorkerToUpdate >= 0) {
                        WorkerDB.set(indexOfWorkerToUpdate, new Worker(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int insertOrder(UUID orderid, Order order) {
        OrderDB.add(new Order(orderid, order.getWorkerId(), order.getPartId(), order.getQuantity()));
        return 1;
    }

    @Override
    public int insertOrder(Order order) {
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

