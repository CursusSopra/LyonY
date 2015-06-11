package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.cursusSopra.tech.PostgresConnection;

public class Adresse {
	// Clé primaire de l'adresse
	private int idAdresse;
	
	// Numéro de voie
	private int numero;
	
	// Libellé de la voie
	private String voie;
	
	// Code Postal
	private int codePostal;
	
	// Nom de la ville
	private String ville;
	
	// Identitfiant du quartier
	private Quartier quartier;

	// Constructeur vide
	@SuppressWarnings("unused")
	private Adresse(){};
	
	// Constructeur à partir du nom
	public Adresse(int numero, String voie, int codePostal, String ville, int idQuartier) throws SQLException {
		this.numero = numero;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.quartier = new Quartier(idQuartier);
	}

	// Constructeur d'une adresse correspondant à partir d'un identifiant
	public Adresse(int idAdresse) throws SQLException{
		this.idAdresse = idAdresse;
		// Connexion à la base de données postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requete à executer
		String query = "SELECT numero, voie, codepostal, ville "
				+ "FROM adresses "
				+ "WHERE idadresse = " + idAdresse + " ; ";
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			numero = rs.getInt("numero");
			voie = rs.getString("voie");
			codePostal = rs.getInt("codepostal");
			ville = rs.getString("ville");		
		} else {
			throw new SQLException();
		}
	}

	// Rentre une adresse dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int create(Connection cnx) throws SQLException {
		String query = " INSERT INTO adresses(nom, voie, codepostal, ville) VALUES (?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, numero);
		ps.setString(2, voie);
		ps.setInt(3, codePostal);
		ps.setString(4, ville);
		return ps.executeUpdate();
	}

	// Modifie une adresse dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int update(Connection cnx, int numero, String voie, int codePostal, String ville) throws SQLException {
		String query = " UPDATE adresses  SET numero=?, voie=?, codepostal=?, ville=? "
				+ " WHERE idadresse=" + idAdresse;
		System.out.println(query);
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, numero);
		ps.setString(2, voie);
		ps.setInt(3, codePostal);
		ps.setString(4, ville);
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

	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getnumero() {
		return numero;
	}
	public void setnumero(int numero) {
		this.numero = numero;
	}
	public String getvoie() {
		return voie;
	}
	public void setvoie(String voie) {
		this.voie = voie;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	
}
