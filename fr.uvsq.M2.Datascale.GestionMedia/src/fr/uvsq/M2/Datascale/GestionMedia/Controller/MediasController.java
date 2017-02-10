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
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;
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
	private Personne currentUser;
	private Media newMedia = new Media();
	private Personne user;

	private Media mediaArendre = new Media();
	private Livre newLivre = new Livre();
	private Disque newDisque = new Disque();

	private MediaServices mediaServices = new MediaServiceImpl();
	private LivreServices livreServices = new LivreServicesImpl();

	public MediasController() {
		user = new Personne();
		
		panier = new Panier();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		currentUser = (Personne) session.getAttribute("currentUser");
		panier.setUser(currentUser);
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
		System.err.println(panier.getUser().getNom());
		if (panier.sizePanier() != 0) {
			if (mediaServices.emprunter(panier.getMedias(), panier.getUser())) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Successful",
						"Commande validée ! "));
				redirecTo = "/user/index.jsf?faces-redirect=true";
				panier = new Panier();
			}
		}
		return redirecTo;

	}

	public List<Media> loadMedias() {
		list = mediaServices.findAll();
		return list;
	}

	public void returnMedia() {
		try {
			mediaArendre = mediaServices.findByCode(mediaArendre.getCode());
			mediaServices.rendreMedia(user, mediaArendre);
			mediaArendre.setStock(mediaArendre.getStock()+1);
			mediaServices.upDate(mediaArendre);
		} catch (Exception e) {
			System.err.println(e.getMessage()); // TODO: handle exception
		}
	}

	public void addLivre() {

		newLivre.setCode(newMedia.getCode());
		newLivre.setMedia(newMedia);
		mediaServices.insert(newMedia);
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

	public Personne getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Personne currentUser) {
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

	public Personne getUser() {
		return user;
	}

	public void setUser(Personne user) {
		this.user = user;
	}

	public Media getMediaArendre() {
		return mediaArendre;
	}

	public void setMediaArendre(Media mediaArendre) {
		this.mediaArendre = mediaArendre;
	}

	public MediaServices getMediaServices() {
		return mediaServices;
	}

	public void setMediaServices(MediaServices mediaServices) {
		this.mediaServices = mediaServices;
	}

	public LivreServices getLivreServices() {
		return livreServices;
	}

	public void setLivreServices(LivreServices livreServices) {
		this.livreServices = livreServices;
	}

}
