package com.hopital.hopitalhibernate.Daos;

import com.hopital.hopitalhibernate.POJOs.Medecin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class MedecinDaoImpl implements DAO<Medecin> {
@PersistenceContext
    private EntityManager entityManager;

    @Override
    public Medecin save(Medecin m) {
       entityManager.persist(m);
       return m;
    }

    @Override
    public List<Medecin> findAll() {
        Query req = entityManager.createQuery("select m from Medecin m");
        return req.getResultList();
    }

    @Override
    public Medecin findOne(Long id) {
Medecin m=entityManager.find(Medecin.class,id);
return m;
    }

    @Override
    public Medecin update(Medecin m) {

        entityManager.merge(m);
    return  m;}

    @Override
    public void delete(Long id) {
Medecin medecin=entityManager.find(Medecin.class,id);
entityManager.remove(medecin);
    }
}
