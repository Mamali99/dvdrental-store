package services;

import entities.FilmHref;
import entities.Inventory;
import entities.InventoryDTO;
import entities.StoreHref;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.stream.Collectors;

@Named
@Stateless
public class InventoryService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<InventoryDTO> getInventoriesByFilmId(int filmId) {
        List<Inventory> inventories = entityManager.createQuery("SELECT i FROM Inventory i WHERE i.filmId = :filmId", Inventory.class)
                .setParameter("filmId", filmId)
                .getResultList();
        List<InventoryDTO> inventoryDTOs = inventories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return inventoryDTOs;
    }

    private InventoryDTO convertToDTO(Inventory inventory) {
        InventoryDTO dto = new InventoryDTO();
        dto.setId(inventory.getInventory_id());

        StoreHref storeHref = new StoreHref();
        storeHref.setHref("/stores/" + inventory.getStore().getStore_id());
        dto.setStore(storeHref);

        FilmHref filmHref = new FilmHref();
        filmHref.setHref("/films/" + inventory.getFilmId());
        dto.setFilm(filmHref);

        return dto;
    }




    public InventoryDTO getInventoryById(int id) {
        Inventory inventory = entityManager.find(Inventory.class, id);
        InventoryDTO dto = convertToDTO(inventory);


        return dto;
    }
}
