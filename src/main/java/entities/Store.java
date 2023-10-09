package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
public class Store {
    @Id
    private Integer store_id;
    private Integer manager_staff_id;
    private Integer address_id;
    private Timestamp last_update;
}
