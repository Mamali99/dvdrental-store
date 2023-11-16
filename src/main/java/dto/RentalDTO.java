package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import utils.CustomerHref;
import utils.FilmHref;
import utils.StoreHref;

import java.sql.Timestamp;

@JsonPropertyOrder({"rentalId", "rentalDate", "returnDate", "customer", "store", "film"})
public class RentalDTO {

    private Integer rentalId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp rentalDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp returnDate;
    private CustomerHref customer;
    private StoreHref store;
    private FilmHref film;

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public CustomerHref getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerHref customer) {
        this.customer = customer;
    }

    public StoreHref getStore() {
        return store;
    }

    public void setStore(StoreHref store) {
        this.store = store;
    }

    public FilmHref getFilm() {
        return film;
    }

    public void setFilm(FilmHref film) {
        this.film = film;
    }
}
