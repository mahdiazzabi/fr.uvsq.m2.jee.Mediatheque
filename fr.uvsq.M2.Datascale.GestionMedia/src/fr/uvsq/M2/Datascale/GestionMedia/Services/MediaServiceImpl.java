package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.Date;
import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.EmpruntDao;
import fr.uvsq.M2.Datascale.GestionMedia.Dao.MediaDao;
import fr.uvsq.M2.Datascale.GestionMedia.Dao.PersonneDao;
import fr.uvsq.M2.Datascale.GestionMedia.DaoImpl.EmpruntDaoImpl;
import fr.uvsq.M2.Datascale.GestionMedia.DaoImpl.MediaDaoImpl;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;

public class MediaServiceImpl implements MediaServices {

	
	MediaDao dao = new MediaDaoImpl();
	EmpruntDao daoEmprunt = new EmpruntDaoImpl();
	
	@Override
	public void insert(Media obj) {
		// TODO Auto-generated method stub
		dao.insert(obj);
	}

	@Override
	public void delete(Media obj) {
		// TODO Auto-generated method stub
		dao.delete(obj);
	}

	@Override
	public void upDate(Media obj) {
		// TODO Auto-generated method stub
		dao.upDate(obj);
	}

	@Override
	public Media findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Media> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Boolean emprunter(List<Media> lmedia, Personne user) {
		// TODO Auto-generated method stub
		return dao.emprunter(lmedia, user);
	}

	

	@Override
	public void rendreMedia(Personne p, Media media) {
		// TODO Auto-generated method stub
		daoEmprunt.rendreMedia(p, media);
	}

	@Override
	public Media findByCode(String code) {
		// TODO Auto-generated method stub
		return dao.findByCode(code);
	}

}
