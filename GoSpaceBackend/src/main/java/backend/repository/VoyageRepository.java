package backend.repository;

import org.springframework.data.repository.CrudRepository;
import backend.model.Voyage;

public interface VoyageRepository extends CrudRepository<Voyage, Long> {

}
