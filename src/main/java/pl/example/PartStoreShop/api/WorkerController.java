package pl.example.PartStoreShop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pl.example.PartStoreShop.model.Worker;
import pl.example.PartStoreShop.service.WorkerService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/worker")
@RestController
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    public void addWorker(@RequestBody Worker worker) {
        workerService.addWorker(worker);
    }

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @DeleteMapping(path = "{id}")
    public void deleteWorkerById(@PathVariable("id") UUID id) {
        workerService.deleteWorker(id);
    }

    @PutMapping(path = "{id}")
    public void updateWorker(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Worker workerToUpdate) {
        workerService.updateWorker(id, workerToUpdate);
    }
}
