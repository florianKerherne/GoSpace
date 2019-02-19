package backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import backend.model.Panier;
import backend.model.Utilisateur;


public interface PanierRepository extends CrudRepository<Panier, Long> {

	List<Panier> findByIdUtilisateur(@Param("id") Utilisateur id);
	
}
