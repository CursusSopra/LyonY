package fr.cursusSopra.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Nclub extends Sortie {

	private int idNightclub;
	private String nomnightclub;
	private String nomquartier;
	private int prixmin;
	private int prixmax;
	private String libambiance;
	private int numero;
	private String voie;
	private String ville;
	private String description;

	public Nclub() {
	}
	
	public Nclub(int id) throws SQLException {
		idNightclub = id;
		
		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		
		// Requête à exécuter
		String query = "SELECT n.idsortie, n.idnightclub, l.nom nomnightclub,q.nom nomquartier, libambiance, prixmin, prixmax, numero, voie, ville, description "
				+ "FROM nightclubs n "
				+ "INNER JOIN sorties s ON s.idsortie=n.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "WHERE n.idnightclub =" + idNightclub;
		
		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			idNightclub = rs.getInt("idnightclub");
			idSortie = rs.getInt("idsortie");
			nomnightclub = rs.getString("nomnightclub");
			nomquartier = rs.getString("nomquartier");
			libambiance = rs.getString("libambiance");
			prixmin = rs.getInt("prixmin");
			prixmax = rs.getInt("prixmax");
			numero = rs.getInt("numero");
			voie = rs.getString("voie");
			ville = rs.getString("ville");
			description = rs.getString("description");
		}
		// Construction de la liste des horaires - Méthode de la classe mère
		getListeDesHoraires();
	}

	// Getters and Setters

	public String getNomnightclub() {
		return nomnightclub;
	}
	public String getNomquartier() {
		return nomquartier;
	}
	public int getPrixmin() {
		return prixmin;
	}
	public int getPrixmax() {
		return prixmax;
	}
	public int getIdNightclub() {
		return idNightclub;
	}
	public void setIdNightclub(int idNightclub) {
		this.idNightclub = idNightclub;
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
	public static List<Nclub> listeDesNightclubs;

	public static List<Nclub> getListeDesNightclubs() throws SQLException {

		listeDesNightclubs = new ArrayList<Nclub>();

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query = "SELECT n.idnightclub, l.nom nomnightclub,q.nom nomquartier, libambiance, prixmin, prixmax "
				+ "FROM nightclubs n  "
				+ "INNER JOIN sorties s ON s.idsortie=n.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance";

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Nclub n = new Nclub();
			n.idNightclub = rs.getInt("idnightclub");
			n.nomnightclub = rs.getString("nomnightclub");
			n.nomquartier = rs.getString("nomquartier");
			n.libambiance = rs.getString("libambiance");
			n.prixmin = rs.getInt("prixmin");
			n.prixmax = rs.getInt("prixmax");
			listeDesNightclubs.add(n);
		}
		return listeDesNightclubs;
	}
}
