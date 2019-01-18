package backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import backend.model.Utilisateur;
import backend.repository.UtilisateurRepository;
import backend.services.IUtilisateurService;

@RestController()
@RequestMapping("/")
public class UtilisateurController {

	private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
	
	@Autowired
	private IUtilisateurService utilisateurService;
	
	@GetMapping("utilisateur/{id}")
	public ResponseEntity<Utilisateur> getUserById(@PathVariable("id") Integer id) {
		LOG.info("GET called on getUserById"); 
		Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
		return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
	}
	
//	@GetMapping("utilisateur/{nom}")
//	public ResponseEntity<List<Utilisateur>> getUserByNom(@PathVariable("nom") String nom) {
//		LOG.info("GET called on userExist"); 
//		List<Utilisateur> list  = utilisateurService.getUtilisateurByNom(nom);
//		return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
//	}
	
	@GetMapping("utilisateurs")
	public ResponseEntity<List<Utilisateur>> getAllUsers() {
		LOG.info("GET called on getAllUsers"); 
		List<Utilisateur> list = utilisateurService.getAllUtilisateurs();
		return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
	}
	
	@GetMapping("utilisateurExist/{email}")
	public ResponseEntity<Boolean> userExist(@PathVariable("email") String email) {
		LOG.info("GET called on userExist"); 
		Boolean exist = utilisateurService.userExist(email);
		return new ResponseEntity<Boolean>(exist, HttpStatus.OK);
	}
	
	@PostMapping("utilisateur")
	public ResponseEntity<Void> addUser(@RequestBody Utilisateur utilisateur, UriComponentsBuilder builder) {
				LOG.info("GET called on addUser");        
				boolean flag = utilisateurService.addUtilisateur(utilisateur);
                if (flag == false) {
                	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/article/{id}").buildAndExpand(utilisateur.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("utilisateur")
	public ResponseEntity<Utilisateur> updateUser(@RequestBody Utilisateur utilisateur) {
		LOG.info("GET called on updateUser");  
		utilisateurService.updateUtilisateur(utilisateur);
		return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
	}
	
	@DeleteMapping("utilisateur/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		LOG.info("GET called on deleteUser");  
		utilisateurService.deleteUtilisateur(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}






