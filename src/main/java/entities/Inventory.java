package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_inventory_id_seq")
    @SequenceGenerator(name = "inventory_inventory_id_seq", sequenceName = "public.inventory_inventory_id_seq", allocationSize = 1)
    private Integer inventory_id;

    @Column(name = "film_id")
    private Integer filmId;


    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

}
