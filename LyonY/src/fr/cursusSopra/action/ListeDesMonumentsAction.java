package fr.cursusSopra.action;

import java.sql.*;
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
			listeDesMonuments = Monument.getListeDesMonuments();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
