package backend.services.interfaces;

import backend.model.Panier;
import modelDTO.PanierDTO;

public interface IPanierService {
	
	Panier getPanierByIdPersonne(Integer Id);
	
	boolean addVoyageToPanier(PanierDTO panier);

}
