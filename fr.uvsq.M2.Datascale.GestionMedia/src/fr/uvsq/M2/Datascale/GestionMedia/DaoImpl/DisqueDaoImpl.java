package fr.uvsq.M2.Datascale.GestionMedia.DaoImpl;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.DisqueDao;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Disque;
import hibern.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;





public class DisqueDaoImpl implements DisqueDao {
	Session session =HibernateUtil.currentSession();

	
	public void insert(Disque obj) {
		{

			Transaction tx =null;
						try{
				tx =session.beginTransaction();
				Disque disque =  (Disque) session.save(obj);
				tx.commit();
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				tx.rollback();
			
			}
						}
	}
	public void upDate(Disque obj) {

		Transaction tx =null;
					try{
			tx =session.beginTransaction();
			Disque disque = (Disque) session.merge(obj);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			tx.rollback();
		
		}
	}

	public Disque findById(int id) {
		
		return (Disque) session.get(Disque.class, id);
	}

	public void delete(Disque obj) {
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


	public List<Disque> findAll() {
		return session.createQuery("select a from Disque a").list();	
		}
}
