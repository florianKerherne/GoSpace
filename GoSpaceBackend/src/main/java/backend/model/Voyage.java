package backend.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voyage")
public class Voyage {

	// PrimaryKey
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	//Manque le id_Lieu (foreingn key)
	
	private Integer nbPlacesRestantes;
	private float prix;
	private float promotion;
	private String description;
	private Calendar dateDebut;
	private Calendar dateFin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNbPlacesRestantes() {
		return nbPlacesRestantes;
	}

	public void setNbPlacesRestantes(Integer nbPlacesRestantes) {
		this.nbPlacesRestantes = nbPlacesRestantes;
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

	public Calendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Calendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Calendar getDateFin() {
		return dateFin;
	}

	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

}
