package services;

import entities.Inventory;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
@Named
@Stateless
public class InventoryService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Inventory> getInventoriesByFilmId(int filmId) {

        return null;
    }

    public Inventory getInventoryById(int id) {
        return entityManager.find(Inventory.class, id);
    }
}
