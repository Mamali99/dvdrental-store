package entities;

/*
 Diese Klasse verknüpft Kunden mit den Filmen, die sie ausgeliehen haben, und gibt an, welche Filme von welchem Kunden ausgeliehen wurden.
 */

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;


import java.sql.Timestamp;

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


    public Integer getRental_id() {
        return rental_id;
    }

    public void setRental_id(Integer rental_id) {
        this.rental_id = rental_id;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
