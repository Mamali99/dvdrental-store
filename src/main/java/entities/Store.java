package entities;
/*
Diese Klasse enthält Informationen über den Store, einschließlich des Managers und der Adresse des Stores.
 */

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_store_id_seq")
    @SequenceGenerator(name = "store_store_id_seq", sequenceName = "public.store_store_id_seq", allocationSize = 1)
    private Integer store_id;


    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    private Staff manager;


    @Column(name = "address_id")
    private Integer address;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
