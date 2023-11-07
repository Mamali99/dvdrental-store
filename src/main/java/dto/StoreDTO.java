package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp last_update;


}