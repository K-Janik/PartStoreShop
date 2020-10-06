package pl.example.PartStoreShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.example.PartStoreShop.dao.PartDao;
import pl.example.PartStoreShop.model.Part;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartService {

    private final PartDao partDao;

    @Autowired
    public PartService(@Qualifier("PartStoreShop") PartDao partDao) {
        this.partDao = partDao;
    }

    public int addPart(Part part) {
        return partDao.insertPart(part);
    }

    public List<Part> getAllParts() {
        return partDao.selectAllParts();
    }

    public Optional<Part> getPartById(UUID partnr) {
        return partDao.selectPartById(partnr);
    }

    public int deletePart(UUID partnr) {
        return partDao.deletePartByID(partnr);
    }

    public int updatePart(UUID partnr, Part newPart) {
        return partDao.updatePartById(partnr, newPart);
    }

}
