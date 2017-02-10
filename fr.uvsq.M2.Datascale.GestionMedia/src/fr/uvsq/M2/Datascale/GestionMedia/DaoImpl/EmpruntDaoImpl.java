package fr.uvsq.M2.Datascale.GestionMedia.DaoImpl;

import hibern.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.EmpruntDao;
import fr.uvsq.M2.Datascale.GestionMedia.Dao.MediaDao;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Disque;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Emprunt;
import fr.uvsq.M2.Datascale.GestionMedia.Model.EmpruntPK;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;

public class EmpruntDaoImpl implements EmpruntDao {
	Session session = HibernateUtil.currentSession();

	public void insert(Emprunt obj) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Emprunt emp = (Emprunt) session.save(obj);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		}
	}

	public void delete(Emprunt obj) {
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

	public void upDate(Emprunt obj) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Disque disque = (Disque) session.merge(obj);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		}

	}

	public Emprunt findById(int id) {
		return (Emprunt) session.get(Emprunt.class, id);
	}

	public List<Emprunt> findAll() {
		return session.createQuery("select a from Disque a").list();
	}
	
	@Override
	public void rendreMedia(Personne p, Media media) {
		Emprunt e = new Emprunt();
		e.setMedia(media);
		e.setPersonne(p);
		EmpruntPK pk = new EmpruntPK();
		pk.setCode(media.getCode());
		pk.setPersonneID(p.getPersonneID());
		e.setEmpruntPK(pk);
		
		this.delete(e);
		
		// pour gestion de stock augmente de 1
		// media.setStock(media.getStock()+1);
		// upDate(media); // pour mettre ajour media (att stock)
	}

}
