package backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import backend.model.Panier;
import backend.services.interfaces.IPanierService;
import modelDTO.PanierDTO;

@RestController()
@RequestMapping("/")
public class PanierController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PanierController.class);

	@Autowired
	IPanierService panierService;
	
	@GetMapping("panier/{id}")
	public ResponseEntity<List<Panier>> getPanierByIdPersonne(@PathVariable("id") Integer id) {
		LOG.info("GET called on getPanierByIdPersonne");
		List<Panier> panier = panierService.getPanierByIdPersonne(id);
		return new ResponseEntity<List<Panier>>(panier, HttpStatus.OK);
	}
	
	@PostMapping("panier")
	public ResponseEntity<Void> addVoyageToPanier(@RequestBody PanierDTO panierDTO, UriComponentsBuilder builder) {
				LOG.info("GET called on addVoyageToPanier");
				boolean flag = panierService.addVoyageToPanier(panierDTO);
                if (flag == false) {
                	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/panier/{id}").buildAndExpand(panierDTO.getIdUtilisateur()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
}
