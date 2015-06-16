package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Quartier {

	private int idquartier;
	private String nom;
	private int budgetMoyen;
	private int distanceCentreVille;

	public int getIdquartier() {
		return idquartier;
	}	
	public void setIdquartier(int idquartier) {
		this.idquartier = idquartier;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getBudgetMoyen() {
		return budgetMoyen;
	}
	public void setBudgetMoyen(int budgetMoyen) {
		this.budgetMoyen = budgetMoyen;
	}
	public int getDistanceCentreVille() {
		return distanceCentreVille;
	}
	public void setDistanceCentreVille(int distanceCentreVille) {
		this.distanceCentreVille = distanceCentreVille;
	}
	
	// ********************************************************************************

	// constructeur
	public Quartier(int id) throws SQLException {

		idquartier = id;

		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT nom, budgetMoyen, distanceCentreVille"
				+ "FROM quartiers WHERE idquartier = " + idquartier + " ; ";
		// obtention de l'ensemble resultat

		ResultSet rs = stmt.executeQuery(query);// rs demande les valeur pour un
												// ligne, ligne par ligne

		if (rs.next()) {
			nom = rs.getString("nom");
			budgetMoyen = rs.getInt("budgetMoyen");
			distanceCentreVille = rs.getInt("distanceCentreVille");

		}
	}

	// contructeur vide
	public Quartier() {
	}

	public int update() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();
		String query = "UPDATE quartiers SET nom=?, budgetMoyen=?, distanceCentreVille=? WHERE idquartier=?";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, nom);
		ps.setInt(2, budgetMoyen);
		ps.setInt(3, distanceCentreVille);
		ps.setInt(4, idquartier);
		int ret = ps.executeUpdate();
		return ret;
	}

	public int create() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();
		String query = "INSERT INTO quartiers (nom, budgetMoyen, distanceCentreVille) VALUES (?, ?, ?)";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, nom);
		ps.setInt(2, budgetMoyen);
		ps.setInt(3, distanceCentreVille);
		return ps.executeUpdate();
	}

	public int suppr() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();
		String query = "DELETE FROM quartiers WHERE idquartier=?";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, idquartier);
		int ret = ps.executeUpdate();
		return ret;
	}

	// propriete /methode statics/
	// Membres statiques$
	private static List<Quartier> listeDesQuartiers;

	public static List<Quartier> getListeDesQuartiers() throws SQLException {

		listeDesQuartiers = new ArrayList<Quartier>();

		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT idquartier, nom, budgetMoyen, distanceCentreVille "
				+ "	FROM quartiers ORDER BY nom";

		// obtention de l'ensemble resultat
		ResultSet rs = stmt.executeQuery(query);// rs demande les valeur pour un
												// ligne, ligne par ligne
		while (rs.next()) {
			Quartier q = new Quartier();
			q.idquartier = rs.getInt("idquartier");
			q.nom = rs.getString("nom");
			q.budgetMoyen = rs.getInt("budgetMoyen");
			q.distanceCentreVille = rs.getInt("distanceCentreVille");

			listeDesQuartiers.add(q);
		}
		return listeDesQuartiers;
	}

	
	private  List<Adresse> listeDesAdressesDunQuartier;
	
	public  List<Adresse> getListeDesAdressesDunQuartier()
			throws SQLException {		

		listeDesAdressesDunQuartier = new ArrayList<Adresse>();

		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT idadresse, numero, voie, codepostal, ville "
				+ "FROM adresses, quartiers "
				+ "WHERE quartiers.idquartier = adresses.idquartier "
				+ "AND nom = '" + nom + "' ; ";

		// obtention de l'ensemble resultat
		ResultSet rs = stmt.executeQuery(query);// rs demande les valeur pour un
												// ligne, ligne par ligne
		while (rs.next()) {
			Adresse a = new Adresse();
			a.idAdresse = rs.getInt("idadresse");
			a.numero = rs.getInt("numero");
			a.voie = rs.getString("voie");
			a.codePostal = rs.getInt("codepostal");
			a.ville = rs.getString("ville");

			listeDesAdressesDunQuartier.add(a);
		}
		return listeDesAdressesDunQuartier;
	}
}
