package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Horaire;

public class HoraireAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	public List<Horaire> listeDesHorairesTest;
	
	private static String[] jours = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
	
	public static String[] getJours() {
		return jours;
	}
	
	public String execute() throws SQLException {
		return SUCCESS;
	}

	
}
