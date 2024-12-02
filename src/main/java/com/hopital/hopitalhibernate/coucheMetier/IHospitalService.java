package com.hopital.hopitalhibernate.coucheMetier;

import com.hopital.hopitalhibernate.POJOs.AdmissionPatient;
import com.hopital.hopitalhibernate.POJOs.Consultation;
import com.hopital.hopitalhibernate.POJOs.Medecin;
import com.hopital.hopitalhibernate.POJOs.Patient;

import java.util.List;

public interface IHospitalService {
     Patient savePatient(Patient p);
     Medecin saveMedecin (Medecin m);
     AdmissionPatient saveAdmission(AdmissionPatient admissionPatient);
     Consultation saveConsultation(Consultation consultation);
     List<Medecin> listeMedecin();
     List<Patient> listePatient();
List<Consultation> listeConsultation();
List<AdmissionPatient> listeAdmission();
void supprimerPatient(Long id);
void supprimerMedecin(Long id);
Patient rechercherByIdP(Long id);
Medecin rechercherByIdM(Long id);



}