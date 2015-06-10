package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Lieu {
	
	// Nom du lieu
	private String nom;
	
	// Coordonnées GPS du lieu
	private long longitude;
	private long latitude;
	
	// Adresse du lieu
	private Adresse adresse;
	
	// Liste des avis au sujet du lieu
	private List<Avis> listeDesAvis;
	
	// Chemin des photos du lieu
	private List<String> listeDesPhotos;

	// URL des liens du lieu
	private List<String> listeDesLiens;

	// Constructeur vide non accessible
	@SuppressWarnings("unused")
	private Lieu(){};
	
	// Constructeur à partur du nom
	public Lieu(String nom, Adresse adresse){
		this.nom = nom;
		this.adresse = adresse;
		longitude = adresse.longitude();
		latitude = adresse.longitude();
	}
	
	// Renvoie le contenu d'une adresse
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Le Lieu s'appelle" + nom);
		return sb.toString();
	}
	
	// Rentre un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes métiers)
	public int create(Connection cnx) throws SQLException {
		String query = " INSERT INTO lieu(nom) VALUES (?)";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, nom);
		System.out.println(ps);
		return ps.executeUpdate();
	}
	
	// Modifie un lieu dans la base de donnée
	
	
	
	
	//Setters And Getters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
	public List<String> getListeDesLiens() {
		return listeDesLiens;
	}
	public void setListeDesLiens(List<String> listeDesLiens) {
		this.listeDesLiens = listeDesLiens;
	}
	
	
	
}
