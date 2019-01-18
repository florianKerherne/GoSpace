package backend.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voyage")
public class Voyage {
	
	@Id // PrimaryKey
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	//foreingn key
	@ManyToOne
	@JoinColumn(name = "id_lieu")
	private Lieu idLieu;
	
	@Column(name="nb_places_restantes")
	private Integer nbPlacesRestantes;
	
	@Column(name="prix")
	private float prix;
	
	@Column(name="promotion")
	private float promotion;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date_debut")
	private Calendar dateDebut;

	@Column(name="date_fin")
	private Calendar dateFin;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public float getPromotion() {
		return promotion;
	}

	public void setPromotion(float promotion) {
		this.promotion = promotion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Lieu getId_lieu() {
		return idLieu;
	}

	public void setId_lieu(Lieu id_lieu) {
		this.idLieu = id_lieu;
	}

	public Integer getNb_places_restantes() {
		return nbPlacesRestantes;
	}

	public void setNb_places_restantes(Integer nb_places_restantes) {
		this.nbPlacesRestantes = nb_places_restantes;
	}

	public Calendar getDate_debut() {
		return dateDebut;
	}

	public void setDate_debut(Calendar date_debut) {
		this.dateDebut = date_debut;
	}

	public Calendar getDate_fin() {
		return dateFin;
	}

	public void setDate_fin(Calendar date_fin) {
		this.dateFin = date_fin;
	}

}
