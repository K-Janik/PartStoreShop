package pl.example.PartStoreShop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Part {

    private final UUID partnr;
   @NotBlank
    private final String partname;
   @NonNull
    double price;

    public Part(@JsonProperty("partnr") UUID partnr,
                @JsonProperty("partname") String partname,
                @JsonProperty("price") double price) {
        this.partnr = partnr;
        this.partname = partname;
        this.price = price;
    }

    public UUID getPartnr() {
        return partnr;
    }

    public String getPartname() {
        return partname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
