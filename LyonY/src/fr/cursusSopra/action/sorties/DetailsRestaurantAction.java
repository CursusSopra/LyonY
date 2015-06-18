package fr.cursusSopra.action.sorties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Adresse;
import fr.cursusSopra.model.Ambiance;
import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Lieu;
import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.model.Restaurant;
import fr.cursusSopra.model.Sortie;
import fr.cursusSopra.tech.Breadcrumbs;
import fr.cursusSopra.tech.PostgresConnection;

public class DetailsRestaurantAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	private int idRestaurant;
	private Restaurant restaurant;
	private Sortie sortie;
	private Lieu lieu;
	private Adresse adresse;
	private List<Quartier> listeDesQuartiers;
	private List<Ambiance> listeDesAmbiances;
	private String nomrestaurant;
	private int idQuartier;
	private int numero;
	private String voie;
	private String codePostal;
	private String ville;
	private String nomL;
	private String description;
	private String accessibilite;
	private int idAmbiance;
	private boolean reservation;
	private boolean aemporter;
	private int prixmin;
	private int prixmax;

	// /////////////////Getters and Setters///////////////////////

	public String getNomrestaurant() {
		return nomrestaurant;
	}

	public void setNomrestaurant(String nomrestaurant) {
		this.nomrestaurant = nomrestaurant;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
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

	public boolean isReservation() {
		return reservation;
	}

	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}

	public boolean isAemporter() {
		return aemporter;
	}

	public void setAemporter(boolean aemporter) {
		this.aemporter = aemporter;
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

	// CTOR
	public DetailsRestaurantAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
		listeBreadcrumbs.add(new Breadcrumbs("Restaurants",
				"listeDesRestaurants", null));
	}

	// Méthodes publiques

	// INITIALISATION FORMULAIRE CREATION
	public String execute() {
		try {

			listeDesQuartiers = Quartier.getListeDesQuartiers();
			listeDesAmbiances = Restaurant.getListeDesAmbiancesDeRestaurant();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	// DETAILS
	public String executeDetailsRestaurant() {
		try {
			restaurant = new Restaurant(idRestaurant);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	// CREATION
	public String executeCreationRestaurant() {
		Connection cnx = PostgresConnection.getConnexion();

		try {
			adresse = new Adresse(numero, voie, codePostal, ville, idQuartier);
			int idAdresse = adresse.save(cnx);

			lieu = new Lieu(nomL, idAdresse, description, accessibilite);
			int idLieu = lieu.save(cnx);

			sortie = new Sortie(idLieu, idAmbiance, prixmin, prixmax);
			int idSortie = sortie.save(cnx);

			restaurant = new Restaurant(idSortie, reservation, aemporter);

			return restaurant.save(cnx) == 0 ? ERROR : SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	// Modification

	public String executeFormModifRestaurant() {

		try {
			restaurant = new Restaurant(idRestaurant);
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			listeDesAmbiances = Restaurant.getListeDesAmbiancesDeRestaurant();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String executeModifRestaurant() {

		try {
			restaurant = new Restaurant(idRestaurant);
			restaurant.modifRestaurant(nomrestaurant, idAmbiance, idQuartier,
					numero, voie, codePostal, ville, description,
					accessibilite, prixmin, prixmax, reservation, aemporter);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}

	}

}