package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
	private int idAdresse;
	
	// Liste des avis au sujet du lieu
	private List<Avis> listeDesAvis;
	
	// Chemin des photos du lieu
	private List<String> listeDesPhotos;

	// List des id des liens du lieu
	private int[] listeDesLiens;

	// Constructeur vide non accessible
	@SuppressWarnings("unused")
	private Lieu(){};
	
	// Constructeur à partur du nom
	public Lieu(String nom, int idAdresse, String description, String accessibilite){
		this.nom = nom;
		this.idAdresse = idAdresse;
		this.setDescription(description);
		this.setAccessibilite(accessibilite);
	}
	
	// Renvoie le contenu d'une adresse
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Le Lieu s'appelle" + nom);
		sb.append("L'id de son adresse" + idAdresse);
		sb.append("Il a une description" + ((description =="") ? "VRAI" : "FAUX"));
		sb.append("Son accessibilité est décrite" + ((accessibilite =="") ? "VRAI" : "FAUX"));
		sb.append("Il possède" + listeDesAvis.size() + "avis");
		sb.append("Il possède" + listeDesPhotos.size() + "photos");
		sb.append("Il possède" + listeDesLiens.length + "liens");
		return sb.toString();
	}
	
	// Rentre un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes métiers)
	public int create(Connection cnx) throws SQLException {
		String query = " INSERT INTO lieu(nom,adresse,description,accessibilite) VALUES (?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, nom);
		ps.setInt(2, idAdresse);
		ps.setString(3, description);
		ps.setString(4, accessibilite);
		System.out.println(ps);
		return ps.executeUpdate();
	}
	
	// Modifie un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes métiers)
	public int update(Connection cnx, String nom, int idAdresse, String description, String accessibilite) throws SQLException {
		String query = " UPDATE lieu  SET nom=?, adresse=?, description=?, accessibilite=? "
				+ " WHERE idlieu=" + idLieu;
		System.out.println(query);
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, nom);
		ps.setInt(2, idAdresse);
		ps.setString(3, description);
		ps.setString(4, accessibilite);
		return ps.executeUpdate();
	}
	
	//Supprime un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes métiers)
	public int delete(Connection cnx) throws SQLException {
		String query = "DELETE FROM lieu" + " WHERE idlieu= "
				+ idLieu;
		PreparedStatement ps = cnx.prepareStatement(query);
		return ps.executeUpdate();
	}
	
	//Setters And Getters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAdresse() {
		return idAdresse;
	}
	public void setAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public List<Avis> getListeDesAvis() {
		return listeDesAvis;
	}
	public void setListeDesAvis(List<Avis> listeDesAvis) {
		this.listeDesAvis = listeDesAvis;
	}
	public List<String> getListeDesPhotos() {
		return listeDesPhotos;
	}
	public void setListeDesPhotos(List<String> listeDesPhotos) {
		this.listeDesPhotos = listeDesPhotos;
	}
	public int[] getListeDesLiens() {
		return listeDesLiens;
	}
	public void setListeDesLiens(int[] listeDesLiens) {
		this.listeDesLiens = listeDesLiens;
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
		
}
