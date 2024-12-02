package com.hopital.hopitalhibernate.Daos;

import com.hopital.hopitalhibernate.POJOs.SortiePatient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional

public class SortiePatientDaoImpl implements DAO<SortiePatient> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SortiePatient save(SortiePatient m) {
        entityManager.persist(m);
        return m;
    }

    @Override
    public List<SortiePatient> findAll() {
        Query req = entityManager.createQuery("select p from SortiePatient p");
        return req.getResultList();
    }

    @Override
    public SortiePatient findOne(Long id) {
        SortiePatient m=entityManager.find(SortiePatient.class,id);
        return m;
    }

    @Override
    public SortiePatient update(SortiePatient m) {

        entityManager.merge(m);
        return  m;
    }

    @Override
    public void delete(Long id) {
        SortiePatient patient=entityManager.find(SortiePatient.class,id);
        entityManager.remove(patient);
    }
}
