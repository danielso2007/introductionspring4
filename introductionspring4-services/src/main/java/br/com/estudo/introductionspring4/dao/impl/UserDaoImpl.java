package br.com.estudo.introductionspring4.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.introductionspring4.dao.UserDao;
import br.com.estudo.introductionspring4.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	private static final long serialVersionUID = 1L;

	@Override
	@Transactional(readOnly = true)
	public User login(String username, String password) {
        String query = "FROM User u where u.username = ? and u.password = ?";
        
        List<User> list = entityManager.createQuery(query, typeClass)
	        .setParameter(1, username)
	        .setParameter(2, password)
	        .getResultList();
 
        if (list == null || list.isEmpty() || list.size() > 1) {
            return null;
        }
        
        return (User) list.get(0);
    }

	@Override
	public User findLoginByUsername(String username) {
        String query = "FROM User u where u.username = ?";
        
        List<User> list = entityManager.createQuery(query, typeClass)
	        .setParameter(1, username)
	        .getResultList();
 
        if (list == null || list.isEmpty() || list.size() > 1) {
            return null;
        }
        
        return (User) list.get(0);
	}
}
