package pl.example.PartStoreShop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.example.PartStoreShop.model.Worker;
import pl.example.PartStoreShop.service.WorkerService;

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
}
