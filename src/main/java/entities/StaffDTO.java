package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDTO {
    private Integer id;
    private Boolean active;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String picture; // Dies wird als Base64-kodierter String gespeichert
}
