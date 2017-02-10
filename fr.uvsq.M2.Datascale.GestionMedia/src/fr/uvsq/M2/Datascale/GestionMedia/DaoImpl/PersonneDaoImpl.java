package fr.uvsq.M2.Datascale.GestionMedia.DaoImpl;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.PersonneDao;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;
import hibern.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PersonneDaoImpl implements PersonneDao {
	Session session =HibernateUtil.currentSession();
	
	
	
	public void insert(Personne obj) {
		{

			Transaction tx =null;
						try{
				tx =session.beginTransaction();
				Personne personne = (Personne) session.save(obj);
				tx.commit();
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				tx.rollback();
			
			}}}

	public void delete(Personne obj) {
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
	public void upDate(Personne obj) {
		Transaction tx =null;
					try{
			tx =session.beginTransaction();
			Personne personne = (Personne) session.merge(obj);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			tx.rollback();
		
		}
	}
	

	public Personne findById(int id) {
		
		return (Personne) session.get(Personne.class, id);
	}


	public List<Personne> findAll() {
		return session.createQuery("select p from Auteur p").list();

	}

	@Override
	public Personne doLogin(String mail, String pwd) {
		 Query qry = session.createQuery("from Personne p where p.email =:email and p.password=:password");
		 qry.setParameter("email", mail).setParameter("password", pwd);
		 try{
			List<Personne> result = qry.list();
			for (Personne p : result ) {
				return p ;
			}
		}
		catch (Exception e){
				System.err.println("User not found!" +e.getMessage());
				return null;
		}
		 return null;
	}
	
	
	
	
}
