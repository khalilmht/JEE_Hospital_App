package com.hopital.hopitalhibernate.Daos;

import com.hopital.hopitalhibernate.POJOs.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class PatientDaoImpl implements DAO<Patient> {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Patient save(Patient m) {
        entityManager.persist(m);
        return m;

    }

    @Override
    public List<Patient> findAll() {
        Query req = entityManager.createQuery("select p from Patient p");
        return req.getResultList();
    }

    @Override
    public Patient findOne(Long id) {
        Patient m=entityManager.find(Patient.class,id);
        return m;
    }

    @Override
    public Patient update(Patient m) {
        entityManager.merge(m);
        return  m;
    }

//    public Patient updatePatient(Patient patient){
//            Query requeteSql =entityManager.createQuery("UPDATE Patient SET `nom` = ? WHERE id = ?");
//
//        return patient;
//    }

    @Override
    public void delete(Long id) {
        Patient patient=entityManager.find(Patient.class,id);
        entityManager.remove(patient);
    }
}
