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

import backend.model.Voyage;
import backend.services.IVoyageService;


@RestController()
@RequestMapping("/")
public class VoyageController {

	private static final Logger LOG = LoggerFactory.getLogger(VoyageController.class);
	
	@Autowired
	IVoyageService voyageService;
	
	@GetMapping("voyage/{id}")
	public ResponseEntity<Voyage> getUserById(@PathVariable("id") Integer id) {
		LOG.info("GET called on getUserById"); 
		Voyage utilisateur = voyageService.getVoyageById(id);
		return new ResponseEntity<Voyage>(utilisateur, HttpStatus.OK);
	}
	
}
