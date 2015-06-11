package fr.cursusSopra.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Bar {

	private int idbar;

	private int idsortie;
	
	private String happyhour;
	
	private String nombar;
	
	private String nomquartier;
	
	private int prixmin;
	
	private int prixmax;
	


	// Getters and Setters

	public Bar() {
		
	}

	public int getIdbar() {
		return idbar;
	}

	public void setIdbar(int idbar) {
		this.idbar = idbar;
	}

	public int getIdsortie() {
		return idsortie;
	}

	public void setIdsortie(int idsortie) {
		this.idsortie = idsortie;
	}

	public String getHappyhour() {
		return happyhour;
	}

	public void setHappyhour(String happyhour) {
		this.happyhour = happyhour;
	}

	public Bar(int id) throws SQLException {
		idbar = id;

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		Statement stmt1 = cnx.createStatement();
		// Requête à exécuter
		String query = "SELECT idcandidat, nom, prenom"
				+ ", datenaissance, villenaissance"
				+ "FROM candidats " 
				+ "WHERE idcandidat=" +idbar;

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {		
			idbar = rs.getInt("idbar");
			nom = rs.getString("nom");
			prenom = rs.getString("prenom");
			dateNaissance = rs.getDate("datenaissance");
			villeNaissance = rs.getString("villenaissance");
			dateDeces = rs.getDate("datedeces");
			villeDeces = rs.getString("villedeces");
			age = rs.getInt("age");
	
			}
		
		}
	


	}
	
//	public int save() throws SQLException {
//		Connection cnx = PostgresConnection.getConnexion();
//		String query = "INSERT INTO candidats(nom, prenom, datenaissance, villenaissance) "
//				+ "VALUES (?, ?, ?, ?)";
//		PreparedStatement ps = cnx.prepareStatement(query);
//		ps.setString(1, nom);
//		ps.setString(2, prenom);
//		ps.setDate(3, new java.sql.Date(dateNaissance.getTime()));
//		ps.setString(4, villeNaissance);
//		
//		int ret = ps.executeUpdate();
//		
//		return ret;
//		
//	}
//	
//	public int edit() throws SQLException {
//		Connection cnx = PostgresConnection.getConnexion();
//		String query = "UPDATE candidats SET nom=?, prenom=?, datenaissance=?, villenaissance=? "
//				+ "WHERE idCandidat=?";
//		PreparedStatement ps = cnx.prepareStatement(query);
//		ps.setString(1, nom);
//		ps.setString(2, prenom);
//		ps.setDate(3, new java.sql.Date(dateNaissance.getTime()));
//		ps.setString(4, villeNaissance);
//		ps.setInt(5, idCandidat);
//		
//		
//		int ret = ps.executeUpdate();
//		
//		return ret;
//		
//	}	
//	
//	public int delete() throws SQLException {
//		Connection cnx = PostgresConnection.getConnexion();
//		String query = "DELETE FROM candidats "
//				+ "WHERE idCandidat=?";
//		PreparedStatement ps = cnx.prepareStatement(query);
//		ps.setInt(1, idCandidat);
//		
//		int ret = ps.executeUpdate();
//		
//		return ret;
//		
//	}

	/* Membres statiques */
	public static List<Bar> listeDesBars;

	public static List<Bar> getListeDesBars() throws SQLException {

		listeDesBars = new ArrayList<Bar>();

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query = "SELECT idcandidat, nom, prenom"
				+ ", datenaissance, villenaissance"
				+ ", datedeces, villedeces "
				+ ", CASE WHEN datedeces IS NULL THEN    EXTRACT (YEAR FROM CURRENT_DATE) - EXTRACT (YEAR FROM datenaissance)ELSE EXTRACT (YEAR FROM datedeces) - EXTRACT (YEAR FROM datenaissance) END AS age "
				+ "FROM candidats " + "ORDER BY nom";

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Bar c = new Bar();
			c.idCandidat = rs.getInt("idcandidat");
			c.nom = rs.getString("nom");
			c.prenom = rs.getString("prenom");
			c.dateNaissance = rs.getDate("datenaissance");
			c.villeNaissance = rs.getString("villenaissance");
			c.dateDeces = rs.getDate("datedeces");
			c.villeDeces = rs.getString("villedeces");
			c.age = rs.getInt("age");
			listeDesCandidats.add(c);
		}

		return listeDesCandidats;

	}

}
