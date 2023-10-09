package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
public class Inventory {
    @Id
    private Integer inventory_id;
    private Integer film_id;
    private Integer store_id;
    private Timestamp last_update;
}
