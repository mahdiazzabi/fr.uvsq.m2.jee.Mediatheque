package fr.uvsq.M2.Datascale.GestionMedia.util;

import java.util.ArrayList;
import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;

public class Panier {

	private Personne user ;
	private ArrayList<Media> medias;

	
	public Panier() {
		// TODO Auto-generated constructor stub
		medias = new ArrayList<>();
		System.err.println("création ok");
	}

	public List<Media> getMedias() {
		return medias;
	}

	public void removeMedia(Media media) {
		medias.remove(media);
	}

	public void addMedia(Media media) {
		System.err.println(media.getTitre());
		medias.add(media);
	}

	public int sizePanier() {
		return medias.size();
	}

	public Personne getUser() {
		return user;
	}

	public void setUser(Personne user) {
		this.user = user;
	}

	public void setMedias(ArrayList<Media> medias) {
		this.medias = medias;
	}


}

