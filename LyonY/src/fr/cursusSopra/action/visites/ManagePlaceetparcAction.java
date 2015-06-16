package fr.cursusSopra.action.visites;

import java.sql.SQLException;

import fr.cursusSopra.model.Monument;
import fr.cursusSopra.model.Placeetparc;
import fr.cursusSopra.tech.Breadcrumbs;

public class ManagePlaceetparcAction extends VisitesAction {

	private static final long serialVersionUID = 1L;
	
	private int idPlaceetparc;
	private Placeetparc placeetparc;
	
	//GET SETS
	public Placeetparc getPlaceetparc() {
		return placeetparc;
	}
	public void setPlaceetparc(Placeetparc placeetparc) {
		this.placeetparc = placeetparc;
	}
	public void setIdPlaceetparc(int idPlaceetparc) {
		this.idPlaceetparc = idPlaceetparc;
	}
	
	//CTOR
	public ManagePlaceetparcAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Visites", "visites", null));
		listeBreadcrumbs.add(new Breadcrumbs("Places et parcs", "listeDesPlaceetparcs", null));
	}

	//METHODES PUBLIQUES
	public String execute() {
		return SUCCESS;
	}

	public String executeDetailsPlaceetparc(){
		
		try {
			placeetparc = new Placeetparc(idPlaceetparc);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();			
			return 	ERROR;
		}
	}
	
	public String executeCreationPlaceetparc(){
		
		return SUCCESS;
	}
	
	public String executeModifPlaceetparc(){
		
		return SUCCESS;
	}


}
