package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Placeetparc {

	//Variables
	private int idPlaceetparc;
	private String nomLieu;
	private String descriptionLieu;
	private String accessibiliteLieu;
	private String cpAdres;
	private String villeAdres;
	private String nomQuartier;
	private String typeVisite;
	
	// GETS SETS
	public int getIdPlaceetparc() {
		return idPlaceetparc;
	}
	public String getNomLieu() {
		return nomLieu;
	}
	public String getDescriptionLieu() {
		return descriptionLieu;
	}
	public String getAccessibiliteLieu() {
		return accessibiliteLieu;
	}
	public String getCpAdres() {
		return cpAdres;
	}
	public String getVilleAdres() {
		return villeAdres;
	}
	public String getNomQuartier() {
		return nomQuartier;
	}
	public String getTypeVisite() {
		return typeVisite;
	}


	//CTORS
	
	
	// METHODES STATIQUES
	private static List<Placeetparc> listeDesPlaceetparcs;
	
	public static List<Placeetparc> getListeDesPlaceetparcs() throws SQLException{
		listeDesPlaceetparcs =new ArrayList<Placeetparc>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query  = "SELECT "
							+ "l.nom AS nomL, l.description, l.accessibilite, "
							+ "a.codepostal, a.ville, "
							+ "q.nom AS nomQ, "
							+ "t.libtypevisite, "
							+ "p.idplaceetparc "
						+ "FROM placeetparcs p "
							+ "INNER JOIN visites v USING (idvisite) "
							+ "INNER JOIN lieux l USING (idlieu) "
							+ "INNER JOIN adresses a USING (idadresse) "
							+ "INNER JOIN quartiers q USING (idquartier) "
							+ "INNER JOIN typevisites t ON v.idtypevisite = t.idtypevisite "
						+ "ORDER BY l.nom;"	;
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
		while(rs.next()){
			Placeetparc p = new Placeetparc();
			p.idPlaceetparc = rs.getInt("idplaceetparc");
			p.nomLieu = rs.getString("nomL");
			p.descriptionLieu = rs.getString("description");
			p.accessibiliteLieu = rs.getString("accessibilite");
			p.cpAdres = rs.getString("codepostal");
			p.villeAdres = rs.getString("ville");
			p.nomQuartier = rs.getString("nomQ");
			p.typeVisite = rs.getString("libtypevisite");
			

			listeDesPlaceetparcs.add(p);
		}
		
		return listeDesPlaceetparcs;
	}
}
