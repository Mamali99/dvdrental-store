package entities;

/*
 Diese Klasse verknüpft Kunden mit den Filmen, die sie ausgeliehen haben, und gibt an, welche Filme von welchem Kunden ausgeliehen wurden.
 */

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_rental_id_seq")
    @SequenceGenerator(name = "rental_rental_id_seq", sequenceName = "public.rental_rental_id_seq", allocationSize = 1)
    private Integer rental_id;

    @Column(name = "rental_date")
    private Timestamp rentalDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    @JsonbTransient
    private Inventory inventory;


    @Column(name = "customer_id")
    private Integer customer;

    @Column(name = "return_date")
    private Timestamp returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    @JsonbTransient
    private Staff staff;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

}
