package pl.example.PartStoreShop.dao;

import org.springframework.stereotype.Repository;
import pl.example.PartStoreShop.model.Part;
import pl.example.PartStoreShop.model.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePartStoreDao implements PartDao,WorkerDao {

    private static List<Part> PartDB = new ArrayList<>();
    private static List<Worker> WorkerDB = new ArrayList<>();

    @Override
    public int insertPart(UUID partnr, Part part) {
        PartDB.add(new Part(partnr, part.getPartname(), part.getPrice()));
        return 1;
    }

    @Override
    public int insertWorker(UUID id, Worker worker) {
        WorkerDB.add(new Worker(id, worker.getName()));
        return 1;
    }
}
