package com.restowa.domain.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UserAccounts")
public class UserAccount implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "firstname")
    @NotEmpty
    private String firstname;
    
    @NotEmpty
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;
    
    @Column(name = "password")
    @Size(min = 8, max  =50)
    private String password;
    
    @NotEmpty
    @Column(name = "phonenumber")
    private String phoneNumber;
    
    @Column(name = "active")
    private boolean active;
    
    @Column(name = "creationdate")
    private Date creationDate;
    
    @Column(name = "lastmodificationdate")
    private Date lastModificationDate;
    
    @Column(name = "resetpasswordlink")
    private String resetPasswordLink;
    
    @Column(name = "resetlinkvalidatedate")
    private Date resetLinkValidateDate;
    
    @Column(name = "isremoved")
    private boolean removed;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtype")
    private TypeUser type;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idaddress")
    private Address address;
    
    @Column(name = "token")
    private String token;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getResetPasswordLink() {
        return resetPasswordLink;
    }

    public void setResetPasswordLink(String resetPasswordLink) {
        this.resetPasswordLink = resetPasswordLink;
    }

    public Date getResetLinkValidateDate() {
        return resetLinkValidateDate;
    }

    public void setResetLinkValidateDate(Date resetLinkValidateDate) {
        this.resetLinkValidateDate = resetLinkValidateDate;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public TypeUser getType() {
        return type;
    }

    public void setType(TypeUser type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
