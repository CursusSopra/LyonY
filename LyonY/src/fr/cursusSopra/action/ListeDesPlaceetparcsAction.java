package fr.cursusSopra.action;

import java.sql.*;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Placeetparc;

public class ListeDesPlaceetparcsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Placeetparc> listeDesPlaceetparcs;

	public List<Placeetparc> getListeDesPlaceetparcs() {
		return listeDesPlaceetparcs;
	}

	public ListeDesPlaceetparcsAction() {

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
