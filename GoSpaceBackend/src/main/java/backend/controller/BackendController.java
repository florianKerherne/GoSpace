package backend.controller;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend.modelInterface.UtilisateurRepository;

@RestController()
@RequestMapping("/")
public class BackendController {

	private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
	
	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

	@Autowired
    private UtilisateurRepository userRepository;
	
	
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

}






