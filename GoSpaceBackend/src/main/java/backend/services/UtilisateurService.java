package backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.model.Utilisateur;
import backend.repository.UtilisateurRepository;

@Service("IUtilisateurService")
public class UtilisateurService implements IUtilisateurService{

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurService() {
		System.out.println("CREE");
	}
	
	@Override
	public Utilisateur getUtilisateurById(long Id) {
		Utilisateur obj = utilisateurRepository.findById(Id).get();
		return obj;
	}	
	@Override
	public List<Utilisateur> getAllUtilisateurs(){
		List<Utilisateur> list = new ArrayList<>();
		utilisateurRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addUtilisateur(Utilisateur utilisateur){
	        List<Utilisateur> list = utilisateurRepository.findByNom(utilisateur.getNom()); 	
                if (list.size() > 0) {
    	           return false;
                } else {
                	utilisateurRepository.save(utilisateur);
    	        return true;
       }
	}
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
	}
	@Override
	public void deleteUtilisateur(int Id) {
		utilisateurRepository.delete(getUtilisateurById(Id));
	}
}
