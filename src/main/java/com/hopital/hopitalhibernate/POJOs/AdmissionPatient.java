package com.hopital.hopitalhibernate.POJOs;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class AdmissionPatient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Date heure;
    private String numeroChambre;
    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    @Override
    public String toString() {
        return "AdmissionPatient{" +
                "id=" + id +
                ", date=" + date +
                ", heure=" + heure +
                ", numeroChambre='" + numeroChambre + '\'' +
                ", patient=" + patient +
                ", medecin=" + medecin +
                '}';
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

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(String numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public AdmissionPatient(Date date, Date heure, String numeroChambre, Patient patient, Medecin medecin) {
        this.date = date;
        this.heure = heure;
        this.numeroChambre = numeroChambre;

    }

    public AdmissionPatient() {
    }
}
