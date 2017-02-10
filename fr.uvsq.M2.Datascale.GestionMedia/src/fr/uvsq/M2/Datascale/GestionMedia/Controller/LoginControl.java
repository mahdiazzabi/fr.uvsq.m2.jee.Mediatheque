package fr.uvsq.M2.Datascale.GestionMedia.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;
import fr.uvsq.M2.Datascale.GestionMedia.Services.PersonneServices;
import fr.uvsq.M2.Datascale.GestionMedia.Services.PersonneServicesImpl;

@ManagedBean
@RequestScoped
public class LoginControl {

	private String username;
	private String password;
	private Personne newUser = new Personne();
	private Personne currentUser;

	private PersonneServices personneServices = new PersonneServicesImpl();

	// Controle inscription
	public String signUp() {
		String redirecTo = "";
		
		newUser= personneServices.doSignUp(newUser);
		
		// System.err.println(currentUser.getFirstName() +
		// currentUser.getLastName());
		
		redirecTo = "/login.jsf?faces-redirect=true";

		return redirecTo;
	}

	public String updateInfo() {
		String redirecTo = "";

		// ici inscription
		// connecter le nouveau utilisateur

		// redirection vers la page login

		redirecTo = "/user/index.jsf?faces-redirect=true";

		return redirecTo;
	}

	// connexion
	public String doLogin() {

		currentUser = personneServices.doLogin(username, password);
		System.err.println(currentUser.getNom());
		String redirecTo = "";

		if (currentUser == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ",
							"Login / password incorrect."));
			return "/login.jsf?faces-redirect=true";
			
		} else if (currentUser.getNiveau().equals("user")) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			session.setAttribute("currentUser", currentUser);
			redirecTo = "/user/index.jsf?faces-redirect=true";
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful", "Bonjour : "+ currentUser.getPrenom()));
			return redirecTo;
		} else { //si admin
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			session.setAttribute("currentUser", currentUser);
			redirecTo = "/admin/indexAdmin.jsf?faces-redirect=true";
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful", "Bonjour : "+ currentUser.getPrenom()));
			return redirecTo;
		}
		
	
	}

	public String doLogout() {

		((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(true)).invalidate();
		return "/login.jsf?faces-redirect=true";

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

	public Personne getNewUser() {
		return newUser;
	}

	public void setNewUser(Personne newUser) {
		this.newUser = newUser;
	}

	public Personne getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Personne currentUser) {
		this.currentUser = currentUser;
	}

}
