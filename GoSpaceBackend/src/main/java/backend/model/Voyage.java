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
	private Lieu id_lieu;
	
	@Column(name="nb_places_restantes")
	private Integer nb_places_restantes;
	
	@Column(name="prix")
	private float prix;
	
	@Column(name="promotion")
	private float promotion;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date_debut")
	private Calendar date_debut;
	
	@Column(name="date_fin")
	private Calendar date_fin;

	
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
		return id_lieu;
	}

	public void setId_lieu(Lieu id_lieu) {
		this.id_lieu = id_lieu;
	}

	public Integer getNb_places_restantes() {
		return nb_places_restantes;
	}

	public void setNb_places_restantes(Integer nb_places_restantes) {
		this.nb_places_restantes = nb_places_restantes;
	}

	public Calendar getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Calendar date_debut) {
		this.date_debut = date_debut;
	}

	public Calendar getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Calendar date_fin) {
		this.date_fin = date_fin;
	}

}
