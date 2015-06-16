package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsBarAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	private int idBar;
	private Bar bar;
	private List<Quartier> listeDesQuartiers;
	
	public void setIdBar(int idBar) {
		this.idBar = idBar;
	}
	public Bar getBar() {
		return bar;
	}
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}

	public DetailsBarAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
		listeBreadcrumbs.add(new Breadcrumbs("Bars", "listeDesBars", null));
	}

	
	//Méthodes publiques
	
	public String execute() {
		try {
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String executeDetailsBar() {
		try {
			bar = new Bar(idBar);
			return SUCCESS;
		} catch (SQLException e) {
			return ERROR;
		}
	}
	
	public String executeCreationBar(){

		return SUCCESS;
	}
	
	public String executeModifBar(){

		return SUCCESS;
	}
}