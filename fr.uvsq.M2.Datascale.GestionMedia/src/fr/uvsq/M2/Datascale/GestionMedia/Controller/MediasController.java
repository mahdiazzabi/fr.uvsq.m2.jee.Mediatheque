package fr.uvsq.M2.Datascale.GestionMedia.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Disque;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Livre;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.User;
import fr.uvsq.M2.Datascale.GestionMedia.Services.LivreServices;
import fr.uvsq.M2.Datascale.GestionMedia.Services.LivreServicesImpl;
import fr.uvsq.M2.Datascale.GestionMedia.Services.MediaServiceImpl;
import fr.uvsq.M2.Datascale.GestionMedia.Services.MediaServices;
import fr.uvsq.M2.Datascale.GestionMedia.util.Panier;

@ManagedBean
@SessionScoped
public class MediasController {
	private Panier panier;
	private List<Media> list;
	private Media selectedMedia;
	private User currentUser;
	private Media newMedia;
	private Livre newLivre;
	private Disque newDisque;

	private MediaServices mediaServices = new MediaServiceImpl();
	private LivreServices livreServices = new LivreServicesImpl();
	
	public MediasController() {

		list = new ArrayList<>();
		panier = new Panier();
	}

	public Boolean ControlEmptyPanier() {
		if (panier.sizePanier() == 0) {
			return false;
		}
		return true;

	}

	public Boolean ControlNotEmptyPanier() {
		if (panier.sizePanier() == 0) {
			return true;
		}
		return false;

	}

	public String addMediaToPanier() {
		this.panier.addMedia(selectedMedia);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Succès", "Media ajouté avec succès ! "));
		context.getExternalContext().getFlash().setKeepMessages(true);
		return "/user/index.jsf?faces-redirect=true";
	}

	public String removeMediaFromPanier() {
		this.panier.removeMedia(selectedMedia);
		if (panier.sizePanier() == 0) {
			return "/user/index.jsf?faces-redirect=true";
		}
		return "/user/panier.jsf?faces-redirect=true";
	}

	public String validerPanier() {

		String redirecTo = "";
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);

		if (panier.sizePanier() != 0) {
			// ici methode ajout if
			// validerEmprunt(session.getAttribute("currentUser"),panier)
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful",
					"Commande validée ! "));
			redirecTo = "/user/index.jsf?faces-redirect=true";
			panier = new Panier();
			// then Message d'erreur
		}
		return redirecTo;

	}

	public List<Media> loadMedias() {
		// à charger de la bd

		return list;
	}

	public void addLivre() {
		mediaServices.insert(newMedia);
		newLivre.setCode(newMedia.getCode());
		livreServices.insert(newLivre);
	}

	public Media getSelectedMedia() {
		return selectedMedia;
	}

	public void setSelectedMedia(Media selectedMedia) {
		this.selectedMedia = selectedMedia;

	}

	public List<Media> getList() {
		return list;
	}

	public void setList(List<Media> medias) {
		this.list = medias;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Media getNewMedia() {
		return newMedia;
	}

	public void setNewMedia(Media newMedia) {
		this.newMedia = newMedia;
	}

	public Livre getNewLivre() {
		return newLivre;
	}

	public void setNewLivre(Livre newLivre) {
		this.newLivre = newLivre;
	}

	public Disque getNewDisque() {
		return newDisque;
	}

	public void setNewDisque(Disque newDisque) {
		this.newDisque = newDisque;
	}

}
