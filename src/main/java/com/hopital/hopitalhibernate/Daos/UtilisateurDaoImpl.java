package com.hopital.hopitalhibernate.Daos;

import com.hopital.hopitalhibernate.POJOs.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UtilisateurDaoImpl implements DAO<Utilisateur> {



    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Utilisateur save(Utilisateur m) {
        entityManager.persist(m);
        return m;
    }

    @Override
    public List<Utilisateur> findAll() {
        Query req = entityManager.createQuery("select p from Utilisateur p");
        return req.getResultList();
    }

    @Override
    public Utilisateur findOne(Long id) {
        Utilisateur m=entityManager.find(Utilisateur.class,id);
        return m;
    }

    @Override
    public Utilisateur update(Utilisateur m) {
        entityManager.merge(m);
        return  m;}

    @Override
    public void delete(Long id) {
        Utilisateur utilisateur=entityManager.find(Utilisateur.class,id);
        entityManager.remove(utilisateur);

    }
}
