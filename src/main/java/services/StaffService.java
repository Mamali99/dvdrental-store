package services;

import entities.Staff;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class StaffService {

    @PersistenceContext
    private EntityManager entityManager;

    public Staff getStaffById(int id) {
        return entityManager.find(Staff.class, id);
    }
}
