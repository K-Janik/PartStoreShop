package pl.example.PartStoreShop.dao;

import pl.example.PartStoreShop.model.Worker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkerDao {
    int insertWorker(UUID id, Worker worker);

    default int isertWorker(Worker worker) {
        UUID id = UUID.randomUUID();
        return insertWorker(id, worker);
    }

    List<Worker> selectAllWorkers();

    Optional<Worker> selectWorkerById(UUID id);

    int deleteWorkerById(UUID id);

    int updateWorkerById(UUID id, Worker worker);
}
