package backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Panier;
import backend.model.Utilisateur;
import backend.model.Voyage;
import backend.repository.PanierRepository;
import backend.repository.UtilisateurRepository;
import backend.repository.VoyageRepository;
import backend.services.interfaces.IPanierService;
import modelDTO.PanierDTO;

@Service("IPanierService")
public class PanierService implements IPanierService{

	@Autowired
	PanierRepository panierRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	VoyageRepository voyageRepository;
	
	@Override
	public List<Panier> getPanierByIdPersonne(Integer Id) {
		Utilisateur user = utilisateurRepository.findById(Id);
		if(user == null) {
			return null;
		}
		return panierRepository.findByIdUtilisateur(user);
	}

	@Override
	public synchronized boolean addVoyageToPanier(PanierDTO panierDTO) {
		Utilisateur user = utilisateurRepository.findById(panierDTO.getIdUtilisateur());
		Voyage voyage = voyageRepository.findById(panierDTO.getIdVoyage());
		if(user != null && voyage != null) {
			Panier panier = new Panier(voyage, user, panierDTO.getNbPlacesReserves());
			return panierRepository.save(panier) != null;
		}
		return false;
	}

}
