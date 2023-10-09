package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Staff {
    @Id
    private Integer staff_id;
    private String first_name;
    private String last_name;
    private Integer address_id;
    private String email;
    private Integer store_id;
    private Boolean active;
    private String username;
    private String password;
    private Timestamp last_update;
    private Byte[] picture;
}
