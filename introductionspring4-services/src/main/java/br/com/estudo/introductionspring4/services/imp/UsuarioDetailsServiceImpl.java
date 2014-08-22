package br.com.estudo.introductionspring4.services.imp;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.estudo.introductionspring4.services.UsuarioDetailsService;

@Service("usuarioDetailsService")
@Primary
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService {

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        Usuario user = usuarioDAO.findByLogin(userName);
//        return user;
        return null;
    }

}
