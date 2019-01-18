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
    private Voyage id_voyage;
    
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur id_utilisateur;
    
    @Column(name="nb_places_reserves")
    private Integer nb_places_reserves;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Voyage getId_voyage() {
		return id_voyage;
	}

	public void setId_voyage(Voyage id_voyage) {
		this.id_voyage = id_voyage;
	}

	public Utilisateur getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(Utilisateur id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public Integer getNb_places_reserves() {
		return nb_places_reserves;
	}

	public void setNb_places_reserves(Integer nb_places_reserves) {
		this.nb_places_reserves = nb_places_reserves;
	}
    
}
