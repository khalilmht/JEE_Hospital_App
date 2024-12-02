package com.hopital.hopitalhibernate.POJOs;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity

public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String contact;
    private String specialite;
    @OneToMany(mappedBy="medecin")
    private Collection<Consultation> consultations;
    @OneToMany(mappedBy="medecin")
    private Collection<AdmissionPatient> admissionPatients;

    @OneToMany(mappedBy="medecin")
    private Collection<Traitement> traitements;




    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", adresse='" + adresse + '\'' +
                ", contact='" + contact + '\'' +
                ", specialite='" + specialite + '\'' +

                '}';
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Collection<Consultation> getConsultations() {
        return consultations;
    }

    public Collection<AdmissionPatient> getAdmissionPatients() {
        return admissionPatients;
    }

    public Collection<Traitement> getTraitements() {
        return traitements;
    }

    public Medecin(String nom, String prenom, Date dateNaissance, String adresse, String contact, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.contact = contact;
        this.specialite = specialite;
    }

    public Medecin() {
    }
}
