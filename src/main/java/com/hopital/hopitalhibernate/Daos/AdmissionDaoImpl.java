package com.hopital.hopitalhibernate.Daos;

import com.hopital.hopitalhibernate.POJOs.AdmissionPatient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class AdmissionDaoImpl implements DAO<AdmissionPatient> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AdmissionPatient save(AdmissionPatient m) {
        entityManager.persist(m);
        return m;

    }

    @Override
    public List<AdmissionPatient> findAll() {
        Query req = entityManager.createQuery("select a from AdmissionPatient a");
        return req.getResultList();
    }

    @Override
    public AdmissionPatient findOne(Long id) {
        AdmissionPatient m=entityManager.find(AdmissionPatient.class,id);
        return m;
     }

    @Override
    public AdmissionPatient update(AdmissionPatient m) {

        entityManager.merge(m);
        return  m;
    }


    @Override
    public void delete(Long id) {
        AdmissionPatient admissionPatient=entityManager.find(AdmissionPatient.class,id);
        entityManager.remove(admissionPatient);
    }
}