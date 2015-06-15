package fr.cursusSopra.action.visites;

import java.sql.*;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Monument;
import fr.cursusSopra.tech.Breadcrumbs;

public class ListeDesMonumentsAction extends VisitesAction {

	private static final long serialVersionUID = 1L;

	private List<Monument> listeDesMonuments;

	public List<Monument> getListeDesMonuments() {
		return listeDesMonuments;
	}

	public ListeDesMonumentsAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Visites", "visites", null));
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
