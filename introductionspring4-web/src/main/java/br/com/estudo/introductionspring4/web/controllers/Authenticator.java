package br.com.estudo.introductionspring4.web.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import br.com.estudo.introductionspring4.model.User;
import br.com.estudo.introductionspring4.services.UsuarioDetailsService;
import br.com.estudo.introductionspring4.stereotype.RequestScopeSpring;
import br.com.estudo.introductionspring4.web.beans.UserSession;

@Named("authenticator")
@RequestScopeSpring
@RequestScoped
@ManagedBean(name = "authenticator")
@Controller
public class Authenticator extends BaseBean implements AuthenticationProvider {
	
	private static final long serialVersionUID = 1L;

	@Inject
    private UsuarioDetailsService usuarioDetailsService;
 
	@Inject
    private UserSession session;
 
    private String username;
    private String password;
 
    public String login() {
        try {
            User user = usuarioDetailsService.login(username, password);
            loginSpringSecurity(user);
            session.setUser(user);
            return "/pages/home.xhtml";
        } catch (IllegalArgumentException ex) {
            messageErro(ex.getMessage());
        }
        return "";
    }
 
    private void loginSpringSecurity(User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getRoles());
        token.setDetails(user);
        SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.getContext().setAuthentication(token);
    }
 
    public String logout() {
        SecurityContextHolder.clearContext();
        session.setUser(null);
        return "/login.xhtml";
    }
 
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        return null;
    }
 
    @Override
    public boolean supports(Class<?> $class) {
        return false;
    }
    
    /* ==== GETTER AND SETTER ==== */
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}
