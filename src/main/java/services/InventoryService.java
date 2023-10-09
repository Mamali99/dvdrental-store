package services;

import entities.Inventory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class InventoryService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Inventory> getInventoriesByFilmId(int filmId) {
        TypedQuery<Inventory> query = entityManager.createQuery("SELECT i FROM Inventory i WHERE i.film_id = :filmId", Inventory.class);
        query.setParameter("filmId", filmId);
        return query.getResultList();
    }

    public Inventory getInventoryById(int id) {
        return entityManager.find(Inventory.class, id);
    }
}
