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

import backend.model.Lieu;
import backend.services.interfaces.ILieuService;

@RestController()
@RequestMapping("/")
public class LieuController {

	private static final Logger LOG = LoggerFactory.getLogger(LieuController.class);
	
	@Autowired
	ILieuService lieuService;
	
	@GetMapping("lieu/{id}")
	public ResponseEntity<Lieu> getLieuById(@PathVariable("id") Integer id) {
		LOG.info("GET called on getLieuById");
		Lieu lieu = lieuService.getLieuById(id);
		return new ResponseEntity<Lieu>(lieu, HttpStatus.OK);
	}
	
}
