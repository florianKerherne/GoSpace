package backend.services.interfaces;

import backend.model.Panier;

public interface IPanierService {
	
	Panier getPanierByIdPersonne(Integer Id);
	
	boolean addVoyageToPanier(Panier panier);

}
