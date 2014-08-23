package br.com.estudo.introductionspring4.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.estudo.introductionspring4.model.User;

public interface UsuarioDetailsService extends UserDetailsService {

	public User login(String username, String password) throws IllegalArgumentException;

}
