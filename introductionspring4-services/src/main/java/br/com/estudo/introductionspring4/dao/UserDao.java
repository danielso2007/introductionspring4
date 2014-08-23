package br.com.estudo.introductionspring4.dao;

import br.com.estudo.introductionspring4.model.User;

public interface UserDao extends GenericDao<User, Long> {

	public User login(String username, String password);
	public User findLoginByUsername(String username);
	
}
