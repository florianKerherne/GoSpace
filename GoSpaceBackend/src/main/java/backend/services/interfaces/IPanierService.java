package backend.services.interfaces;

import java.util.List;

import backend.model.Panier;
import modelDTO.PanierDTO;

public interface IPanierService {
	
	List<Panier> getPanierByIdPersonne(Integer Id);
	
	boolean addVoyageToPanier(PanierDTO panier);

}
