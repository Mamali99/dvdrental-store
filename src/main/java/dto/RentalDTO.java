package dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import utils.CustomerHref;
import utils.FilmHref;
import utils.StoreHref;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@JsonPropertyOrder({"rentalId", "rentalDate", "returnDate", "customer", "store", "film"})
@Getter
@Setter
public class RentalDTO {

    private Integer rentalId;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private CustomerHref customer;
    private StoreHref store;
    private FilmHref film;



}
