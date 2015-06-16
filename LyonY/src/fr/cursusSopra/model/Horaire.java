package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Horaire {
	private int idHoraire;

	private String jour;
	private PlageHoraire plageHoraire;
	private int idPlageHoraire;

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

	public Horaire() {
	}
	public Horaire(String jour, int idPlageHoraire) {
		this.jour = jour;
		this.idPlageHoraire = idPlageHoraire;
	}

	public int save(Connection cnx) throws Exception {
		// Lecture de la BDD pour rechercher une H déjà existant

		// Il n'existe pas encore, on le crée
		PreparedStatement psHoraire = cnx.prepareStatement(
				"IINSERT INTO horaires(jour, idplagehoraire) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);

		psHoraire.setString(1, jour);
		psHoraire.setInt(2, idPlageHoraire);

		psHoraire.executeUpdate();
		ResultSet rs = psHoraire.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idHoraire = rs.getInt(1);
		} else {
			throw new Exception();
		}

		return idHoraire;
	}

}
