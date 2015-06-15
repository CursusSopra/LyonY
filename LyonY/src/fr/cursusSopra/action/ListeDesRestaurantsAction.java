package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.action.sorties.SortiesAction;
import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Restaurant;
import fr.cursusSopra.tech.Breadcrumbs;


public class ListeDesRestaurantsAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	
	private List<Restaurant> listeDesRestaurants;

	public List<Restaurant> getListeDesRestaurants() {

		return listeDesRestaurants;

	}

	public ListeDesRestaurantsAction() {
	
	}
	
	public String execute() {

		return SUCCESS;
	}
	
	public String executeListeDesRestaurants() {

		try {

			listeDesRestaurants = Restaurant.getListeDesRestaurants();

			return SUCCESS;

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return ERROR;

		}

	}


}