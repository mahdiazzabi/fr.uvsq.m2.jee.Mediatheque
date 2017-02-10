package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Livre;


public interface LivreServices {

	public void insert(Livre obj);
	public void delete(Livre obj);
	public void upDate(Livre obj);
	public Livre findById(int id);
	public List<Livre> findAll();
}
