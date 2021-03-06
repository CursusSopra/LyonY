package fr.cursusSopra.action.sorties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Horaire;
import fr.cursusSopra.model.Ouverture;
import fr.cursusSopra.model.PlageHoraire;
import fr.cursusSopra.model.Sortie;
import fr.cursusSopra.tech.PostgresConnection;

public class ManageSortieAction extends ActionSupport {
	private static final long serialVersionUID = 1L;


	private int idSortie;
	private String[] heureDebut = new String[7];
	private String[] heureFin = new String[7];
	private String[] jours = { "Lundi", "Mardi", "Mercredi", "Jeudi",
			"Vendredi", "Samedi", "Dimanche" };
	private String timeString;
	private String timeStringJavaOut;
	public List<Horaire> listeDesHoraires;

	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}

	public void setHeureDebut(String[] heureDebut) {
		this.heureDebut = heureDebut;
	}

	public void setHeureFin(String[] heureFin) {
		this.heureFin = heureFin;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public String getStringHoraires() {
		return timeStringJavaOut;
	}

	public void setStringHoraires(String stringHoraires) {
		this.timeStringJavaOut = stringHoraires;
	}

	public String[] getJours() {
		return jours;
	}

	public String execute() {
		return SUCCESS;
	}

	// Création des horaires d'une sortie puis appel de la méthode de
	// Sortie.java qui les ajoute dans la DB

	public String executeCreationHoraire() {
		timeStringToArray(timeString);

		Connection cnx = PostgresConnection.getConnexion();

		try {
			// On se met en mode 'transaction'
			cnx.setAutoCommit(false);

			for (int i = 0; i < jours.length; i++) {
				PlageHoraire ph = new PlageHoraire(heureDebut[i], heureFin[i]);
				int idPlageHoraire = ph.save(cnx);

				Horaire h = new Horaire(jours[i], idPlageHoraire);
				int idHoraire = h.save(cnx);

				Ouverture ouv = new Ouverture(idHoraire, idSortie);
				ouv.save(cnx);
			}
			return SUCCESS;
		} catch (Exception e) {
			try {
				cnx.rollback();
				e.printStackTrace();
				return ERROR;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// On remet en mode 'auto-commit'
				cnx.setAutoCommit(true);
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ERROR;
	}

	// Récupération des horaires d'une Sortie existante en vue de la modifier
	// Appel de la methode getStringHoraires de Sortie.java
	public String executeFormModifHoraire() {
		try {
			Sortie s = new Sortie();
			s.setIdSortie(idSortie);
			timeStringJavaOut = s.getStringHoraires(idSortie);
			listeDesHoraires = s.getListeDesHoraires(idSortie);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}
	
	public String executeModifHoraire() {
		
		Sortie s = new Sortie();
		s.setIdSortie(idSortie);
		
		// SUPPR DES HORAIRES EXISTANTS
		s.deleteHoraire();
		
		// ON CREE DES NOUVEAUX HORAIRES
		executeCreationHoraire();
		return SUCCESS;
		
	}

	private void timeStringToArray(String timeString) {

		// On crée un tableau de "hd-hf"
		System.out.println(timeString);
		String[] temp1 = timeString.split("\\|");
		for (int i = 0; i < temp1.length; i++) {

			// On crée un tableau de "hd" et "hf"
			String[] temp2 = temp1[i].split("\\-");

			// On valorise les tableaux heureDebut et heureFin
			heureDebut[i] = temp2[0];
			heureFin[i] = temp2[1];
		}
	}
}
