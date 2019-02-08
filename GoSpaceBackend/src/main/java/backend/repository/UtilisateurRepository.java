package backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import backend.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

	Utilisateur findById(@Param("id") Integer id);
	List<Utilisateur> findByNom(@Param("nom") String nom);
    List<Utilisateur> findByPrenom(@Param("prenom") String prenom);
	List<Utilisateur> findByEmail(@Param("email") String email);
	List<Utilisateur> findByMdp(@Param("mdp") String mdp);
	boolean existsByEmail(@Param("email") String email);

}
