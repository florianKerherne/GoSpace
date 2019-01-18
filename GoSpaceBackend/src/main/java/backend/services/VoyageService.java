package backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import backend.model.Voyage;
import backend.repository.VoyageRepository;

public class VoyageService implements IVoyageService{

	@Autowired
	private VoyageRepository voyageRepository;
	
	@Override
	public List<Voyage> getAllVoyages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVoyage(Voyage voyage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateVoyage(Voyage voyage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVoyage(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
