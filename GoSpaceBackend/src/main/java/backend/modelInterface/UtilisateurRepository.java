package backend.modelInterface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import backend.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

	List<Utilisateur> findByNom(@Param("nom") String nom);
    List<Utilisateur> findByPrenom(@Param("prenom") String prenom);
}
