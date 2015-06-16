package fr.cursusSopra.action.visites;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Adresse;
import fr.cursusSopra.model.Lieu;
import fr.cursusSopra.model.Monument;
import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.model.Typevisite;
import fr.cursusSopra.tech.Breadcrumbs;
import fr.cursusSopra.tech.PostgresConnection;

public class ManageMonumentAction extends VisitesAction {

	private static final long serialVersionUID = 1L;
	
	private int idMonument;
	private Monument monument;
	private Lieu lieu;
	private Adresse adresse;
	private List<Quartier> listeDesQuartiers;
	private List<Typevisite> listeDesTypevisites;
	
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
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<Typevisite> getListeDesTypevisites() {
		return listeDesTypevisites;
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
	// INITIALISATION FORMULAIRE CREATION
	public String execute() {
		try {
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			listeDesTypevisites = Monument.getListeDesTypevisitesDeMonument();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	// DETAILS
	public String executeDetailsMonument(){
		
		try {
			monument = new Monument(idMonument);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return 	ERROR;
		}
	}
	
	// CREATION
	public String executeCreationMonument(){
		//adresse = new Adresse(numero, voie, codePostal, ville, idQuartier);
		//Connection cnx = PostgresConnection.getConnexion();
		//adresse.create(cnx);
		
		return SUCCESS;
	}
	
	// MODIFICATION
	public String executeModifMonument(){

		return SUCCESS;
	}
	
}
