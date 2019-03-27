package com.restowa.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="stores")
public class Store implements Serializable{
    
    @Id
    @Column(name = "id")
    private int ID;
    
    @Column(name = "key")
    private String key;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "phonenumber")
    private String phoneNumber;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "lattitude")
    private float lattitude;
    
    @Column(name = "longitude")
    private float longitude;
    
    @Column(name = "lastmodifieddate")
    private Date lastModifiedDate;
    
    @ManyToOne
    @JoinColumn(name = "lastmodifiedby")
    private UserAccount lastModifiedBy;
    
    @ManyToOne
    @JoinColumn(name = "idaddress")
    private Address address;
    
    @OneToMany(mappedBy="store")
    private Set<OpeningHours> openinghours;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getLattitude() {
        return lattitude;
    }

    public void setLattitude(float lattitude) {
        this.lattitude = lattitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public UserAccount getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(UserAccount lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<OpeningHours> getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(Set<OpeningHours> openinghours) {
        this.openinghours = openinghours;
    }
    
}
