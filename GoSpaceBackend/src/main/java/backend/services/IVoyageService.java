package backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import backend.model.Voyage;
import backend.repository.VoyageRepository;


public interface IVoyageService {
	
	 List<Voyage> getAllVoyages();
	 boolean addVoyage(Voyage voyage);
	 void updateVoyage(Voyage voyage);
	 void deleteVoyage(Integer id);
	 
}
