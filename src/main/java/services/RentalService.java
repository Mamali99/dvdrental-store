package services;

import dto.RentalDTO;
import entities.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import utils.*;

import java.sql.Timestamp;

@Named
@Stateless
public class RentalService {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    CustomerServiceClient customerServiceClient;

    public RentalDTO createRental(RentalValue rentalValue) {

        Rental rental = new Rental();
        rental.setRentalDate(rentalValue.getRentalDate());
        rental.setCustomer(rentalValue.getCustomerId());
        Inventory inventory = entityManager.find(Inventory.class, rentalValue.getInventoryId());
        rental.setInventory(inventory);
        Staff staff = entityManager.find(Staff.class, rentalValue.getStaffId());
        rental.setStaff(staff);
        rental.setReturnDate(rentalValue.getReturnDate());
        rental.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        entityManager.persist(rental);
        return convertToRentalDTO(rental);

    }

    public boolean isValidRentalValue(RentalValue rentalValue) {
        if (rentalValue == null) {
            return false;
        }

        // Überprüfung, ob das Feld 'rentalDate' gesetzt ist
        if (rentalValue.getRentalDate() == null) {
            return false;
        }

        // Überprüfen, ob 'inventoryId' existiert und gültig ist
        if (rentalValue.getInventoryId() == null || !isValidInventory(rentalValue.getInventoryId())) {
            return false;
        }

        // Überprüfen, ob 'customerId' existiert und gültig ist
        if (rentalValue.getCustomerId() == null || !isValidCustomer(rentalValue.getCustomerId())) {
            return false;
        }

        // Überprüfen, ob 'staffId' existiert und gültig ist
        if (rentalValue.getStaffId() == null || !isValidStaff(rentalValue.getStaffId())) {
            return false;
        }

        return true;
    }

    private boolean isValidInventory(Integer inventoryId) {
        Inventory inventory = entityManager.find(Inventory.class, inventoryId);
        return inventory != null;
    }

    private boolean isValidCustomer(Integer customerId) {
        //hier muss eine Anfrage an Customer-Microservice schicken und kontrollieren, ob diese Customer existiert.
        return customerServiceClient.checkCustomerExists(customerId);
    }

    private boolean isValidStaff(Integer staffId) {
        Staff staff = entityManager.find(Staff.class, staffId);
        return staff != null;
    }




    public RentalDTO getRentalById(int id) {
        Rental rental = entityManager.find(Rental.class, id);
        if (rental == null) {
            return null;
        }
        return convertToRentalDTO(rental);
    }

    public RentalDTO convertToRentalDTO(Rental rental) {

        if (rental == null) {
            return null;
        }

        RentalDTO dto = new RentalDTO();
        dto.setRentalId(rental.getRental_id());
        dto.setRentalDate(rental.getRentalDate());
        dto.setReturnDate(rental.getReturnDate());

        CustomerHref customerHref = new CustomerHref();
        customerHref.setHref("http://localhost:8083/customers/" + rental.getCustomer());
        dto.setCustomer(customerHref);

        StoreHref storeHref = new StoreHref();
        storeHref.setHref("http://localhost:8082/stores/" + rental.getInventory().getStore().getStore_id());
        dto.setStore(storeHref);

        FilmHref filmHref = new FilmHref();
        filmHref.setHref("http://localhost:8081/films/" + rental.getInventory().getFilmId());
        dto.setFilm(filmHref);

        return dto;
    }

    public void terminateRental(int id) {
        Rental rental = entityManager.find(Rental.class, id);
        // Implementierung der Logik zum Beenden der Vermietung
        entityManager.merge(rental);
    }
}
