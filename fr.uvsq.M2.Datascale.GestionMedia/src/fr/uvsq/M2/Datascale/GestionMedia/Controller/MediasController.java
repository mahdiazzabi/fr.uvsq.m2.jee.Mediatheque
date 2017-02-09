package fr.uvsq.M2.Datascale.GestionMedia.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.User;
import fr.uvsq.M2.Datascale.GestionMedia.util.Panier;

@ManagedBean
@SessionScoped
public class MediasController {
	private Panier panier;
	private List<Media> list;
	private Media selectedMedia;
	private User currentUser ;
	
	public MediasController() {

		list = new ArrayList<>();
		panier = new Panier();
	}
	public Boolean ControlEmptyPanier(){
		if (panier.sizePanier()==0 ) {
			return false ;
		}
		return true ;
		
	}
	public Boolean ControlNotEmptyPanier(){
		if (panier.sizePanier()==0 ) {
			return true ;
		}
		return false ;
		
	}
	public String addMediaToPanier() {
		this.panier.addMedia(selectedMedia);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Succès",
				"Media ajouté avec succès ! "));
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
		System.err.println("ok");
		Media m1 = new Media();
		m1.setId("1");
		m1.setTitre("1");
		Media m2 = new Media();
		m2.setTitre("2");
		m2.setId("2");
		Media m3 = new Media();
		m3.setTitre("3");
		m3.setId("3");
		Media m4 = new Media();
		m4.setTitre("4");
		m4.setId("4");
		Media m5 = new Media();
		m5.setTitre("444");
		m5.setId("55");
		Media m6 = new Media();
		m6.setTitre("66");
		m6.setId("6");
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
		return list;
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

}
