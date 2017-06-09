package fr.epita.sandesh.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.epita.sandesh.dao.EtudiantDao;
import fr.epita.sandesh.model.Etudiant;


/**
 * 
 * @author Sandesh VAKALE
 *
 */

@Repository
@Transactional
public class EtudiantDaoImpl implements EtudiantDao {

	
	@Autowired
	SessionFactory session;
	
	/**
	 * Return list
	 */
	@SuppressWarnings("unchecked")
	public List<Etudiant> list() {
	return session.getCurrentSession().createQuery("from etudiant").list();
		
	}
/**
 * Delete existing Etudiant
 */
	public boolean delete(Etudiant etudiant) {
		try{
			session.getCurrentSession().delete(etudiant);
		}catch(Exception ex){
			return false;	
		}
		return true;
	}

	/**
	 * Save new Etudiant details
	 */
	public boolean saveOrUpdate(Etudiant etudiant) {
		session.getCurrentSession().saveOrUpdate(etudiant);
		return true;
	}

}
