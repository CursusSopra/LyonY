package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Ambiance;
import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.model.Restaurant;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsRestaurantAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	private int idRestaurant;
	private Restaurant restaurant;
	private List<Quartier> listeDesQuartiers;
	private List<Ambiance> listeDesAmbiances;

	public void setIdrestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}
	public List<Ambiance> getListeDesAmbiances() {
		return listeDesAmbiances;
	}
	
	public DetailsRestaurantAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
		listeBreadcrumbs.add(new Breadcrumbs("Restaurants", "listeDesRestaurants", null));
	}
	
	//Méthodes publiques
	public String execute() {
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
	
	public String executeDetailsRestaurant() {
		try {
			restaurant = new Restaurant(idRestaurant);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String executeCreationRestaurant(){

		return SUCCESS;
	}
	
	public String executeModifRestaurant(){

		return SUCCESS;
	}
}