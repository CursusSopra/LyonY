package fr.cursusSopra.action.visites;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Monument;
import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.tech.Breadcrumbs;

public class ManageMonumentAction extends VisitesAction {

	private static final long serialVersionUID = 1L;
	
	private int idMonument;
	private Monument monument;
	private List<Quartier> listeDesQuartiers;
	
	// GETSETS
	public Monument getMonument() {
		return monument;
	}
	public void setMonument(Monument monument) {
		this.monument = monument;
	}
	public void setIdMonument(int idMonument) {
		this.idMonument = idMonument;
	}
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}
	
	//CTOR
	public ManageMonumentAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Visites", "visites", null));
		listeBreadcrumbs.add(new Breadcrumbs("Monuments", "listeDesMonuments", null));
	}
	
	// METHODES PUBLIQUES
	public String execute() {
		try {
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String executeDetailsMonument(){
		
		try {
			monument = new Monument(idMonument);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return 	ERROR;
		}
	}
	
	public String executeCreationMonument(){

		return SUCCESS;
	}
	
	public String executeModifMonument(){

		return SUCCESS;
	}
	
}
