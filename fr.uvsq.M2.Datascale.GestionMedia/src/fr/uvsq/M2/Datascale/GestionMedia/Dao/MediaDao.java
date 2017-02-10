package fr.uvsq.M2.Datascale.GestionMedia.Dao;



import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;


public interface MediaDao extends Dao <Media>{
	
	public Boolean emprunter(List<Media> lmedia, Personne user);
		
	public Media findByCode(String code);
	
	
}
