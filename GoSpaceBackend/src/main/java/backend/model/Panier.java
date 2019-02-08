package backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "id_voyage")
    private Voyage idVoyage;
    
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur idUtilisateur;
    
    @Column(name="nb_places_reserves")
    private Integer nbPlacesReserves;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Voyage getId_voyage() {
		return idVoyage;
	}

	public void setId_voyage(Voyage id_voyage) {
		this.idVoyage = id_voyage;
	}

	public Utilisateur getId_utilisateur() {
		return idUtilisateur;
	}

	public void setId_utilisateur(Utilisateur id_utilisateur) {
		this.idUtilisateur = id_utilisateur;
	}

	public Integer getNb_places_reserves() {
		return nbPlacesReserves;
	}

	public void setNb_places_reserves(Integer nb_places_reserves) {
		this.nbPlacesReserves = nb_places_reserves;
	}
    
}
