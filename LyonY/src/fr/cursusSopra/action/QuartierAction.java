package fr.cursusSopra.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Quartier;

public class QuartierAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int idquartier;
	private String nom;
	private int budgetMoyen;
	private int distanceCentreVille;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String execute() {
		return SUCCESS;
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
