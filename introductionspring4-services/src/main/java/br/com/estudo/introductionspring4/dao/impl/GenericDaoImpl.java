package br.com.estudo.introductionspring4.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.introductionspring4.dao.GenericDao;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    private static final long serialVersionUID = 1L;

    Class<T> typeClass;

    @PersistenceContext
    EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
            this.typeClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } else {
            typeClass = (Class<T>) getClass().getGenericSuperclass();
        }
    }
    
    @Override
    public void save(T obj) throws DataAccessException {
        entityManager.persist(obj);
    }
    
    @Override
    public T update(T obj) throws DataAccessException {
        return entityManager.merge(obj);
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) throws DataAccessException {
        return entityManager.find(typeClass, id);
    }

    @Override
    public void delete(T obj) throws DataAccessException {
        entityManager.remove(obj);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> list() throws DataAccessException {
        return entityManager.createQuery("FROM " + typeClass.getName() + " ORDER BY id", typeClass).getResultList();
    }

}
