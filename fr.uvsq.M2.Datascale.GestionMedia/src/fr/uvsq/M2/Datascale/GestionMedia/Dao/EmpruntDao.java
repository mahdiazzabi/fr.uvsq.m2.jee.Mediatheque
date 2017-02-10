package fr.uvsq.M2.Datascale.GestionMedia.Dao;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Emprunt;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;


public interface EmpruntDao extends Dao <Emprunt> {
	public void rendreMedia(Personne p , Media media );
	
}
