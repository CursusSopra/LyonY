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
	private Nclub nclub;
	private List<Quartier> listeDesQuartiers;
	private List<Ambiance> listeDesAmbiances;

	public void setIdNightclub(int idNightclub) {
		this.idNightclub = idNightclub;
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

		return SUCCESS;
	}
}