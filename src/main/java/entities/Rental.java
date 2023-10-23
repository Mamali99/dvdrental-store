package entities;

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
    private Inventory inventory;


    @Column(name = "customer_id")
    private Integer customer;

    @Column(name = "return_date")
    private Timestamp returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

}
