package fr.uvsq.M2.Datascale.GestionMedia.DaoImpl;

import java.util.List;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.LivreDao;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Livre;
import hibern.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class LivreDaoImpl implements LivreDao {

	Session session =HibernateUtil.currentSession();

	public void insert(Livre obj) {
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
	

	public void delete(Livre obj) {
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

	public void upDate(Livre obj){

		Transaction tx =null;
					try{
			tx =session.beginTransaction();
			Livre livre = (Livre) session.merge(obj);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			tx.rollback();
		
		}
	}

	public Livre findById(int id){
		
		return (Livre) session.get(Livre.class, id);
	}


	public List<Livre> findAll() {
		
		return session.createQuery("select l from Livre l").list();
	}



}
