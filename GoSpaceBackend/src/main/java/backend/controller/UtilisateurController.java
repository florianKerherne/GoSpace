package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
import backend.services.IUtilisateurService;

@RestController()//@Controller//
@RequestMapping("/")//"/");
@Component
public class UtilisateurController {

	@Autowired
	private IUtilisateurService utilisateurService;
	@GetMapping("utilisateur/{id}")
	public ResponseEntity<Utilisateur> getArticleById(@PathVariable("id") Integer id) {
		Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
		return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
	}
	@GetMapping("articles")
	public ResponseEntity<List<Utilisateur>> getAllArticles() {
		List<Utilisateur> list = utilisateurService.getAllUtilisateurs();
		return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
	}
	@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Utilisateur utilisateur, UriComponentsBuilder builder) {
                boolean flag = utilisateurService.addUtilisateur(utilisateur);
                if (flag == false) {
        	   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/article/{id}").buildAndExpand(utilisateur.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("article")
	public ResponseEntity<Utilisateur> updateArticle(@RequestBody Utilisateur article) {
		utilisateurService.updateUtilisateur(article);
		return new ResponseEntity<Utilisateur>(article, HttpStatus.OK);
	}
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		utilisateurService.deleteUtilisateur(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}






