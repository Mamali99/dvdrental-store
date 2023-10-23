package services;

import entities.Rental;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Named
@Stateless
public class RentalService {

    @PersistenceContext
    private EntityManager entityManager;

    public void createRental(Rental rental) {
        entityManager.persist(rental);
    }

    public Rental getRentalById(int id) {
        return entityManager.find(Rental.class, id);
    }

    public void terminateRental(int id) {
        Rental rental = entityManager.find(Rental.class, id);
        // Implementierung der Logik zum Beenden der Vermietung
        entityManager.merge(rental);
    }
}
