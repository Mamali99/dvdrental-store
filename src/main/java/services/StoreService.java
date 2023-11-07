package services;

import entities.Store;
import dto.StoreDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Named
@Stateless
public class StoreService {

    @PersistenceContext
    private EntityManager entityManager;

    public Integer getNumberOfStores() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(s) FROM Store s", Long.class);
        return query.getSingleResult().intValue();
    }

    public StoreDTO getStoreById(int id) {
        // 1. Store-Objekt aus der Datenbank holen
        Store store = entityManager.find(Store.class, id);

        // Überprüfen, ob das Store-Objekt existiert
        if(store == null) {
            return null; // oder werfen Sie eine passende Ausnahme, je nach Ihrem Design
        }

        // 2. Store-Objekt in ein StoreDTO-Objekt konvertieren
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStore_id(store.getStore_id());
        storeDTO.setManager_staff_id(store.getManager() != null ? store.getManager().getStaff_id() : null);
        storeDTO.setAddress_id(store.getAddress());
        storeDTO.setLast_update(store.getLastUpdate());

        // 3. Das StoreDTO-Objekt zurückgeben
        return storeDTO;
    }

}
