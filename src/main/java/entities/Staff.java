package entities;
/*
 Diese Klasse enthält Informationen über das Personal, das in einem Store arbeitet.
 */
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_staff_id_seq")
    @SequenceGenerator(name = "staff_staff_id_seq", sequenceName = "public.staff_staff_id_seq", allocationSize = 1)
    private Integer staff_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "address_id")
    private Integer address;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @JsonbTransient
    private Store store;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Column(name = "picture")
    private byte[] picture;

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
