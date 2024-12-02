package com.hopital.hopitalhibernate;

import com.hopital.hopitalhibernate.POJOs.AdmissionPatient;
import com.hopital.hopitalhibernate.POJOs.Consultation;
import com.hopital.hopitalhibernate.POJOs.Medecin;
import com.hopital.hopitalhibernate.POJOs.Patient;
import com.hopital.hopitalhibernate.coucheMetier.HospitalServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Time;
import java.util.Date;

public class Apptest {

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(HopitalApplication.class,args);
        HospitalServiceImpl hospitalService=context.getBean(HospitalServiceImpl.class);

        //liste de patient
        Patient p1 = new Patient("issa","moussa",new Date(),"n'djari","66608968");
        Patient p2 = new Patient("yacoub","moussa",new Date(),"n'djari","66608968");
        Patient p3 = new Patient("khalil","moussa",new Date(),"n'djari","66608968");
        Patient p4 = new Patient("hamid","moussa",new Date(),"n'djari","66608968");
        //liste de medecin
        Medecin m1= new Medecin("khalil","issa",new Date(),"Goudji","454545","genraliste");
        Medecin m2 = new Medecin("Moustapha","mht",new Date(),"Chagoua","99198233","Cardiologue");
        Medecin m3 = new Medecin("youssouf","mht",new Date(),"Atron","000000000","ophtalmologue");
        Medecin m4 = new Medecin(
                "khadidja","mht",new Date(),"Diguel","000000000","Nutritionniste");
//liste admission
        AdmissionPatient ad1= new AdmissionPatient(new Date(),new Time(8,23,12),"salle 01",p1,m1);
        AdmissionPatient ad2= new AdmissionPatient(new Date(),new Time(9,23,12),"salle 02",p2,m2);
        AdmissionPatient ad3= new AdmissionPatient(new Date(),new Time(10,23,12),"salle 03",p3,m3);
        AdmissionPatient ad4= new AdmissionPatient(new Date(),new Time(11,23,12),"salle 04",p4,m4);


        //consultation
        Consultation c1=new Consultation(new Date(),new Time(12,23,12),"il a palu",p1,m1);
        Consultation c2=new Consultation(new Date(),new Time(5,12,12),"il a fievre",p2,m2);
        Consultation c3=new Consultation(new Date(),new Time(14,23,12),"il a diabete",p3,m3);
        Consultation c4=new Consultation(new Date(),new Time(15,34,12),"il n'a aucune maladie",p4,m4);


        hospitalService.saveMedecin(m1);
        hospitalService.saveMedecin(m2);
        hospitalService.saveMedecin(m3);
        hospitalService.saveMedecin(m4);

        hospitalService.savePatient(p1);
        hospitalService.savePatient(p2);
        hospitalService.savePatient(p3);
        hospitalService.savePatient(p4);

        hospitalService.saveConsultation(c1);
        hospitalService.saveConsultation(c2);
        hospitalService.saveConsultation(c3);
        hospitalService.saveConsultation(c4);

        System.out.println("------------------------------------------");
        hospitalService.listeMedecin();
        System.out.println("------------------------------------------");
        hospitalService.listePatient();
        hospitalService.listeConsultation();
        hospitalService.listeAdmission();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        hospitalService.rechercherByIdP(1L);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    }
}
