package backend.services;

import java.util.List;
import backend.model.Voyage;

public interface IVoyageService {
	
	 List<Voyage> getAllVoyages();
	 boolean addVoyage(Voyage voyage);
	 void updateVoyage(Voyage voyage);
	 void deleteVoyage(Integer id);
	 
}
