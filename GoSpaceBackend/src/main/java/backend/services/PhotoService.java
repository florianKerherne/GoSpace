package backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Lieu;
import backend.model.Photo;
import backend.repository.LieuRepository;
import backend.repository.PhotoRepository;
import backend.services.interfaces.IPhotoService;

@Service("IPhotoService")
public class PhotoService implements IPhotoService{

	@Autowired
	PhotoRepository photoRepository;
	LieuRepository lieuRepository;
	
	@Override
	public Photo getPhotoByIdLieu(Integer id) {
		Lieu lieu = lieuRepository.findById(id);
		if(lieu == null) {
			return null;
		}
		return photoRepository.findByIdLieu(lieu);
	}

}
