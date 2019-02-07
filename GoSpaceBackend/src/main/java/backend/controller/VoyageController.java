package backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Utilisateur;
import backend.model.Voyage;
import backend.services.interfaces.IVoyageService;


@RestController()
@RequestMapping("/")
public class VoyageController {

	private static final Logger LOG = LoggerFactory.getLogger(VoyageController.class);
	
	@Autowired
	IVoyageService voyageService;
	
	@GetMapping("voyages")
	public ResponseEntity<List<Voyage>> getAllVoyages() {
		LOG.info("GET called on getAllvoyages"); 
		List<Voyage> list = voyageService.getAllVoyages();
		return new ResponseEntity<List<Voyage>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("voyage/{id}")
	public ResponseEntity<Voyage> getVoyageById(@PathVariable("id") Integer id) {
		LOG.info("GET called on getVoyageById"); 
		Voyage voyage = voyageService.getVoyageById(id);
		return new ResponseEntity<Voyage>(voyage, HttpStatus.OK);
	}
	
	@GetMapping("voyages/{nom}")
	public ResponseEntity<List<Voyage>> getVoyageByNomPlanete(@PathVariable("nom") String nom) {
		LOG.info("GET called on getVoyageByNomPlanete"); 
		List<Voyage> voyage = voyageService.findVoyageByNomLieu(nom);
		return new ResponseEntity<List<Voyage>>(voyage, HttpStatus.OK);
	}
	
	@PutMapping("Voyage")
	public ResponseEntity<Voyage> updateVoyage(@RequestBody Voyage voyage) {
		LOG.info("GET called on updateVoyage");  
		voyageService.updateVoyage(voyage);
		return new ResponseEntity<Voyage>(voyage, HttpStatus.OK);
	}
	
	@DeleteMapping("Voyage/{id}")
	public ResponseEntity<Void> deleteVoyage(@PathVariable("id") Integer id) {
		LOG.info("GET called on deleteVoyage");  
		voyageService.deleteVoyage(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
