package fr.uvsq.M2.Datascale.GestionMedia.Dao;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;



public interface PersonneDao extends Dao <Personne> {

	public Personne doLogin(String mail , String pwd);
	public Personne doSignUp(Personne personne);
	
	
}

