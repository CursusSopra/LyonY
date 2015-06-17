package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Ambiance;
import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Nclub;
import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsNclubAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	private int idNightclub;
	private String nomnightclub;
	private int idquartier;
	private int idAmbiance;
	private int numero;
	private String voie;
	private int codepostal;
	private String ville;
	private String description;
	private String accessibilite;
	private int prixmin;
	private int prixmax;
	private Nclub nclub;
	private List<Quartier> listeDesQuartiers;
	private List<Ambiance> listeDesAmbiances;
	
	public void setIdAmbiance(int idAmbiance) {
		this.idAmbiance = idAmbiance;
	}
	public void setIdquartier(int idquartier) {
		this.idquartier = idquartier;
	}



	public void setIdNightclub(int idNightclub) {
		this.idNightclub = idNightclub;
	}
	public void setNomnightclub(String nomnightclub) {
		this.nomnightclub = nomnightclub;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAccessibilite(String accessibilite) {
		this.accessibilite = accessibilite;
	}
	public void setPrixmin(int prixmin) {
		this.prixmin = prixmin;
	}
	public void setPrixmax(int prixmax) {
		this.prixmax = prixmax;
	}
	public Nclub getNclub() {
		return nclub;
	}
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}
	public List<Ambiance> getListeDesAmbiances() {
		return listeDesAmbiances;
	}

	public DetailsNclubAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
		listeBreadcrumbs.add(new Breadcrumbs("Night Clubs", "listeDesNclubs", null));
	}
	
	//Méthodes publiques
	
	public String execute() {
		try {
			nclub = new Nclub(idNightclub);
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			listeDesAmbiances = Nclub.getListeDesAmbiancesDeNclub();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String executeDetailsNclub() {
		try {
			nclub = new Nclub(idNightclub);
			return SUCCESS;
		} catch (SQLException e) {
			return ERROR;
		}
	}
	
	public String executeCreationNclub(){

		return SUCCESS;
	}
	
	public String executeModifNclub(){
		
		try {
		
			Nclub.modifNightclub(idNightclub,nomnightclub,idAmbiance,idquartier,numero,voie,codepostal,ville,description,accessibilite,prixmin,prixmax );
			return SUCCESS;
		} catch (SQLException e) {
			return ERROR;
		}
	}
}