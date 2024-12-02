package com.hopital.hopitalhibernate;

import com.hopital.hopitalhibernate.Daos.*;
import com.hopital.hopitalhibernate.POJOs.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class hopitalApplicationTest {

	public static void main(String[] args) {
ApplicationContext context=SpringApplication.run(hopitalApplicationTest.class,args);
		ConsultationDaoImpl consultationDao=context.getBean(ConsultationDaoImpl.class);
		MedecinDaoImpl medecinDao=context.getBean(MedecinDaoImpl.class);
		PatientDaoImpl patientDao = context.getBean(PatientDaoImpl.class);
		AdmissionDaoImpl admissionDao= context.getBean(AdmissionDaoImpl.class);
		TraitementDaoImpl traitementDao =context.getBean(TraitementDaoImpl.class);
		SortiePatientDaoImpl sortiePatientDao =context.getBean(SortiePatientDaoImpl.class);
		UtilisateurDaoImpl utilisateurDao = context.getBean(UtilisateurDaoImpl.class);

		//medecin
		Medecin m1= new Medecin("khalil","issa",new Date(),"Goudji","454545","genraliste");
		Medecin m2 = new Medecin("Moustapha","mht",new Date(),"Chagoua","99198233","Cardiologue");
		Medecin m3 = new Medecin("youssouf","mht",new Date(),"Atron","000000000","ophtalmologue");
		Medecin m4 = new Medecin("khadidja","mht",new Date(),"Diguel","000000000","Nutritionniste");
		medecinDao.save(m1);
		medecinDao.save(m2);
		medecinDao.save(m3);
		medecinDao.save(m4);

		//patient
		Patient p1 = new Patient("issa","moussa",new Date(),"n'djari","66608968");
		Patient p2 = new Patient("yacoub","moussa",new Date(),"n'djari","66608968");
		Patient p3 = new Patient("khalil","moussa",new Date(),"n'djari","66608968");
		Patient p4 = new Patient("hamid","moussa",new Date(),"n'djari","66608968");
		patientDao.save(p1);
		patientDao.save(p2);
		patientDao.save(p3);
		patientDao.save(p4);


		//admission

		AdmissionPatient ad1= new AdmissionPatient(new Date(),new Time(8,23,12),"salle 01",p1,m1);
		AdmissionPatient ad2= new AdmissionPatient(new Date(),new Time(9,23,12),"salle 02",p2,m2);
		AdmissionPatient ad3= new AdmissionPatient(new Date(),new Time(10,23,12),"salle 03",p3,m3);
		AdmissionPatient ad4= new AdmissionPatient(new Date(),new Time(11,23,12),"salle 04",p4,m4);
		admissionDao.save(ad1);
		admissionDao.save(ad2);
		admissionDao.save(ad3);
		admissionDao.save(ad4);

		//consultation
		 Consultation c1=new Consultation(new Date(),new Time(12,23,12),"il a palu",p1,m1);
		Consultation c2=new Consultation(new Date(),new Time(5,12,12),"il a fievre",p2,m2);
		Consultation c3=new Consultation(new Date(),new Time(14,23,12),"il a diabete",p3,m3);
		Consultation c4=new Consultation(new Date(),new Time(15,34,12),"il n'a aucune maladie",p4,m4);
		consultationDao.save(c1);
		consultationDao.save(c2);
		consultationDao.save(c3);
		consultationDao.save(c4);

		//traitement

		Traitement traitement1 = new Traitement("paracetamol","500 mg","20 jours",p1,m1);
		Traitement traitement2 = new Traitement("paracetamol","500 mg","7 jours",p2,m2);
		Traitement traitement3 = new Traitement("paracetamol","500 mg","10 jours",p3,m3);
		Traitement traitement4 = new Traitement("paracetamol","500 mg","30 jours",p4,m4);
		traitementDao.save(traitement1);
		traitementDao.save(traitement2);
		traitementDao.save(traitement3);
		traitementDao.save(traitement4);
		//sortie patient

		SortiePatient s1 = new SortiePatient(new Date(12,04,2024),new Time(12,32,12),p1);
		SortiePatient s2 = new SortiePatient(new Date(12,04,2024),new Time(12,32,12),p1);
		SortiePatient s3 = new SortiePatient(new Date(12,04,2024),new Time(12,32,12),p1);
		SortiePatient s4 = new SortiePatient(new Date(12,04,2024),new Time(12,32,12),p1);
		sortiePatientDao.save(s1);
		sortiePatientDao.save(s2);
		sortiePatientDao.save(s3);
		sortiePatientDao.save(s4);

		//utilisateur
		Utilisateur u1=new AdminUser("khalil","mht","khalilmht@gmail.com","moi1234","N'djari");
		Utilisateur u2=new StandardUser("khalil","yacoub","khalilmht@gmail.com","moi1234","N'djari");
		Utilisateur u3=new AdminUser("test","test","test@gmail.com","moi1234","N'djari");
		Utilisateur u4=new AdminUser("mht","khalil","khalilmht@gmail.com","moi1234","N'djari");
		utilisateurDao.save(u1);
		utilisateurDao.save(u2);
		utilisateurDao.save(u3);
		utilisateurDao.save(u4);

	//afficher tout
		System.out.println("*******Patients List Begin *******");
		List<Patient> patientList= patientDao.findAll();
		for (Patient p:patientList){
			System.out.println(p.toString());
		}
		System.out.println("*******Patients List End *******\n");

		System.out.println("*******Medecin List Begin *******");
		List<Medecin> medecinsList= medecinDao.findAll();
		for (Medecin m:medecinsList){
			System.out.println(m.toString());
		}
		System.out.println("*******Medecins List End *******\n");
		System.out.println("*******Consultations List Begin *******");
		List<Consultation> consultationList= consultationDao.findAll();
		for (Consultation c:consultationList){
			System.out.println(c.toString());
		}
		System.out.println("*******Consultations List End *******\n");

		System.out.println("******Traitement List Begin *******");
		List<Traitement> traitementList= traitementDao.findAll();
		for (Traitement t:traitementList){
			System.out.println(t.toString());
		}
		System.out.println("*******Traitement List End *******\n");

		System.out.println("*******Sortie Patient List Begin *******");
		List<SortiePatient> sortiePatientList= sortiePatientDao.findAll();
		for (SortiePatient s:sortiePatientList){
			System.out.println(s.toString());
		}
		System.out.println("*******Sortie Patient List End *******\n");

		System.out.println("@@@@@@@@@@  SEARCH BY ID @@@@@@@@@@@");
		Patient patients = patientDao.findOne(1l);

		System.out.println(patients.toString());
		Medecin medecin = medecinDao.findOne(2l);
		System.out.println(medecin.toString());
		Consultation consultation = consultationDao.findOne(2l);
		System.out.println(consultation.toString());


		System.out.println("################### End Execution #######################");



	}

}
