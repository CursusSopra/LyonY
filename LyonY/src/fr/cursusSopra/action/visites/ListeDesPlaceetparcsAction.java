package fr.cursusSopra.action.visites;

import java.sql.*;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Placeetparc;
import fr.cursusSopra.tech.Breadcrumbs;

public class ListeDesPlaceetparcsAction extends VisitesAction {

	private static final long serialVersionUID = 1L;

	private List<Placeetparc> listeDesPlaceetparcs;

	public List<Placeetparc> getListeDesPlaceetparcs() {
		return listeDesPlaceetparcs;
	}

	public ListeDesPlaceetparcsAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Visites", "visites", null));
	}

	public String execute() {
		try {
			listeDesPlaceetparcs = Placeetparc.getListeDesPlaceetparcs();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
