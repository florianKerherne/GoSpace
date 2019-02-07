package backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Lieu;
import backend.repository.LieuRepository;
import backend.services.interfaces.ILieuService;

@Service("ILieuService")
public class LieuService implements ILieuService{

	@Autowired
	private LieuRepository lieuRepository;
	
	@Override
	public Lieu getLieuById(Integer id) {
		return lieuRepository.findById(id);
	}

}
