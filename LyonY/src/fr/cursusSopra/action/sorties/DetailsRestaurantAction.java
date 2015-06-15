package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import fr.cursusSopra.model.Restaurant;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsRestaurantAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	private int idrestaurant;
	private Restaurant restaurant;

	public void setIdrestaurant(int idrestaurant) {
		this.idrestaurant = idrestaurant;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public DetailsRestaurantAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
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
}