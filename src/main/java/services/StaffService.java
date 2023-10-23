package services;

import entities.Staff;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Named
@Stateless
public class StaffService {

    @PersistenceContext
    private EntityManager entityManager;

    public Staff getStaffById(int id) {
        return entityManager.find(Staff.class, id);
    }
}
