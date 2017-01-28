package fr.uvsq.M2.Datascale.GestionMedia.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import fr.uvsq.M2.Datascale.GestionMedia.Model.User;

@ManagedBean
@SessionScoped
public class LoginControl {
	
	private String username ;
	private String password ;
	private User newUser = new User() ; 
	private User currentUser ;
	
	//juste pour test 
	public String signUp() {
		String redirecTo = "";
		
		//Controle et validation à completer par la communication de la couche métier
		
		//connecter le nouveau utilisateur 
		currentUser = newUser ;
		
		//redirection vers la page principale index
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext()
				.getSession(false);
		session.setAttribute("currentUser", currentUser);
		redirecTo = "/user/index.jsf?faces-redirect=true";
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful",
				"Bienvenue : " + currentUser.getFirstName()));
		
		return redirecTo ;
	}
	
	//Juste pour test à faire communiquer avec la couche metier
	public String doLogin(){
		
		System.err.println(username);
		System.err.println(password);
		String redirecTo = "";
		
		if (username.equals("mehdi") && password.equals("mehdi") ){
			
			currentUser= new User(); //à charger de la base via la couche metier
			currentUser.setFirstName(username);
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("currentUser", currentUser);
			redirecTo = "/user/index.jsf?faces-redirect=true";
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful",
					"Bonjour : " + currentUser.getFirstName()));
			
		}
		return redirecTo;
	}
	
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
	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}


}
