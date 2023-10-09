package services;

import entities.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StoreService {

    @PersistenceContext
    private EntityManager entityManager;

    public int getNumberOfStores() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(s) FROM Store s", Long.class);
        return query.getSingleResult().intValue();
    }

    public Store getStoreById(int id) {
        return entityManager.find(Store.class, id);
    }
}
