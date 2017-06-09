package fr.epita.sandesh.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epita.sandesh.dao.EtudiantDao;
import fr.epita.sandesh.model.Etudiant;
import fr.epita.sandesh.services.EtudiantServices;

/**
 * 
 * @author Sandesh VAKALE
 *
 */
@Service
public class EtudiantServiceImpl implements EtudiantServices {

	@Autowired
	EtudiantDao dao;
	
	
	/**
	 * Return all Etudiant 
	 */
	public List<Etudiant> list() {
		return dao.list();

	}
/**
 * Delete Existing Etudiant
 */
	public boolean delete(Etudiant etudiant) {
		
		return dao.delete(etudiant);
	}

	/**
	 * SaveOrUpdate Etudiant into database
	 */
	public boolean saveOrUpdate(Etudiant etudiant) {
		
		return dao.saveOrUpdate(etudiant);
	}
	

}
