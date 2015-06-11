package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Monument;

public class ListeDesMonumentsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Monument> listeDesMonuments;

	public List<Monument> getListeDesMonuments() {
		return listeDesMonuments;
	}

	public ListeDesMonumentsAction() {

	}

	public String execute() {
		try {
			listeDesMonuments = Monument.getListMonuments();
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}

}
