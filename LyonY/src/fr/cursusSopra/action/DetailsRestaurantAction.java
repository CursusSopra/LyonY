package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.action.sorties.SortiesAction;
import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Restaurant;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsRestaurantAction extends SortiesAction {

	private static final long serialVersionUID = 1L;

	private List<Bar> listeDesRestaurants;

	public List<Bar> getListeDesRestaurants() {

		return listeDesRestaurants;

	}

	public DetailsRestaurantAction() {
		super();
		listeBreadcrumbs.add(new Breadcrumbs("Les restaurants", "listeDesRestaurants", null));
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