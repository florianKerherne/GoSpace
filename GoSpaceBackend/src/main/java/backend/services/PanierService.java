package backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Panier;
import backend.repository.PanierRepository;
import backend.services.interfaces.IPanierService;

@Service("IPanierService")
public class PanierService implements IPanierService{

	@Autowired
	PanierRepository panierRepository;
	
	@Override
	public Panier getPanierByIdPersonne(Integer Id) {
		return panierRepository.findByIdUtilisateur(Id);
	}

	@Override
	public synchronized boolean addVoyageToPanier(Panier panier) {
		return panierRepository.save(panier) != null;
	}

}
