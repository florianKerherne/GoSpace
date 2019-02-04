package backend.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import backend.model.Voyage;

public interface VoyageRepository extends CrudRepository<Voyage, Long> {
	
	Voyage findById(@Param("id") Integer id);
	List<Voyage> findAll();
	List<Voyage> findByPrix(@Param("prix") float prix);
	List<Voyage> findByDateDebut(@Param("dateDebut") Calendar dateDebut);
	List<Voyage> findByDateFin(@Param("dateFin") Calendar dateFin);
	List<Voyage> findByNbPlacesRestantes(@Param("nbPlacesRestantes") Integer nbPlacesRestantes);
	
}
