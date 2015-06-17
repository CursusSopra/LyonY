package fr.cursusSopra.action;

import com.opensymphony.xwork2.ActionSupport;


public class HoraireAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String[] jours = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
	
	public String[] getJours() {
		return jours;
	}
	
	public String execute() {
		return SUCCESS;
	}

	
}
