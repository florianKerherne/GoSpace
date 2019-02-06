package backend.services;

import java.util.List;
import backend.model.Voyage;

public interface IVoyageService {
	
	 List<Voyage> getAllVoyages();
	 Voyage getVoyageById(Integer id);
	 boolean addVoyage(Voyage voyage);
	 void updateVoyage(Voyage voyage);
	 void deleteVoyage(Integer id);
	 List<Voyage> findVoyageByNomLieu(String nom);
	 
}
