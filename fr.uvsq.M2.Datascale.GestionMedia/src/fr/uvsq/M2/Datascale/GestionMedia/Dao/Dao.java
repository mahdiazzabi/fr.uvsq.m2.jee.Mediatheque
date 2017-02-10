package fr.uvsq.M2.Datascale.GestionMedia.Dao;


import java.util.List;

import javax.ejb.Local;


public interface Dao <T> {
	
	public void insert(T obj);
	public void delete(T obj);
	public void upDate(T obj);
	public T findById(int id);
	public List<T> findAll();

}

