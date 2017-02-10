package fr.uvsq.M2.Datascale.GestionMedia.DaoImpl;

import java.util.List;

import javax.ejb.Stateless;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.AuteurDao;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Auteur;
import hibern.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuteurDaoImpl implements AuteurDao {
	Session session = HibernateUtil.currentSession();

	public void insert(Auteur obj) {
		{

			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				Auteur auteur = (Auteur) session.save(obj);
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				tx.rollback();

			}
		}
	}

	public void delete(Auteur obj)
	{
		{
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.delete(obj);
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				tx.rollback();

			}
		}
	}

	public void upDate(Auteur obj) {

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Auteur auteur = (Auteur) session.merge(obj);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		}
	}

	// donne id retourne objet auteur
	public Auteur findById(int id) {
		return (Auteur) session.get(Auteur.class, id);
	}

	// Auteur c'est entity auteur (class)
	public List<Auteur> findAll() {

		return session.createQuery("select a from Auteur a").list();
	}


}
