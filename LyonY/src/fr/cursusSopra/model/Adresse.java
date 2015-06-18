package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.cursusSopra.tech.PostgresConnection;

public class Adresse {
	
	private int idAdresse;
	private int numero;
	private String voie;
	private String codePostal;
	private String ville;
	private int idQuartier;

	// Constructeur vide
	public Adresse(){
		
	}
	
	// Constructeur à partir du nom
	public Adresse(int numero, String voie, String codePostal, String ville, int idQuartier) throws SQLException {
		this.numero = numero;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idQuartier = idQuartier;
	}

	// Constructeur d'une adresse correspondant à partir d'un identifiant
	public Adresse(int idAdresse) throws SQLException{
		this.idAdresse = idAdresse;
		// Connexion à la base de données postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requete à executer
		String query = "SELECT numero, voie, codepostal, ville, idquartier "
				+ "FROM adresses "
				+ "WHERE idadresse = " + idAdresse + " ; ";
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			numero = rs.getInt("numero");
			voie = rs.getString("voie");
			codePostal = rs.getString("codepostal");
			ville = rs.getString("ville");		
			idQuartier = rs.getInt("idquartier");	
		} else {
			throw new SQLException();
		}
	}

	// Rentre une adresse dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int save(Connection cnx) throws Exception {
		String query = " INSERT INTO adresses(numero, voie, codepostal, ville, idquartier) VALUES (?,?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, numero);
		ps.setString(2, voie);
		ps.setString(3, codePostal);
		ps.setString(4, ville);
		ps.setInt(5, idQuartier);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idAdresse = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idAdresse;
	}

	// Modifie une adresse dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int update(Connection cnx, int numero, String voie, String codePostal, String ville, int idQuartier) throws SQLException {
		String query = " UPDATE adresses  SET numero=?, voie=?, codepostal=?, ville=?, idquartier=? "
				+ " WHERE idadresse=" + idAdresse;
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, numero);
		ps.setString(2, voie);
		ps.setString(3, codePostal);
		ps.setString(4, ville);
		ps.setInt(5, idQuartier);
		return ps.executeUpdate();
	}

	// Supprime une adresse dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int delete(Connection cnx) throws SQLException {
		String query = "DELETE FROM adresses" + " WHERE idadresse= " + idAdresse;
		PreparedStatement ps = cnx.prepareStatement(query);
		return ps.executeUpdate();
	}

	// Renvoie le contenu d'un lieu (pour vérif')
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(numero + ",");
		sb.append(voie + "/n");
		sb.append(codePostal + ville);
		return sb.toString();
	}
	
	// GETSETS
	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getIdQuartier() {
		return idQuartier;
	}
	public void setIdQuartier(int idQuartier) {
		this.idQuartier = idQuartier;
	}

//	public Quartier getQuartier() {
//		return quartier;
//	}
//
//	public void setQuartier(Quartier quartier) {
//		this.quartier = quartier;
//	}
	
}
