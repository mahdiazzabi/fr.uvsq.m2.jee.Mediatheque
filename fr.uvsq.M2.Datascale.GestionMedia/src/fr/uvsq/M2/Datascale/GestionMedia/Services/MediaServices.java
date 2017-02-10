package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;

public interface MediaServices {

	
	public void insert(Media obj);
	public void delete(Media obj);
	public void upDate(Media obj);
	public Media findById(int id);
	public List<Media> findAll();
}
