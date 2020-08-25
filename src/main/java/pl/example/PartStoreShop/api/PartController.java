package pl.example.PartStoreShop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pl.example.PartStoreShop.model.Part;
import pl.example.PartStoreShop.service.PartService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/part")
@RestController
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @PostMapping
    public void addPart(@Valid @NonNull @RequestBody Part part) {
        partService.addPart(part);
    }

    @GetMapping
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @GetMapping(path = "{partnr}")
    public Part getPartById(@PathVariable("partnr") UUID partnr) {
        return partService.getPartById(partnr)
                .orElseThrow(() -> new IllegalArgumentException("Part is not in Database"));
    }

    @DeleteMapping(path = "{partnr}")
    public void deletePartById(@PathVariable("partnr") UUID partnr) {
        partService.deletePart(partnr);
    }

    @PutMapping(path = "{partnr}")
    public void updatePart(@PathVariable("partnr") UUID partnr,@Valid @NonNull @RequestBody Part partToUpdate) {
        partService.updatePart(partnr, partToUpdate);
    }
}
