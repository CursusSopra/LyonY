package fr.cursusSopra.action.sorties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Adresse;
import fr.cursusSopra.model.Ambiance;
import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Lieu;
import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.model.Sortie;
import fr.cursusSopra.tech.Breadcrumbs;
import fr.cursusSopra.tech.PostgresConnection;

public class DetailsBarAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	private int idBar;
	private Bar bar;
	private Sortie sortie;
	private Lieu lieu;
	private Adresse adresse;
	private List<Quartier> listeDesQuartiers;
	private List<Ambiance> listeDesAmbiances;
	
	private int idQuartier;
	private int numero;
	private String voie;
	private String codePostal;
	private String ville;
	private String nomL;
	private String description;
	private String accessibilite;
	private int idAmbiance;
	private int happyhour;
	private int prixmin;
	private int prixmax;
	
	
////////////Getters & Setters//////////////////////
	public void setIdBar(int idBar) {
		this.idBar = idBar;
	}
	public Bar getBar() {
		return bar;
	}
	public Sortie getSortie() {
		return sortie;
	}
	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
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
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}
	public List<Ambiance> getListeDesAmbiances() {
		return listeDesAmbiances;
	}
	public int getIdQuartier() {
		return idQuartier;
	}
	public void setIdQuartier(int idQuartier) {
		this.idQuartier = idQuartier;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNomL() {
		return nomL;
	}
	public void setNomL(String nomL) {
		this.nomL = nomL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccessibilite() {
		return accessibilite;
	}
	public void setAccessibilite(String accessibilite) {
		this.accessibilite = accessibilite;
	}
	public int getIdAmbiance() {
		return idAmbiance;
	}
	public void setIdAmbiance(int idAmbiance) {
		this.idAmbiance = idAmbiance;
	}
	public int getHappyhour() {
		return happyhour;
	}
	public void setHappyhour(int happyhour) {
		this.happyhour = happyhour;
	}
	
	public int getPrixmin() {
		return prixmin;
	}
	public void setPrixmin(int prixmin) {
		this.prixmin = prixmin;
	}
	public int getPrixmax() {
		return prixmax;
	}
	public void setPrixmax(int prixmax) {
		this.prixmax = prixmax;
	}
	
	//CTOR
	public DetailsBarAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
		listeBreadcrumbs.add(new Breadcrumbs("Bars", "listeDesBars", null));
	}

	
	//Méthodes publiques
	
	// INITIALISATION FORMULAIRE CREATION
	public String execute() {
		try {
			bar = new Bar();
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			listeDesAmbiances = Bar.getListeDesAmbiancesDeBar();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//DETAILS
	public String executeDetailsBar() {
		try {
			bar = new Bar(idBar);
			return SUCCESS;
		} catch (SQLException e) {
			return ERROR;
		}
	}
	

	// CREATION
		public String executeCreationBar(){
			Connection cnx = PostgresConnection.getConnexion();
			
			try {
				adresse = new Adresse(numero, voie, codePostal, ville, idQuartier);
				int idAdresse = adresse.save(cnx);
				
				lieu = new Lieu(nomL, idAdresse, description, accessibilite);
				int idLieu = lieu.save(cnx);
				
				sortie = new Sortie(idLieu, idAmbiance, prixmin, prixmax);
				int idSortie = sortie.save(cnx);
				happyhour=1;
				bar = new Bar(idSortie, happyhour);
				
				return bar.save(cnx) == 0 ? ERROR : SUCCESS ;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return ERROR;
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	
	
	//MODIFICATION
	public String executeModifBar(){

		return SUCCESS;
	}
}
