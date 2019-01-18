package backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Utilisateur;
import backend.services.IUtilisateurService;

@RestController()
@RequestMapping("/")
public class BackendController {

	private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
	
	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
	
	//fonction de récuperation des information
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

}






