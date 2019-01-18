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
	
}
