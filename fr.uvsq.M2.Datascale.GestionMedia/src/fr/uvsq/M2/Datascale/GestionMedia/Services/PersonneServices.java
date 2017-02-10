package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;

public interface PersonneServices {

	public void insert(Personne obj);
	public void delete(Personne obj);
	public void upDate(Personne obj);
	public Personne findById(int id);
	public List<Personne> findAll();
	public Personne doLogin(String mail , String pwd);

}
