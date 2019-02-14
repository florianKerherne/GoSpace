package backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import backend.model.Lieu;

public interface LieuRepository extends CrudRepository<Lieu, Long> {

	
	Lieu findById(@Param("id") Integer id);
	
}
