package entities;
/*
 Diese Klasse enthält Informationen über das Personal, das in einem Store arbeitet.
 */
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_staff_id_seq")
    @SequenceGenerator(name = "staff_staff_id_seq", sequenceName = "public.staff_staff_id_seq", allocationSize = 1)
    private Integer staff_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "address_id")
    private Integer address;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonbTransient
    private Store store;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Column(name = "picture")
    private byte[] picture;
}
