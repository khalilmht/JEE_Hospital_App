package com.hopital.hopitalhibernate.Daos;

import com.hopital.hopitalhibernate.POJOs.Traitement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class TraitementDaoImpl implements DAO<Traitement> {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Traitement save(Traitement m) {
        entityManager.persist(m);
        return m;    }

    @Override
    public List<Traitement> findAll() {
        Query req = entityManager.createQuery("select p from Traitement p");
        return req.getResultList();
    }

    @Override
    public Traitement findOne(Long id) {
        Traitement m=entityManager.find(Traitement.class,id);
        return m;
    }

    @Override
    public Traitement update(Traitement m) {

        entityManager.merge(m);
        return  m;}

    @Override
    public void delete(Long id) {
        Traitement traitement=entityManager.find(Traitement.class,id);
        entityManager.remove(traitement);
    }
}
