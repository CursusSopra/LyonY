package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Sortie {
	protected int idSortie;
	private int idLieu;
	private int idAmbiance;
	private int prixmin;
	private int prixmax;

	public List<Horaire> listeDesHoraires;
	private String stringHoraires;

	// /////////Getters & Setters///////////////
	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}

	public int getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}

	public int getIdAmbiance() {
		return idAmbiance;
	}

	public void setIdAmbiance(int idAmbiance) {
		this.idAmbiance = idAmbiance;
	}

	public int getPrixmin() {
		return prixmin;
	}

	public void setPrixmin(int prixmin) {
		this.prixmin = prixmin;
	}

	public int getPrixmax() {
		return prixmax;
	}

	public void setPrixmax(int prixmax) {
		this.prixmax = prixmax;
	}

	public String getStringHoraires() {
		return stringHoraires;
	}

	// Recupère les 7 horaires d'une sortie
	public List<Horaire> getListeDesHoraires(int idSortie) throws SQLException {
		listeDesHoraires = new ArrayList<Horaire>();
		// Connexion à la base de données postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();

		// Requête à exécuter
		String query = "SELECT jour, heuredebut, heurefin "
				+ "FROM ouvertures " + "INNER JOIN horaires USING(idhoraire) "
				+ "INNER JOIN plagehoraires  USING(idplagehoraire) "
				+ "WHERE idsortie =" + idSortie;

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Horaire h = new Horaire();
			PlageHoraire ph = new PlageHoraire();
			h.setJour(rs.getString("jour"));
			h.setPlageHoraire(ph);
			ph.setHeureDebut(rs.getTime("heuredebut"));
			ph.setHeureFin(rs.getTime("heureFin"));

			listeDesHoraires.add(h);
		}

		return listeDesHoraires;
	}

//	Récupère les horaires d'une sortie sous forme de STRING pour les afficher dans le formulaire de modification
	public String getStringHoraires(int idSortie) throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();
		String query = "SELECT "
				+ "STRING_AGG(CAST(heuredebut AS varchar(5)) || '-' || CAST(heurefin  AS varchar(5)), '|') "
				+ "FROM horaires ho "
				+ "INNER JOIN plagehoraires ph USING(idplagehoraire) "
				+ "INNER JOIN ouvertures ou USING(idhoraire) "
				+ "WHERE ou.idsortie = ? " + "GROUP BY ou.idsortie";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, idSortie);
		ResultSet rs = ps.executeQuery();
		return stringHoraires = rs.getString("string_agg");
	}

	// CTOR
	public Sortie() {
	}

	public Sortie(int idLieu, int idAmbiance, int prixmin, int prixmax) {
		this.idLieu = idLieu;
		this.idAmbiance = idAmbiance;
		this.prixmin = prixmin;
		this.prixmax = prixmax;
	}

	// METHODES PUBLIQUES
	public int save(Connection cnx) throws Exception {
		String query = " INSERT INTO sorties (idlieu, idambiance, prixmin, prixmax) VALUES (?,?,?,?) ";
		PreparedStatement ps = cnx.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idLieu);
		ps.setInt(2, idAmbiance);
		ps.setInt(3, prixmin);
		ps.setInt(4, prixmax);

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idSortie = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idSortie;
	}

}
