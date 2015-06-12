package fr.cursusSopra.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Restaurant {

	private int idrestaurant;
	private int idsortie;
	private String nomrestaurant;
	private String nomquartier;
	private int prixmin;
	private int prixmax;
	private String libambiance;
	private int numero;
	private String voie;
	private int codepostal;
	private String ville;
	private String description;
	private boolean reservation;
	private boolean aemporter;

	public Restaurant() {

	}

	// ////////////////////////////// Getters and
	// Setters/////////////////////////////////////////////////////////////

	public int getIdrestaurant() {
		return idrestaurant;
	}
	public void setIdrestaurant(int idrestaurant) {
		this.idrestaurant = idrestaurant;
	}

	public int getIdsortie() {
		return idsortie;
	}
	public void setIdsortie(int idsortie) {
		this.idsortie = idsortie;
	}

	public String getNomrestaurant() {
		return nomrestaurant;
	}
	public void setNomrestaurant(String nomrestaurant) {
		this.nomrestaurant = nomrestaurant;
	}

	public String getNomquartier() {
		return nomquartier;
	}
	public void setNomquartier(String nomquartier) {
		this.nomquartier = nomquartier;
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

	public String getLibambiance() {
		return libambiance;
	}
	public void setLibambiance(String libambiance) {
		this.libambiance = libambiance;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}

	public int getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isReservation() {
		return reservation;
	}
	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}

	public boolean isAemporter() {
		return aemporter;
	}
	public void setAemporter(boolean aemporter) {
		this.aemporter = aemporter;
	}

	// public Restaurant(int id) throws SQLException {
	// idbar = id;
	//
	// // Connexion à la BDD postgreSQL
	// Connection cnx = PostgresConnection.getConnexion();
	// // Object instruction SQL
	// Statement stmt = cnx.createStatement();
	//
	// // Requête à exécuter
	// String query =
	// "SELECT b.idbar, l.nom nombar,q.nom nomquartier, libambiance, prixmin, prixmax, numero, voie, ville, description, happyhour "
	// + "FROM bars b "
	// + "INNER JOIN sorties s ON s.idsortie=b.idsortie "
	// + "INNER JOIN lieux l ON s.idlieu=l.idlieu "
	// + "INNER JOIN adresses a ON a.idadresse=l.idadresse "
	// + "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
	// + "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
	// + "WHERE b.idbar = "+ idbar;
//	
//	SELECT r.idrestaurant, l.nom nomrestaurant,q.nom nomquartier, numero, voie, codepostal, ville, libambiance, prixmin, prixmax, description, reservation, aemporter
//	FROM restaurants r
//	INNER JOIN sorties s ON s.idsortie=r.idsortie
//	INNER JOIN lieux l ON s.idlieu=l.idlieu 
//	INNER JOIN adresses a ON a.idadresse=l.idadresse
//	INNER JOIN quartiers q ON q.idquartier=a.idquartier
//	INNER JOIN ambiances am ON am.idambiance=s.idambiance
	//
	// // Obtention de l'ensemble résultats
	// ResultSet rs = stmt.executeQuery(query);
	// if (rs.next()) {
	// idbar = rs.getInt("idbar");
	// nombar = rs.getString("nombar");
	// nomquartier = rs.getString("nomquartier");
	// libambiance = rs.getString("libambiance");
	// prixmin = rs.getInt("prixmin");
	// prixmax = rs.getInt("prixmax");
	// numero = rs.getInt("numero");
	// voie = rs.getString("voie");
	// ville = rs.getString("ville");
	// description = rs.getString("description");
	//
	// }
	//
	// }

	// public int save() throws SQLException {
	// Connection cnx = PostgresConnection.getConnexion();
	// String query =
	// "INSERT INTO candidats(nom, prenom, datenaissance, villenaissance) "
	// + "VALUES (?, ?, ?, ?)";
	// PreparedStatement ps = cnx.prepareStatement(query);
	// ps.setString(1, nom);
	// ps.setString(2, prenom);
	// ps.setDate(3, new java.sql.Date(dateNaissance.getTime()));
	// ps.setString(4, villeNaissance);
	//
	// int ret = ps.executeUpdate();
	//
	// return ret;
	//
	// }
	//
	// public int edit() throws SQLException {
	// Connection cnx = PostgresConnection.getConnexion();
	// String query =
	// "UPDATE candidats SET nom=?, prenom=?, datenaissance=?, villenaissance=? "
	// + "WHERE idCandidat=?";
	// PreparedStatement ps = cnx.prepareStatement(query);
	// ps.setString(1, nom);
	// ps.setString(2, prenom);
	// ps.setDate(3, new java.sql.Date(dateNaissance.getTime()));
	// ps.setString(4, villeNaissance);
	// ps.setInt(5, idCandidat);
	//
	//
	// int ret = ps.executeUpdate();
	//
	// return ret;
	//
	// }
	//
	// public int delete() throws SQLException {
	// Connection cnx = PostgresConnection.getConnexion();
	// String query = "DELETE FROM candidats "
	// + "WHERE idCandidat=?";
	// PreparedStatement ps = cnx.prepareStatement(query);
	// ps.setInt(1, idCandidat);
	//
	// int ret = ps.executeUpdate();
	//
	// return ret;
	//
	// }

	/* Membres statiques */
	public static List<Restaurant> listeDesRestaurants;

	public static List<Restaurant> getListeDesRestaurants() throws SQLException {

		listeDesRestaurants = new ArrayList<Restaurant>();

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query = "SELECT r.idrestaurant, l.nom nomrestaurant,q.nom nomquartier, libambiance, prixmin, prixmax "
				+ "FROM restaurants r  "
				+ "INNER JOIN sorties s ON s.idsortie=r.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance";

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Restaurant r = new Restaurant();
			r.idrestaurant = rs.getInt("idrestaurant");
			r.nomrestaurant = rs.getString("nomrestaurant");
			r.nomquartier = rs.getString("nomquartier");
			r.libambiance = rs.getString("libambiance");
			r.prixmin = rs.getInt("prixmin");
			r.prixmax = rs.getInt("prixmax");
			listeDesRestaurants.add(r);
		}

		return listeDesRestaurants;

	}

}
