package br.com.estudo.introductionspring4.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface GenericDao<T, ID extends Serializable> extends Serializable {

    public void save(T obj) throws DataAccessException;
    public T update(T obj) throws DataAccessException;
    public T findById(ID id) throws DataAccessException;
    public void delete(T obj) throws DataAccessException;
    public List<T> list() throws DataAccessException;
    
}
