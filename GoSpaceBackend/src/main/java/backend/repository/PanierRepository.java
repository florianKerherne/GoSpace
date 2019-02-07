package backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import backend.model.Panier;


public interface PanierRepository extends CrudRepository<Panier, Long> {

	Panier findByIdUtilisateur(@Param("id") Integer id);
	
}
