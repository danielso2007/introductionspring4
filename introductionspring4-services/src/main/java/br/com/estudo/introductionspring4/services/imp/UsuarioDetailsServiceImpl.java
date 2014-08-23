package br.com.estudo.introductionspring4.services.imp;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.introductionspring4.dao.UserDao;
import br.com.estudo.introductionspring4.lang.util.Check;
import br.com.estudo.introductionspring4.model.User;
import br.com.estudo.introductionspring4.services.UsuarioDetailsService;

@Service("usuarioDetailsService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService {

	@Inject
	private UserDao userDao;
	
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userDao.findLoginByUsername(login);
    }
    
    @Override
    public User login(String username, String password) throws IllegalArgumentException {
    	if (Check.isEmpty(username) || Check.isEmpty(password)) {
            throw new IllegalArgumentException("Atenção, username ou password vazios!");
        }
    	
        User user = userDao.login(username, password);
         
        if (Check.isNull(user)) {
            throw new IllegalArgumentException("Erro: username ou password incorretos!");
        }
        return user;
    }

}
