package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.model.Restaurant;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsRestaurantAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	private int idrestaurant;
	private Restaurant restaurant;
	private List<Quartier> listeDesQuartiers;

	public void setIdrestaurant(int idrestaurant) {
		this.idrestaurant = idrestaurant;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}
	
	public DetailsRestaurantAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
		listeBreadcrumbs.add(new Breadcrumbs("Restaurants", "listeDesRestaurants", null));
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
	
	public String executeDetailsRestaurant() {
		try {
			restaurant = new Restaurant(idrestaurant);
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