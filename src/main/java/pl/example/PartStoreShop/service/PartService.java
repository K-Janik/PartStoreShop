package pl.example.PartStoreShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.example.PartStoreShop.dao.PartDao;
import pl.example.PartStoreShop.model.Part;

@Service
public class PartService {

    private final PartDao partDao;

    @Autowired
    public PartService(@Qualifier("fakeDao") PartDao partDao) {
        this.partDao = partDao;
    }

    public int addPart(Part part) {
        return partDao.insertPart(part);
    }

}
