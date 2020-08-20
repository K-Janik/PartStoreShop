package pl.example.PartStoreShop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.example.PartStoreShop.model.Part;
import pl.example.PartStoreShop.service.PartService;

@RequestMapping("api/part")
@RestController
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @PostMapping
    public void addPart(@RequestBody Part part) {
        partService.addPart(part);
    }
}
