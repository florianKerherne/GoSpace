package backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Panier;
import backend.model.Utilisateur;
import backend.repository.PanierRepository;
import backend.repository.UtilisateurRepository;
import backend.services.interfaces.IPanierService;

@Service("IPanierService")
public class PanierService implements IPanierService{

	@Autowired
	PanierRepository panierRepository;
	UtilisateurRepository utilisateurRepository;
	
	@Override
	public Panier getPanierByIdPersonne(Integer Id) {
		Utilisateur user = utilisateurRepository.findById(Id);
		if(user == null) {
			return null;
		}
		return panierRepository.findByIdUtilisateur(user);
	}

	@Override
	public synchronized boolean addVoyageToPanier(Panier panier) {
		return panierRepository.save(panier) != null;
	}

}
