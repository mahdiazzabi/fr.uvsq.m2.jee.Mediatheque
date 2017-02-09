package fr.uvsq.M2.Datascale.GestionMedia.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.uvsq.M2.Datascale.GestionMedia.Model.User;

@ManagedBean
@SessionScoped
public class LoginControl {

	private String username;
	private String password;
	private User newUser = new User();
	private User currentUser;

	// Controle inscription
	public String signUp() {
		String redirecTo = "";

		System.err.println(currentUser.getFirstName() + currentUser.getLastName());
		

		redirecTo = "/login.jsf?faces-redirect=true";
	
		return redirecTo;
	}
	public String updateInfo() {
		String redirecTo = "";

		// ici inscription
		System.err.println(newUser.getFirstName() + newUser.getLastName());
		// connecter le nouveau utilisateur
		
		// redirection vers la page login

		redirecTo = "/user/index.jsf?faces-redirect=true";
	
		return redirecTo;
	}
	// connexion
	public String doLogin() {

		System.err.println(username);
		System.err.println(password);
		String redirecTo = "";

		if (true) {

			currentUser = new User(); // à charger de la base via la couche
										// metier
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

	public String doLogout() {
		
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(true)).invalidate();
		return "/login.jsf?faces-redirect=true";

		

	}
	

	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
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
