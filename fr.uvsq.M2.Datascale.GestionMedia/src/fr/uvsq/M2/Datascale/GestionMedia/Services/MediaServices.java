package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.Date;
import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;

public interface MediaServices {

	public void insert(Media obj);
	public void delete(Media obj);
	public void upDate(Media obj);
	public Media findById(int id);
	public List<Media> findAll();
	public Boolean emprunter(List<Media> lmedia, Personne currentUser);
	public void rendreMedia(Personne p , Media media ) ;
	public Media findByCode(String code);
	
	
	
}
