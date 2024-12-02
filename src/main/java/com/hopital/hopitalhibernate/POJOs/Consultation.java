package com.hopital.hopitalhibernate.POJOs;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity

public class Consultation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Date heure;
    private String noteconsultation;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consultation() {
    }

    public Consultation(Date date, Date heure, String noteconsultation, Patient patient, Medecin medecin) {
        this.date = date;
        this.heure = heure;
        this.noteconsultation = noteconsultation;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", date=" + date +
                ", heure=" + heure +
                ", noteconsultation='" + noteconsultation + '\'' +
                ", patient=" + getPatient().getNom() +
                ", medecin=" + getMedecin().getNom() +
                '}';
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getNoteconsultation() {
        return noteconsultation;
    }

    public void setNoteconsultation(String noteconsultation) {
        this.noteconsultation = noteconsultation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
}
