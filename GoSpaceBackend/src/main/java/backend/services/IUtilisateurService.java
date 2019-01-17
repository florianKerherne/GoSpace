package backend.services;

import java.util.List;

import backend.model.Utilisateur;
public interface IUtilisateurService {
	 List<Utilisateur> getAllUtilisateurs();
	 Utilisateur getUtilisateurById(long Id);
     boolean addUtilisateur(Utilisateur utilisateur);
     void updateUtilisateur(Utilisateur utilisateur);
     void deleteUtilisateur(int Id);
}
