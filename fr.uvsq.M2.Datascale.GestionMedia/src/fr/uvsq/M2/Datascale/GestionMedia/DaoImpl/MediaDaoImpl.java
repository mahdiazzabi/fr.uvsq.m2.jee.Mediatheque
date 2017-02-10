package fr.uvsq.M2.Datascale.GestionMedia.DaoImpl;

import hibern.HibernateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.uvsq.M2.Datascale.GestionMedia.Dao.MediaDao;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Emprunt;
import fr.uvsq.M2.Datascale.GestionMedia.Model.EmpruntPK;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Media;
import fr.uvsq.M2.Datascale.GestionMedia.Model.Personne;

public class MediaDaoImpl implements MediaDao {

	Session session = HibernateUtil.currentSession();

	public void upDate(Media obj) {

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Media media = (Media) session.merge(obj);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		}
	}

	public Media findById(int id) {

		return (Media) session.get(Media.class, id);
	}

	public void insert(Media obj) {
		{

			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(obj);
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				tx.rollback();

			}
		}

	}

	public void delete(Media obj) {
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

	public List<Media> findAll() {
		return session.createQuery("select m from Media m").list();

	}

	@Override
	public Boolean emprunter(List<Media> lmedia, Personne user) {
		for (Media a : lmedia) {

			EmpruntPK empruntPK = new EmpruntPK();
			empruntPK.setCode(a.getCode());
			empruntPK.setPersonneID(user.getPersonneID());

			Emprunt emprunt = new Emprunt();
			emprunt.setEmpruntPK(empruntPK);
			emprunt.setMedia(a);
			emprunt.setPersonne(user);
			emprunt.setDateEmprunt(new Date());
			Date datePrevueRendre = new Date();
			Calendar calendar = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(datePrevueRendre);
			calendar.add(calendar2.DATE, 15);
			datePrevueRendre = calendar2.getTime();
			emprunt.setDatePrevueRendre(datePrevueRendre);
			{

				Transaction tx = null;
				try {

					tx = session.beginTransaction();
					session.save(emprunt);
					tx.commit();
				} catch (HibernateException e) {
					e.printStackTrace();
					tx.rollback();
					return false;
				}
				a.setStock(a.getStock() - 1);
				this.upDate(a);
			}

		}
		return true;
	}

	@Override
	public Media findByCode(String code) {
		Query qry = session.createQuery("from Media m where m.code =:code");
		qry.setParameter("code", code);
		try {
			List<Media> result = qry.list();
			for (Media p : result) {
				return p;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

}
