package com.hopital.hopitalhibernate.Daos;

import com.hopital.hopitalhibernate.POJOs.Consultation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional

public class ConsultationDaoImpl implements DAO<Consultation> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Consultation save(Consultation m) {
        entityManager.persist(m);
        return m;
    }

    @Override
    public List<Consultation> findAll() {
        Query req = entityManager.createQuery("select c from Consultation c");
        return req.getResultList();

    }

    @Override
    public Consultation findOne(Long id) {
        Consultation m=entityManager.find(Consultation.class,id);
        return m;

    }

    @Override
    public Consultation update(Consultation m) {

        entityManager.merge(m);
        return  m;
    }

    @Override
    public void delete(Long id) {
        Consultation consultation=entityManager.find(Consultation.class,id);
        entityManager.remove(consultation);
    }
}
