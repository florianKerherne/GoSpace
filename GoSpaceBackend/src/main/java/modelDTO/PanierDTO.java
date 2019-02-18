package modelDTO;

public class PanierDTO {
	
    private Integer idVoyage;
    
    private Integer idUtilisateur;
    
    private Integer nbPlacesReserves;
    
    protected PanierDTO() {}
    
	public PanierDTO(Integer idVoyage, Integer idUtilisateur, Integer nbPlacesReserves) {
		this.idVoyage = idVoyage;
		this.idUtilisateur = idUtilisateur;
		this.nbPlacesReserves = nbPlacesReserves;
	}

	public Integer getIdVoyage() {
		return idVoyage;
	}

	public void setIdVoyage(Integer idVoyage) {
		this.idVoyage = idVoyage;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Integer getNbPlacesReserves() {
		return nbPlacesReserves;
	}

	public void setNbPlacesReserves(Integer nbPlacesReserves) {
		this.nbPlacesReserves = nbPlacesReserves;
	}

}
