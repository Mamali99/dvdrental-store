package services;

import entities.Staff;
import entities.StaffDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Base64;

@Named
@Stateless
public class StaffService {

    @PersistenceContext
    private EntityManager entityManager;

    public StaffDTO getStaffById(int id) {
        Staff s =  entityManager.find(Staff.class, id);
        StaffDTO staffDTO = convertToDTO(s);
        return staffDTO;
    }

    public StaffDTO convertToDTO(Staff staff) {
        StaffDTO dto = new StaffDTO();
        dto.setId(staff.getStaff_id());
        dto.setActive(staff.getActive());
        dto.setEmail(staff.getEmail());
        dto.setFirstName(staff.getFirstName());
        dto.setLastName(staff.getLastName());
        dto.setPassword(staff.getPassword());
        dto.setUsername(staff.getUsername());
        if (staff.getPicture() != null) {
            dto.setPicture(Base64.getEncoder().encodeToString(staff.getPicture()));
        }
        return dto;
    }
}
