package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Photo {
	private int idPhoto;
	private String libPhoto;
	private int idLieu;
	private List<Photo> listeDesPhotos = new ArrayList<Photo>();

	// Getters and setters
	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getLibPhoto() {
		return libPhoto;
	}

	public void setLibPhoto(String libPhoto) {
		this.libPhoto = libPhoto;
	}

	public int getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}

	public List<Photo> getListeDesPhotos() {
		return listeDesPhotos;
	}

	public void setListeDesPhotos(List<Photo> listeDesPhotos) {
		this.listeDesPhotos = listeDesPhotos;
	}

	public Photo(int idlieu) throws SQLException {

		idLieu = idlieu;

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();

		// Requête à exécuter
		String query = "SELECT s.idsortie, l.idlieu, b.idbar, l.nom nombar,q.nom nomquartier, libambiance, "
				+ "prixmin, prixmax, numero, voie, codepostal, ville, description, l.accessibilite, happyhour, "
				+ "AVG(av.note) AS notemoy,COUNT(av.note) AS nbavis "
				+ "FROM bars b "
				+ "INNER JOIN sorties s ON s.idsortie=b.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "WHERE b.idbar = "
				+ idLieu
				+ " GROUP BY s.idsortie, l.idlieu, b.idbar, l.nom ,q.nom , libambiance, prixmin, prixmax, numero, voie, codepostal, ville, "
				+ "description, l.accessibilite";

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		int idl = 0;
		if (rs.next()) {
			idLieu = rs.getInt("idlieu");
			idPhoto = rs.getInt("idphoto");
			libPhoto = rs.getString("libphoto");

		}
	}
}
