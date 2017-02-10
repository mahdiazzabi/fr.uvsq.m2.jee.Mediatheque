package fr.uvsq.M2.Datascale.GestionMedia.Services;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.MediaDao;
import fr.uvsq.M2.Datascale.GestionMedia.DaoImpl.MediaDaoImpl;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;

public class MediaServiceImpl implements MediaServices {

	
	MediaDao dao = new MediaDaoImpl();
	
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

}
