package com.restowa.domain.model;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="openinghours")
public class OpeningHours implements Serializable {
    
    @Id
    @Column(name = "id")
    private int ID;
    
    @ManyToOne
    @JoinColumn(name="idstore")
    private Store store;
    
    @Column(name = "day")
    private String day;
    
    @Column(name = "from")
    private Time from;
    
    @Column(name = "to")
    private Time to;
    
    @Column(name = "close")
    private boolean closed;
    
    @Column(name = "24h")
    private boolean allDay;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getFrom() {
        return from;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(Time to) {
        this.to = to;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }
    
    
    
}
