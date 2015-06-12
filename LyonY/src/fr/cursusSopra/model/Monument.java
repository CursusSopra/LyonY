package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Monument {

	//Variables
	private int annCons;
	private int annFinCons;
	private String nomLieu;
	private String descriptionLieu;
	private String accessibiliteLieu;
	private int numAdres;
	private String voieAdres;
	private String cpAdres;
	private String villeAdres;
	private String nomQuartier;
	
	private static List<Monument> listeDesMonuments;
	
	
	
	//Getters
	public int getAnnCons() {
		return annCons;
	}

	public int getAnnFinCons() {
		return annFinCons;
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

	public int getNumAdres() {
		return numAdres;
	}

	public String getVoieAdres() {
		return voieAdres;
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
	
	public static List<Monument> getListeDesMonuments() {
		return listeDesMonuments;
	}


	
	public static List<Monument> getListMonuments() throws SQLException{
		listeDesMonuments =new ArrayList<Monument>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query  = "SELECT idcandidat, nom, prenom, villenaissance, datenaissance, villedeces, datedeces, "
						+"	CASE "
						+"      WHEN datedeces IS NOT NULL "
						+"          THEN EXTRACT (YEAR FROM datedeces) - EXTRACT (YEAR FROM datenaissance) "
						+"      ELSE EXTRACT (YEAR FROM CURRENT_TIMESTAMP) - EXTRACT (YEAR FROM datenaissance) "
						+"  END AS agedescandidats "
						+"FROM candidats "
						+"ORDER BY nom";
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
		while(rs.next()){
			Monument m = new Monument();
			m.annCons = rs.getInt("anneeconstruction");
			m.annFinCons = rs.getInt("anneefinconstruction");
			m.nomLieu = rs.getString("nom");
			m.descriptionLieu = rs.getString("description");
			m.accessibiliteLieu = rs.getString("accessibilite");
			m.numAdres = rs.getInt("numero");;
			m.voieAdres = rs.getString("voie");
			m.cpAdres = rs.getString("codepostale");
			m.villeAdres = rs.getString("ville");
			m.nomQuartier = rs.getString("");
			

			listeDesMonuments.add(m);
		}
		
		return listeDesMonuments;
	}





}
