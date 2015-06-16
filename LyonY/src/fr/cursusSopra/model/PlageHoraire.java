package fr.cursusSopra.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlageHoraire {
	
	private int idPlageHoraire;

	public int getIdPlageHoraire() {
		return idPlageHoraire;
	}

	private Date heureDebut;
	private Date heureFin;

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public PlageHoraire(String hd, String hf) {
		try {
			heureDebut = new SimpleDateFormat("HH:mm").parse(hd);
			heureFin = new SimpleDateFormat("HH:mm").parse(hf);
		} catch (ParseException e) {
		}
	}

	public PlageHoraire() {
	}

	public int save(Connection cnx) throws Exception {
		// Lecture de la BDD pour rechercher une PH déjà existante
		
		// Elle n'existe pas encore, on la crée
		PreparedStatement psPlageHoraire = cnx
				.prepareStatement(
						"INSERT INTO plagehoraires(heuredebut, heurefin) VALUES (?, ?)",
						Statement.RETURN_GENERATED_KEYS);

		psPlageHoraire.setDate(1, (java.sql.Date) heureDebut);
		psPlageHoraire.setDate(2, (java.sql.Date) heureFin);

		psPlageHoraire.executeUpdate();
		ResultSet rs = psPlageHoraire.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idPlageHoraire = rs.getInt(1);
		} else {
			throw new Exception();
		}

		return idPlageHoraire;
	}

}
