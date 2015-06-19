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


	

	public Photo(int idphoto) throws SQLException {

		idPhoto = idphoto;

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();

		// Requête à exécuter
		String query = "SELECT idlieu, libphoto "
				+ "FROM photos p "
				+ "INNER JOIN lieux USING (idlieu) "
				+ "WHERE idphoto = " + idPhoto;
				
		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
	
		if (rs.next()) {
			idLieu = rs.getInt("idlieu");
			libPhoto = rs.getString("libphoto");

		}
	}
}
