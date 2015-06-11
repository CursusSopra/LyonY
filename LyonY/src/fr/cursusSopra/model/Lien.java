package fr.cursusSopra.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Lien {

	private int idlien;
	private String liblien;
	private String url;

	public int getIdlien() {
		return idlien;
	}

	public void setIdlien(int idlien) {
		this.idlien = idlien;
	}

	public String getLiblien() {
		return liblien;
	}

	public void setLiblien(String liblien) {
		this.liblien = liblien;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// constructeur
	public Lien(int id) throws SQLException {

		idlien = id;

		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT liblien, url FROM liens WHERE idlien = "
				+ idlien + " ; ";
		// obtention de l'ensemble resultat
		ResultSet rs = stmt.executeQuery(query);
		// rs demande les valeur pour un ligne, ligne par ligne

		if (rs.next()) {
			liblien = rs.getString("liblien");
			url = rs.getString("url");
		}
	}

	// ********************************************************************************

	public Lien() {
	}

	public int update() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();

		String query = "UPDATE liens SET liblien=?, url=? WHERE idlien=?";
		PreparedStatement ps = cnx.prepareStatement(query);

		ps.setString(1, liblien);
		ps.setString(2, url);

		int ret = ps.executeUpdate();
		return ret;
	}

	public int save() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();

		String query = "INSERT INTO liens (liblien, url) VALUES (?, ?)";
		PreparedStatement ps = cnx.prepareStatement(query);

		ps.setString(1, liblien);
		ps.setString(2, url);

		return ps.executeUpdate();
	}

	public int suppr() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();

		String query = "DELETE FROM liens WHERE idlien=?";
		PreparedStatement ps = cnx.prepareStatement(query);

		ps.setInt(1, idlien);
		int ret = ps.executeUpdate();

		return ret;
	}
	

	// Lien
	// Int idlien;
	// String liblien;
	// String url;

	// propriete /methode statics/
	// Membres statiques$
	private static List<Lien> listeDesLiens;

	public static List<Lien> getlisteDesLiens() throws SQLException {

		listeDesLiens = new ArrayList<Lien>();

		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT idlien, liblien, url FROM liens ";

		// obtention de l'ensemble resultat
		ResultSet rs = stmt.executeQuery(query);// rs demande les valeur pour un
												// ligne, ligne par ligne
		while (rs.next()) {
			Lien l = new Lien();
			l.idlien = rs.getInt("idlien");
			l.liblien = rs.getString("liblien");
			l.url = rs.getString("url");

			listeDesLiens.add(l);
		}
		return listeDesLiens;
	}
}
