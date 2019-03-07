package backend.services.interfaces;

import java.util.List;

import backend.model.Utilisateur;

public interface IUtilisateurService {
	
	 List<Utilisateur> getAllUtilisateurs();
	 Utilisateur getUtilisateurById(long Id);
	 List<Utilisateur> getUtilisateurByNom(String nom);
     boolean addUtilisateur(Utilisateur utilisateur);
     boolean userExist(String email);
     boolean login(String email, String mdp);
     void updateUtilisateur(Utilisateur utilisateur);
     void deleteUtilisateur(int Id);
     Integer getIdUtilisateurByEmail(String email);
}
