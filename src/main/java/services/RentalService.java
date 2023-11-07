package services;

import dto.RentalDTO;
import entities.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import utils.CustomerHref;
import utils.FilmHref;
import utils.StoreHref;

@Named
@Stateless
public class RentalService {

    @PersistenceContext
    private EntityManager entityManager;

    public void createRental(Rental rental) {
        entityManager.persist(rental);
    }

    public RentalDTO getRentalById(int id) {
        Rental rental = entityManager.find(Rental.class, id);
        if (rental == null) {
            return null;
        }

        RentalDTO dto = new RentalDTO();
        dto.setRentalId(rental.getRental_id());
        dto.setRentalDate(rental.getRentalDate()); //Format muss noch anpassen
        dto.setReturnDate(rental.getReturnDate()); //Format muss noch anpassen


        CustomerHref customerHref = new CustomerHref();
        customerHref.setHref("/customers/" + rental.getCustomer());
        dto.setCustomer(customerHref);

        StoreHref storeHref = new StoreHref();
        // Da die Store-Information nicht direkt in der Rental-Entität vorhanden ist,
        // nehmen wir an, dass sie über das Inventory-Objekt zugänglich ist.
        storeHref.setHref("/stores/" + rental.getInventory().getStore().getStore_id());
        dto.setStore(storeHref);

        FilmHref filmHref = new FilmHref();
        filmHref.setHref("/films/" + rental.getInventory().getFilmId());
        dto.setFilm(filmHref);

        return dto;
    }


    public void terminateRental(int id) {
        Rental rental = entityManager.find(Rental.class, id);
        // Implementierung der Logik zum Beenden der Vermietung
        entityManager.merge(rental);
    }
}
