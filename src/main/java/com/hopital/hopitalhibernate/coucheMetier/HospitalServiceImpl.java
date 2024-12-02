package com.hopital.hopitalhibernate.coucheMetier;

import com.hopital.hopitalhibernate.Daos.AdmissionDaoImpl;
import com.hopital.hopitalhibernate.Daos.ConsultationDaoImpl;
import com.hopital.hopitalhibernate.Daos.MedecinDaoImpl;
import com.hopital.hopitalhibernate.Daos.PatientDaoImpl;
import com.hopital.hopitalhibernate.POJOs.AdmissionPatient;
import com.hopital.hopitalhibernate.POJOs.Consultation;
import com.hopital.hopitalhibernate.POJOs.Medecin;
import com.hopital.hopitalhibernate.POJOs.Patient;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientDaoImpl patientRepository;
    private MedecinDaoImpl medecinRepository;
    private AdmissionDaoImpl admissionPatientRepository;
    private ConsultationDaoImpl consultationRepository;

    public HospitalServiceImpl(PatientDaoImpl patientRepository, MedecinDaoImpl medecinRepository, AdmissionDaoImpl admissionPatientRepository, ConsultationDaoImpl consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.admissionPatientRepository = admissionPatientRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public AdmissionPatient saveAdmission(AdmissionPatient admissionPatient) {
        return admissionPatientRepository.save(admissionPatient);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }


    @Override
    public List<Medecin> listeMedecin() {
        List<Medecin> m=medecinRepository.findAll();
        for (Medecin ma:m){
            System.out.println(ma.toString());
        }
        return m;
//        return medecinRepository.findAll();
    }

    @Override
    public List<Patient> listePatient() {
//        return patientRepository.findAll().toString();
    List<Patient> p=patientRepository.findAll();
    for (Patient patient:p){
        System.out.println(patient.toString());
    }
    return p;
    }

    @Override
    public List<Consultation> listeConsultation() {
//        return consultationRepository.findAll();
    List<Consultation> c=consultationRepository.findAll();
    for (Consultation consultation:c){
        System.out.println(consultation.toString());
    }
    return c;
    }

    @Override
    public List<AdmissionPatient> listeAdmission() {
//        return admissionPatientRepository.findAll();

        List<AdmissionPatient> ad=admissionPatientRepository.findAll();
        for (AdmissionPatient admissionPatient:ad){
            System.out.println(ad.toString());
        }
        return ad;
    }

    @Override
    public void supprimerPatient(Long id) {
        patientRepository.delete(id);
    }

    @Override
    public void supprimerMedecin(Long id) {
medecinRepository.delete(id);
    }

    @Override
    public Patient rechercherByIdP(Long id) {
//        return patientRepository.findOne(id);
    Patient p=patientRepository.findOne(id);
        System.out.println(p.toString());
        return p;
    }

    @Override
    public Medecin rechercherByIdM(Long id) {
        return medecinRepository.findOne(id);
    }


}
