package fr.epita.sandesh.services;

import java.util.List;

import fr.epita.sandesh.model.Etudiant;

/**
 * Services Interface
 * @author Sandesh VAKALE
 *
 */
public interface EtudiantServices {
	public List<Etudiant>list();
	public boolean delete(Etudiant etudiant);
	public boolean saveOrUpdate(Etudiant etudiant);
	
}
