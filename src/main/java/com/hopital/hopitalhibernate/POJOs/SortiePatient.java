package com.hopital.hopitalhibernate.POJOs;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
public class SortiePatient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Time heure;

    @ManyToOne
    private Patient patient;


    public SortiePatient(Date date, Time heure, Patient patient) {
        this.date = date;
        this.heure = heure;
        this.patient = patient;
    }

    public SortiePatient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setDate(Date dose) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SortiePatient{" +
                "id=" + id +
                ", date=" + date +
                ", heure=" + heure +
                ", patient=" + getPatient().getNom() +
                '}';
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }


}
