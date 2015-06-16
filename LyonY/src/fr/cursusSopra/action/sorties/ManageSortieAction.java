package fr.cursusSopra.action.sorties;

import java.sql.Connection;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Horaire;
import fr.cursusSopra.model.Ouverture;
import fr.cursusSopra.model.PlageHoraire;
import fr.cursusSopra.tech.PostgresConnection;

public class ManageSortieAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	// Valeurs de Tests -  À supprimer
	//	-------------------------
	private String[] heureDebut = { "08:00" };
	private String[] heureFin = { "12:00" };
	private int idSortie = 10;
	//	-------------------------

	// public void setHeureDebut(String[] heureDebut) {
	// this.heureDebut = heureDebut;
	// }
	//
	// public void setHeureFin(String[] heureFin) {
	// this.heureFin = heureFin;
	// }

	// Création des horaires d'une sortie puis appel de la méthode de
	// Sortie.java qui les ajoute dans la DB
	public String executeInsert() {
		String[] arrayJours = { "lundi", "mardi", "mercredi", "jeudi",
				"vendredi", "samedi", "dimanche" };
		Connection cnx = PostgresConnection.getConnexion();

		try {
			// On se met en mode 'transaction'
			cnx.setAutoCommit(false);
			
			for (int i = 0; i < 1; i++) { // arrayJours.length				
				PlageHoraire ph = new PlageHoraire(heureDebut[i], heureFin[1]);
				int idPlageHoraire =  ph.save(cnx);
				
				Horaire h = new Horaire(arrayJours[i], idPlageHoraire);
				int idHoraire = h.save(cnx);
				
				Ouverture ouv = new Ouverture(idHoraire, idSortie);
				ouv.save(cnx);
			}
			return SUCCESS;
		} catch (Exception e) {
			try {cnx.rollback(); return ERROR;} catch (SQLException e1) {}
		} finally {
			try {
				// On remet en mode 'auto-commit'
				cnx.setAutoCommit(true);
				cnx.close();
			} catch (SQLException e) {
			}
		}
		return ERROR;


		// h.setJour(arrayJours[i]);
		//
		// h.setPlageHoraire(pH);
		//
		// pH.setHeureDebut(heureDebut);
		// pH.setHeureFin(heureFin);
		//
		// try {
		// return h.save() != 0 ? SUCCESS : ERROR;
		// } catch (ParseException e1) {
		// e1.printStackTrace();
		// return ERROR;
		// } catch (SQLException e) {
		// return ERROR;
		// }

	}
}
