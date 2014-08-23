package br.com.estudo.introductionspring4.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

import br.com.estudo.introductionspring4.lang.util.Check;
import br.com.estudo.introductionspring4.model.User;
import br.com.estudo.introductionspring4.stereotype.SessionScopeSpring;

@SessionScopeSpring
@Named("userSession")
@SessionScoped
@ManagedBean(name = "userSession")
@Controller
public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return Check.isNotNull(user);
	}
	
}
