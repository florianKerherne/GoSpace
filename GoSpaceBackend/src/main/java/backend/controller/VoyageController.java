package backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend.repository.VoyageRepository;


@RestController()
@RequestMapping("/")
public class VoyageController {

	@Autowired(required=false)
	VoyageRepository voyage;
}
