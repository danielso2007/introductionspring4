package br.com.estudo.introductionspring4.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> extends Serializable {

    public void save(T obj);
    public T update(T obj);
    public T findById(ID id);
    public void delete(T obj);
    public List<T> list();
    
}
