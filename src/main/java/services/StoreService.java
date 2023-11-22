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

        Store store = entityManager.find(Store.class, id);

        if(store == null) {
            return null;
        }


        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreId(store.getStore_id());
        storeDTO.setManagerStaffId(store.getManager() != null ? store.getManager().getStaff_id() : null);
        storeDTO.setAddressId(store.getAddress());
        storeDTO.setLastUpdate(store.getLastUpdate());


        return storeDTO;
    }

}
