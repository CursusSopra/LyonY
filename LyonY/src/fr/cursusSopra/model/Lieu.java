package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.cursusSopra.tech.PostgresConnection;

public class Lieu {
	// Clé de la table Lieu
	private int idLieu;

	// Nom du lieu
	private String nom;

	// Description du lieu
	private String description;

	// Accessibilité du lieu
	private String accessibilite;

	// Adresse du lieu
	private Adresse adresse;

	// Constructeur vide non accessible
	@SuppressWarnings("unused")
	private Lieu() {};

	// Constructeur à partir du nom
	public Lieu(String nom, int idAdresse, String description,
			String accessibilite) throws SQLException {
		this.nom = nom;
		this.adresse = new Adresse(idAdresse);
		this.setDescription(description);
		this.setAccessibilite(accessibilite);
	}

	// Constructeur d'un lieu correspondant à partir d'un identifiant
	public Lieu(int idLieu) throws SQLException{
		this.idLieu = idLieu;
		// Connexion à la base de données postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requete à executer
		String query = "SELECT nom, idadresse, description, accessibilite "
				+ "FROM lieux "
				+ "WHERE idlieu = " + idLieu + " ; ";
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			nom = rs.getString("nom");
			adresse = new Adresse(rs.getInt("idadresse"));
			description = rs.getString("description");
			accessibilite = rs.getString("accessibilite");		
		} else {
			throw new SQLException();
		}
	}

	// Rentre un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int create(Connection cnx) throws SQLException {
		String query = " INSERT INTO lieux(nom,idAdresse,description,accessibilite) VALUES (?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, nom);
		ps.setInt(2, adresse.getIdAdresse());
		ps.setString(3, description);
		ps.setString(4, accessibilite);
		System.out.println(ps);
		return ps.executeUpdate();
	}

	// Modifie un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int update(Connection cnx, String nom, int idAdresse,
			String description, String accessibilite) throws SQLException {
		String query = " UPDATE lieux  SET nom=?, idadresse=?, description=?, accessibilite=? "
				+ " WHERE idlieu=" + idLieu;
		System.out.println(query);
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, nom);
		ps.setInt(2, adresse.getIdAdresse());
		ps.setString(3, description);
		ps.setString(4, accessibilite);
		return ps.executeUpdate();
	}

	// Supprime un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int delete(Connection cnx) throws SQLException {
		String query = "DELETE FROM lieux" + " WHERE idlieu= " + idLieu;
		PreparedStatement ps = cnx.prepareStatement(query);
		return ps.executeUpdate();
	}

	// Renvoie le contenu d'un lieu (pour vérif')
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Le Lieu s'appelle" + nom);
		sb.append("Il se trouve au" + adresse.toString());
		sb.append("Il a une description"
				+ ((description == "") ? "VRAI" : "FAUX"));
		sb.append("Son accessibilité est décrite"
				+ ((accessibilite == "") ? "VRAI" : "FAUX"));
		return sb.toString();
	}

	// Setters And Getters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAccessibilite() {
		return accessibilite;
	}
	public void setAccessibilite(String accessibilite) {
		this.accessibilite = accessibilite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
