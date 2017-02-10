package fr.uvsq.M2.Datascale.GestionMedia.DaoImpl;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.MediaDao;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Livre;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import hibern.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class MediaDaoImpl implements MediaDao {

	Session session =HibernateUtil.currentSession();


	public void upDate(Media obj) {

		Transaction tx =null;
					try{
			tx =session.beginTransaction();
			Media media = (Media) session.merge(obj);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			tx.rollback();
		
		}
	}


	public Media findById(int id) {
		
		return (Media) session.get(Media.class, id);
	}

	public void insert(Media obj) {
		{

			Transaction tx =null;
						try{
				tx =session.beginTransaction();
				Livre livre =  (Livre) session.save(obj);
				tx.commit();
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				tx.rollback();
			
			}
						}
	
		
	}

	public void delete(Media obj) {
		{

			Transaction tx =null;
						try{
				tx =session.beginTransaction();
			    session.delete(obj);
				tx.commit();
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				tx.rollback();
			
			}}}

	public List<Media> findAll() {
		return session.createQuery("select m from Media m").list();

	}

	

}
