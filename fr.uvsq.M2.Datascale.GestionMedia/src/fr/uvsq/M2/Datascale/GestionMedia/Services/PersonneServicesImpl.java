package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.Dao;
import fr.uvsq.M2.Datascale.GestionMedia.Dao.PersonneDao;
import fr.uvsq.M2.Datascale.GestionMedia.DaoImpl.PersonneDaoImpl;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;

public class PersonneServicesImpl implements PersonneServices{

	PersonneDao dao = new PersonneDaoImpl();
	
	
	
	
	@Override
	public void insert(Personne obj) {
		dao.insert(obj);
	}

	@Override
	public void delete(Personne obj) {
		dao.delete(obj);
	}

	@Override
	public void upDate(Personne obj) {
		dao.upDate(obj);
	}

	@Override
	public Personne findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Personne> findAll() {
		return dao.findAll();
	}

	@Override
	public Personne doLogin(String mail, String pwd) {
		
		return dao.doLogin(mail, pwd);
	}

}
