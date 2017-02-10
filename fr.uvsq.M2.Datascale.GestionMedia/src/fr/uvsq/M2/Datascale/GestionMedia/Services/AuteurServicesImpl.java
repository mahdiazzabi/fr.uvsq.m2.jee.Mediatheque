package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.Dao;
import fr.uvsq.M2.Datascale.GestionMedia.DaoImpl.AuteurDaoImpl;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Auteur;

public class AuteurServicesImpl implements AuteurServices {

	Dao<Auteur> dao = new AuteurDaoImpl();
	
	
	@Override
	public void insert(Auteur obj) {
		// TODO Auto-generated method stub
		dao.insert(obj);
	}

	@Override
	public void delete(Auteur obj) {
		// TODO Auto-generated method stub
		dao.delete(obj);
	}

	@Override
	public void upDate(Auteur obj) {
		// TODO Auto-generated method stub
		dao.upDate(obj);
	}

	@Override
	public Auteur findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Auteur> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
