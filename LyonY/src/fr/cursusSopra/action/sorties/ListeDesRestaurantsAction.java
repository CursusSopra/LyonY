package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Restaurant;
import fr.cursusSopra.tech.Breadcrumbs;

public class ListeDesRestaurantsAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	
	private List<Restaurant> listeDesRestaurants;

	public List<Restaurant> getListeDesRestaurants() {
		return listeDesRestaurants;
	}

	public ListeDesRestaurantsAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String executeListeDesRestaurants() {
		try {
			listeDesRestaurants = Restaurant.getListeDesRestaurants();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}