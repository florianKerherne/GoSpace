package backend.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Voyage getVoyageById(Integer id) {
		Voyage obj = voyageRepository.findById(id);
		return obj;
	}

}
