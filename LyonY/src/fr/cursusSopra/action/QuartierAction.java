package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Quartier;

public class QuartierAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int idquartier;
	private String nom;
	private int budgetMoyen;
	private int distanceCentreVille;
	public List<Quartier> listeDesQuartiers;
	
	// GETSETS
	public int getIdquartier() {
		return idquartier;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getBudgetMoyen() {
		return budgetMoyen;
	}
	public void setBudgetMoyen(int budgetMoyen) {
		this.budgetMoyen = budgetMoyen;
	}
	public int getDistanceCentreVille() {
		return distanceCentreVille;
	}
	public void setDistanceCentreVille(int distanceCentreVille) {
		this.distanceCentreVille = distanceCentreVille;
	}
	public void setIdquartier(int idquartier) {
		this.idquartier = idquartier;
	}
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}
	// METHODES EXECUTE() 
	public String execute() {
		try {
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String executeCreation() {

		try {
			Quartier q = new Quartier(idquartier);
			q.setNom(nom);
			q.setBudgetMoyen(budgetMoyen);
			q.setDistanceCentreVille(distanceCentreVille);

			return q.create() != 0 ? SUCCESS : ERROR;

		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
