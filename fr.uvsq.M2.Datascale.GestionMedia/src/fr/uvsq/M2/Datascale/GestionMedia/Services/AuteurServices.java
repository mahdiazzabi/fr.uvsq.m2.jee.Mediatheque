package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Auteur;

public interface AuteurServices {

	
	public void insert(Auteur obj);
	public void delete(Auteur obj);
	public void upDate(Auteur obj);
	public Auteur findById(int id);
	public List<Auteur> findAll();
	
}
