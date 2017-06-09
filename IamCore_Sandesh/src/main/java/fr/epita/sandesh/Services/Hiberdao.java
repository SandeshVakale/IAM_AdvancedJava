package fr.epita.sandesh.Services;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.epita.sandesh.model.Etudiant;

/**
 * @author Sandesh VAKALE 
 *
 */
@Repository
public class Hiberdao implements Dao<Etudiant>{
	private static final Logger LOGGER = LogManager.getLogger(Hiberdao.class);
	
	
	@Inject
	SessionFactory sf;
	
	/**
	 * Insert etudiant Details 
	 * @param Etudiant
	 */
	public void write(Etudiant etudiant){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(etudiant);
		transaction.commit();
		session.close();
		LOGGER.info("data inserted",etudiant);

	}
	
	/**
	 * Delete etudiant details
	 * @param Etudiant
	 */
	public void delete(Etudiant etudiant){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(etudiant);
		transaction.commit();
		session.close();
		LOGGER.info("data deleted",etudiant);
	}
	/**
	 * Updating Existing etudiant Details
	 * @param Etudiant
	 */
	public void update(Etudiant etudiant){
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(etudiant);
		transaction.commit();
		session.close();
		LOGGER.info("data updted",etudiant);
	}
	
	/**
	 * List All the data from etudiant
	 */
	@SuppressWarnings("unchecked")
	public List<Etudiant>listall(){
		Session session=sf.openSession();
		List<Etudiant>StList=session.createQuery("from Etudiant").list();
		
		session.close();
		return StList;
	}
	/**
	 * Search etudiant by their Address
	 * @param Adrress
	 */
	@SuppressWarnings("unchecked")
	public List<Etudiant>searchBy(String adrs){
		Session session=sf.openSession();
		Query qr=session.createQuery("From Address AS address Where address.City like:City");
		qr.setParameter("City","%" +adrs);
		List<Etudiant>StList=qr.list();
		session.close();
		return StList;
		
		

	}
}
