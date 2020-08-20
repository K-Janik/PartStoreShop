package pl.example.PartStoreShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.example.PartStoreShop.dao.WorkerDao;
import pl.example.PartStoreShop.model.Worker;

@Service
public class WorkerService {

    private final WorkerDao workerDao;

    @Autowired
    public WorkerService(@Qualifier("fakeDao") WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    public int addWorker(Worker worker) {
        return workerDao.insertWorker(worker);
    }
}
