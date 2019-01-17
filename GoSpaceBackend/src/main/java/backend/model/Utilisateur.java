package backend.model;

import javax.persistence.*;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	
	// PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< Upstream, based on branch 'master' of https://github.com/florianKerherne/GoSpace.git
    @Column(name="id")
    private long id;
    @Column(name="nom")
=======
    private Integer id;

>>>>>>> 507c81f clean backend
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="email")
    private String email;
<<<<<<< Upstream, based on branch 'master' of https://github.com/florianKerherne/GoSpace.git
    @Column(name="mdp")
    private String mdp;
    @Column(name="admin")
=======
    private String mdp;
>>>>>>> 507c81f clean backend
    private Boolean admin;

    /*protected Utilisateur() {}
    
    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }*/

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

<<<<<<< Upstream, based on branch 'master' of https://github.com/florianKerherne/GoSpace.git
	public String getMdp() {
=======
	public String getMDP() {
>>>>>>> 507c81f clean backend
		return mdp;
	}

<<<<<<< Upstream, based on branch 'master' of https://github.com/florianKerherne/GoSpace.git
	public void setMdp(String mdp) {
		this.mdp = mdp;
=======
	public void setMDP(String mDP) {
		mdp = mDP;
>>>>>>> 507c81f clean backend
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}





