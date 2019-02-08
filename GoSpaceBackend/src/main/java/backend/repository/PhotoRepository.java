package backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import backend.model.Lieu;
import backend.model.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
	
	Photo findByIdLieu(@Param("id") Lieu id);
	
}
