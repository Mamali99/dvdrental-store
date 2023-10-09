package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
public class Rental {
    @Id
    private Integer rental_id;
    private Timestamp rental_date;
    private Integer inventory_id;
    private Integer customer_id;
    private Timestamp return_date;
    private Integer staff_id;
    private Timestamp last_update;

}
