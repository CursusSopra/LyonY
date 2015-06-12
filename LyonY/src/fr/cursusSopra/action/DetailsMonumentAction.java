package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Monument;

public class DetailsMonumentAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private List<Monument> listeDesMonuments;

	public List<Monument> getListeDesMonuments() {
		return listeDesMonuments;
	}

	public DetailsMonumentAction() {
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	private int idmonument;
	private Monument monument;

	public Monument getMonument() {
		return monument;
	}

	public void setIdmonument(int idmonument) {
		this.idmonument = idmonument;
	}

	public String executeDetailsMonument(){
		
		try {
			monument = new Monument(idmonument);
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 	ERROR;
		}
	}
}
