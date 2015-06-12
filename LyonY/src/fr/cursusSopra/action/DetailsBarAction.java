package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Bar;

public class DetailsBarAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Bar> listeDesBars;

	public List<Bar> getListeDesBars() {

		return listeDesBars;

	}

	public DetailsBarAction() {
	}
	
	public String execute() {

		return SUCCESS;
	}

	public String executeDetailsBar() {

		return SUCCESS;

	}

}