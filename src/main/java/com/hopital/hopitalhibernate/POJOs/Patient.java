package com.hopital.hopitalhibernate.POJOs;

import java.io.Serializable;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Patient implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nom;
        private String prenom;
        private Date dateNaissance;
        private String adresse;
        private String contact;
        @OneToMany(mappedBy="patient")
       private Collection<Consultation> consultations;
        @OneToMany(mappedBy="patient")
        private Collection<AdmissionPatient> admissionPatients;
        @OneToMany(mappedBy="patient")
        private Collection<SortiePatient> sortiePatients;

        @OneToMany(mappedBy="patient")
        private Collection<Traitement> traitements;



        public Patient() {
        }
        @Override
        public String toString()
        {
                return "Patient"
                        + "{"
                        +" ID :" +id+
                        "nom :" +nom+
                        " prenom :" +prenom+
                        " Adresse :" +adresse+
                        " Contact :" +contact+
                        " date :" +dateNaissance+"}";

        }

        public void setNom(String nom) {
                this.nom = nom;
        }

        public void setPrenom(String prenom) {
                this.prenom = prenom;
        }

        public void setDateNaissance(Date dateNaissance) {
                this.dateNaissance = dateNaissance;
        }

        public void setAdresse(String adresse) {
                this.adresse = adresse;
        }

        public void setContact(String contact) {
                this.contact = contact;
        }

        public Patient(String nom, String prenom, Date dateNaissance, String adresse, String contact) {

                this.nom = nom;
                this.prenom = prenom;
                this.dateNaissance = dateNaissance;
                this.adresse = adresse;
                this.contact = contact;
        }


        public String getNom() {
                return nom;
        }

        public String getPrenom() {
                return prenom;
        }

        public Date getDateNaissance() {
                return dateNaissance;
        }

        public String getAdresse() {
                return adresse;
        }

        public String getContact() {
                return contact;
        }


}
