package com.hopital.hopitalhibernate.POJOs;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Traitement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicament;
    private String dose;
    private String  duree;
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

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Traitement{" +
                "id=" + id +
                ", medicament='" + medicament + '\'' +
                ", dose='" + dose + '\'' +
                ", duree='" + duree + '\'' +
                ", patient=" + getPatient().getNom() +
                ", medecin=" + getMedecin().getNom() +
                '}';
    }

    public Traitement(String medicament, String dose, String  duree, Patient patient, Medecin medecin) {
        this.medicament = medicament;
        this.dose = dose;
        this.duree = duree;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Traitement() {
    }
}
