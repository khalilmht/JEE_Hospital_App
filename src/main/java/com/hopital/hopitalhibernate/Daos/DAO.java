package com.hopital.hopitalhibernate.Daos;

import java.util.List;


public interface DAO<T> {
public T save(T m);
public List<T> findAll();
public T findOne(Long id);
public T update(T m);
public void delete(Long id);
}
