package backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Upstream, based on branch 'master' of https://github.com/florianKerherne/GoSpace.git
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 507c81f clean backend
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< Upstream, based on branch 'master' of https://github.com/florianKerherne/GoSpace.git
import backend.model.Utilisateur;
import backend.services.IUtilisateurService;
=======
import backend.repository.UtilisateurRepository;

>>>>>>> 507c81f clean backend

@Controller//@RestController()//@Controller//
@RequestMapping("/")//"/");
public class BackendController {

	private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
	
	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
<<<<<<< Upstream, based on branch 'master' of https://github.com/florianKerherne/GoSpace.git

	//@Autowired
    //private IUtilisateurService utilisateurService;
=======
>>>>>>> 507c81f clean backend
	
	@Autowired
	UtilisateurRepository utilisateur;
	
	//fonction de récuperation des informations pour Jira 
	@RequestMapping(value  = "about", method = RequestMethod.GET)
	public @ResponseBody String getInfo() {
		LOG.info("GET called on /about");
		return HELLO_TEXT;
	}
	
	@RequestMapping(value  = "/", method = RequestMethod.GET)
	public @ResponseBody String getInfo3() {
		LOG.info("GET called on default");
		return HELLO_TEXT;
	}
	
	/*@GetMapping("utilisateur/{id}")
	public ResponseEntity<Utilisateur> getArticleById(@PathVariable("id") Integer id) {
		Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
		return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
	}*/

//	@GetMapping(path="/user/{id}")
//    public @ResponseBody Utilisateur getUserById(@PathVariable("id") long id) {
//        LOG.info("Reading user with id " + id + " from database.");
//        return userRepository.findById(id).get();
//    }
}






