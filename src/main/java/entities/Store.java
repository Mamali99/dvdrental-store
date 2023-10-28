package entities;
/*
Diese Klasse enthält Informationen über den Store, einschließlich des Managers und der Adresse des Stores.
 */
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_store_id_seq")
    @SequenceGenerator(name = "store_store_id_seq", sequenceName = "public.store_store_id_seq", allocationSize = 1)
    private Integer store_id;


    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    @JsonbTransient
    private Staff manager;


    @Column(name = "address_id")
    private Integer address;

    @Column(name = "last_update")
    private Timestamp lastUpdate;


}
