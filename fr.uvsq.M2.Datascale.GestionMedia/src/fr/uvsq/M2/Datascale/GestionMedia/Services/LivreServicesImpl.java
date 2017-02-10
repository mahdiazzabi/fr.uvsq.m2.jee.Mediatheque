package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.Dao;
import fr.uvsq.M2.Datascale.GestionMedia.DaoImpl.LivreDaoImpl;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Livre;

public class LivreServicesImpl implements LivreServices {

	Dao<Livre>dao = new LivreDaoImpl();
	
	@Override
	public void insert(Livre obj) {
		// TODO Auto-generated method stub
		dao.insert(obj);
	}

	@Override
	public void delete(Livre obj) {
		// TODO Auto-generated method stub
		dao.delete(obj);
	}

	@Override
	public void upDate(Livre obj) {
		// TODO Auto-generated method stub
		dao.upDate(obj);
	}

	@Override
	public Livre findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Livre> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
