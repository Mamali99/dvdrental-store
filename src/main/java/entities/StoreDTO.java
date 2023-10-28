package entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@JsonPropertyOrder({"store_id", "manager_staff_id", "address_id", "last_update"})
@Getter
@Setter
public class StoreDTO {

    private Integer store_id;

    private Integer manager_staff_id;
    private Integer address_id;

    private Timestamp last_update;


}