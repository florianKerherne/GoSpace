package backend.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="utilisateur")
public class Utilisateur implements Serializable {
	
	// PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    private String nom;
    @Column(name="prenom")
    private String prenom;
    
    @Column(name="mdp")
    private String mdp;
    
    @Column(name="email")
    private String email;
    
    @Column(name="isAdmin")
    private Boolean isAdmin;

    protected Utilisateur() {}
    
    public Utilisateur(String nom, String prenom, String email, String mdp, boolean isAdmin) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.isAdmin = false;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMDP() {
		return mdp;
	}

	public void setMDP(String mDP) {
		mdp = mDP;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


}





