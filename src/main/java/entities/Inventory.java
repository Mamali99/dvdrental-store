package entities;

/*
Diese Klasse verknüpft Filme mit Stores und gibt an, welche Filme in welchem Store verfügbar sind.
 */

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;


import java.sql.Timestamp;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_inventory_id_seq")
    @SequenceGenerator(name = "inventory_inventory_id_seq", sequenceName = "public.inventory_inventory_id_seq", allocationSize = 1)
    private Integer inventory_id;

    @Column(name = "film_id")
    private Integer filmId;


    @JsonbTransient
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Integer getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Integer inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
