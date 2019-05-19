package com.restowa.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="stores")
public class Store implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    
    @Column(name = "mykey")
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
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idaddress")
    @Cascade({CascadeType.ALL})
    private Address address;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
    @Cascade({CascadeType.ALL})
    private Set<OpeningHours> openinghours;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idowner")
    private UserAccount owner;

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

    public UserAccount getOwner() {
        return owner;
    }

    public void setOwner(UserAccount owner) {
        this.owner = owner;
    }
    
}
