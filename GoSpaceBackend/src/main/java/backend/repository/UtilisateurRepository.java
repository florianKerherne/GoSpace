package backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import backend.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {

	List<Utilisateur> findByNom(String nom);
	
    List<Utilisateur> findByPrenom(String prenom);
}
