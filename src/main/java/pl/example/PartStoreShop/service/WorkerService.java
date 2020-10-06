package pl.example.PartStoreShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.example.PartStoreShop.dao.WorkerDao;
import pl.example.PartStoreShop.model.Worker;

import java.util.List;
import java.util.UUID;

@Service
public class WorkerService {

    private final WorkerDao workerDao;

    @Autowired
    public WorkerService(@Qualifier("PartStoreShop") WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    public int addWorker(Worker worker) {
        return workerDao.insertWorker(worker);
    }

    public List<Worker> getAllWorkers() {
        return workerDao.selectAllWorkers();
    }

    public int deleteWorker(UUID id) {
        return workerDao.deleteWorkerById(id);
    }

    public int updateWorker(UUID id, Worker newWorker) {
        return workerDao.updateWorkerById(id, newWorker);
    }
}
