package fr.cursusSopra.model;

import java.sql.*;
import java.util.ArrayList;
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
	
	private String libambiance;
	



	public Bar() {
		
	}
	

	// Getters and Setters

	public String getNombar() {
		return nombar;
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

	public String getLibambiance() {
		return libambiance;
	}

	public void setLibambiance(String libambiance) {
		this.libambiance = libambiance;
	}

//	public Bar(int id) throws SQLException {
//		idbar = id;
//
//		// Connexion à la BDD postgreSQL
//		Connection cnx = PostgresConnection.getConnexion();
//		// Object instruction SQL
//		Statement stmt = cnx.createStatement();
//		Statement stmt1 = cnx.createStatement();
//		// Requête à exécuter
//		String query = "SELECT idcandidat, nom, prenom"
//				+ ", datenaissance, villenaissance"
//				+ "FROM candidats " 
//				+ "WHERE idcandidat=" +idbar;
//
//		// Obtention de l'ensemble résultats
//		ResultSet rs = stmt.executeQuery(query);
//		if (rs.next()) {		
//			idbar = rs.getInt("idbar");
//			nom = rs.getString("nom");
//			prenom = rs.getString("prenom");
//			dateNaissance = rs.getDate("datenaissance");
//			villeNaissance = rs.getString("villenaissance");
//			dateDeces = rs.getDate("datedeces");
//			villeDeces = rs.getString("villedeces");
//			age = rs.getInt("age");
//	
//			}
//		
//		}
	


	
	
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
		String query = "SELECT b.idbar, l.nom nombar,q.nom nomquartier, libambiance, prixmin, prixmax "
				+ "FROM bars b  " 
				+ "INNER JOIN sorties s ON s.idsortie=b.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance";
		

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Bar b = new Bar();
			b.idbar = rs.getInt("idbar");
			b.nombar = rs.getString("nombar");
			b.nomquartier = rs.getString("nomquartier");
			b.libambiance = rs.getString("libambiance");
			b.prixmin = rs.getInt("prixmin");
			b.prixmax = rs.getInt("prixmax");
			listeDesBars.add(b);
		}

		return listeDesBars;

	}

}
