package backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Photo;
import backend.services.interfaces.IPhotoService;

@RestController()
@RequestMapping("/")
public class PhotoController {

	private static final Logger LOG = LoggerFactory.getLogger(PhotoController.class);
	
	@Autowired
	IPhotoService photoService;
	
	@GetMapping("Photo/{id}")
	public ResponseEntity<Photo> getPhotoByIdLieu(@PathVariable("id") Integer id) {
		LOG.info("GET called on getPhotoByIdLieu");
		Photo photo = photoService.getPhotoByIdLieu(id);
		return new ResponseEntity<Photo>(photo, HttpStatus.OK);
	}

}
