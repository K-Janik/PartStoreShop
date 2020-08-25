package pl.example.PartStoreShop.dao;

import pl.example.PartStoreShop.model.Part;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartDao {
    int insertPart(UUID partnr, Part part);

    default int insertPart(Part part) {
        UUID partid = UUID.randomUUID();
        return insertPart(partid, part);
    }

    List<Part> selectAllParts();

    Optional<Part> selectPartById(UUID partid);

    int deletePartByID(UUID partid);

    int updtePartById(UUID partid, Part part);


}
