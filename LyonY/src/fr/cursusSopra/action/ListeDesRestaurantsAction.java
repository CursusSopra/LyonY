package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Bar;


public class ListeDesRestaurantsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public ListeDesRestaurantsAction() {

	}
	
	public String executeListeDesRestaurants() {

		return SUCCESS;

	}

}