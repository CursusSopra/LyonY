package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Restaurant;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsRestaurantAction extends ListeDesRestaurantsAction {

	private static final long serialVersionUID = 1L;

	private List<Restaurant> listeDesRestaurants;

	public List<Restaurant> getListeDesRestaurants() {

		return listeDesRestaurants;

	}

	public DetailsRestaurantAction() {
		super();
		listeBreadcrumbs.add(new Breadcrumbs("Restaurants", "listeDesRestaurants", null));
	}

	public String execute() {

		return SUCCESS;
	}

	private int idrestaurant;
	private Restaurant restaurant;

	public void setIdrestaurant(int idrestaurant) {
		this.idrestaurant = idrestaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public String executeDetailsRestaurant() {
		try {
			restaurant = new Restaurant(idrestaurant);
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}

	}
}