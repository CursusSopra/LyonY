package fr.cursusSopra.json;

import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Sortie;

public class JSONHorairesStringAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	// valeur de test - form modif horaire
	// --------------

	private int idSortie;
	private String timeStringJavaOut;


	public String getTimeStringJavaOut() {
		return timeStringJavaOut;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}


	// Récupération des horaires d'une Sortie existante en vue de la modifier
	// Appel de la methode getStringHoraires de Sortie.java
	public String execute() {
		try {
			Sortie s = new Sortie();
			s.setIdSortie(idSortie);
			timeStringJavaOut = s.getStringHoraires(idSortie);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

}
