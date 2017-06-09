package fr.epita.sandesh.dao;

import java.util.List;

import fr.epita.sandesh.model.Etudiant;

/**
 * Services Interface
 * @author Sandesh VAKALE
 *
 */
public interface EtudiantDao {

	public List<etudiant>list();
	public boolean delete(Etudiant etudiant);
	public boolean saveOrUpdate(Etudiant etudiant);
	
}
