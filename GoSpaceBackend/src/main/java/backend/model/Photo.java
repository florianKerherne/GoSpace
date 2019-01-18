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
@Table(name="photo")
public class Photo {
	
	@Id // PrimaryKey
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	//foreingn key
	@ManyToOne
	@JoinColumn(name = "id_lieu")
	private Lieu id_lieu;
	
	@Column(name="data")
	private String data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Lieu getId_lieu() {
		return id_lieu;
	}

	public void setId_lieu(Lieu id_lieu) {
		this.id_lieu = id_lieu;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
