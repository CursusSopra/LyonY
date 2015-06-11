package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Quartiers {

	private int idquartiers;
	private String noms;
	private int budgetsMoyens;
	private int distancesCentresVilles;
	
	public int getIdquartiers() {
		return idquartiers;
	}
	public void setIdquartiers(int idquartiers) {
		this.idquartiers = idquartiers;
	}
	public String getNoms() {
		return noms;
	}
	public void setNoms(String noms) {
		this.noms = noms;
	}
	public int getBudgetsMoyens() {
		return budgetsMoyens;
	}
	public void setBudgetsMoyens(int budgetsMoyens) {
		this.budgetsMoyens = budgetsMoyens;
	}
	public int getDistancesCentresVilles() {
		return distancesCentresVilles;
	}

	// constructeur
	public Quartiers(int id)  throws SQLException {

		idquartiers = id;

		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT noms, budgetsMoyens, distancesCentresVilles"
				+ "FROM quartiers " + "WHERE idquartiers = " + idquartiers + " ; ";
		// obtention de l'ensemble resultat

		ResultSet rs = stmt.executeQuery(query);// rs demande les valeur pour un
												// ligne, ligne par ligne

		if (rs.next()) {
			noms = rs.getString("noms");
			budgetsMoyens = rs.getInt("budgetsMoyens");
			distancesCentresVilles = rs.getInt("distancesCentresVilles");

		}
	}

	// ********************************************************************************

	public Quartiers() {
	}

	public int update() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();
		String query = "UPDATE quartiers SET noms=?, budgetsMoyens=?, distancesCentresVilles=? WHERE idquartiers=?";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, noms);
		ps.setInt(2, budgetsMoyens);
		ps.setInt(3, distancesCentresVilles);
		ps.setInt(4, idquartiers);
		int ret = ps.executeUpdate();
		return ret;
	}

	public int save() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();
		String query = "INSERT INTO quartiers(noms, budgetsMoyens, distancesCentresVilles) VALUES (?, ?, ?)";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, noms);
		ps.setInt(2, budgetsMoyens);
		ps.setInt(3, distancesCentresVilles);
		return ps.executeUpdate();
	}

	public int suppr() throws SQLException{
		Connection cnx = PostgresConnection.getConnexion();
		String query = "DELETE FROM quartiers WHERE idquartiers=?";
		PreparedStatement ps = cnx.prepareStatement (query);
		ps.setInt(1, idquartiers);
		int ret = ps.executeUpdate();
		return ret;
	}

	// propriete /methode statics/
	// Membres statiques$
	private static List<Quartiers> listeDesQuartiers;

	public static List<Quartiers> getListeDesQuartiers() throws SQLException {
		
		listeDesQuartiers = new ArrayList<Quartiers>();
		
		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT idquartiers, noms, budgetsMoyens, distancesCentresVilles "
				+ "	FROM quartiers ";

		// obtention de l'ensemble resultat
		ResultSet rs = stmt.executeQuery(query);// rs demande les valeur pour un
												// ligne, ligne par ligne
		while (rs.next()) {
			Quartiers q = new Quartiers();
			q.idquartiers = rs.getInt("idquartiers");
			q.noms = rs.getString("noms");
			q.budgetsMoyens = rs.getInt("budgetsMoyens");
			q.distancesCentresVilles = rs.getInt("distancesCentresVilles");
		
			listeDesQuartiers.add(q);
		}
		return listeDesQuartiers;
	}
}
