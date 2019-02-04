package backend.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Utilisateur;
import backend.model.Voyage;
import backend.repository.VoyageRepository;

@Service("IVoyageService")
public class VoyageService implements IVoyageService{

	@Autowired
	private VoyageRepository voyageRepository;
	
	@Override
	public List<Voyage> getAllVoyages() {
		List<Voyage> list = new ArrayList<>();
		voyageRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public synchronized boolean addVoyage(Voyage voyage) {
		try {
			voyageRepository.save(voyage);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public void updateVoyage(Voyage voyage) {
		voyageRepository.save(voyage);
	}

	@Override
	public void deleteVoyage(Integer id) {
		voyageRepository.delete(getVoyageById(id));
	}

	@Override
	public Voyage getVoyageById(Integer id) {
		return voyageRepository.findById(id);
	}

}
