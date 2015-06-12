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
	private int idMonument;
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
	private String typeVisite;
	
	//Getters
	public int getIdMonument() {
		return idMonument;
	}
	public void setIdMonument(int idMonument) {
		this.idMonument = idMonument;
	}
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
	public String getTypeVisite() {
		return typeVisite;
	}

	//CTORS
    public Monument(){
    };
   
    public Monument(int idm) throws SQLException {
        idMonument = idm;
        // connexion à la BDD PostGresSQL
        Connection cnx = null;
        cnx = PostgresConnection.getConnexion();
        // Objet instruction SQL
        Statement stmt = cnx.createStatement();
        // Requête à exécuter
            String queryNomCompl  = "SELECT "
                            + "l.nom AS nomL, l.description, l.accessibilite, "
                            + "a.numero, a.voie, a.codepostal, a.ville, "
                            + "q.nom AS nomQ, "
                            + "t.libtypevisite, "
                            + "m.anneeconstruction, m.anneefinconstruction, m.idmonument "
                        + "FROM monuments m "
                            + "INNER JOIN visites v USING (idvisite) "
                            + "INNER JOIN lieux l USING (idlieu) "
                            + "INNER JOIN adresses a USING (idadresse) "
                            + "INNER JOIN quartiers q USING (idquartier) "
                            + "INNER JOIN typevisites t ON v.idtypevisite = t.idtypevisite "
                        + "WHERE m.idmonument=" + idm    ;
        // Obtention de l'ensemble résultat
        ResultSet rsM = stmt.executeQuery(queryNomCompl);
        // Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
        if(rsM.next()){
            annCons = rsM.getInt("anneeconstruction");
            annFinCons = rsM.getInt("anneefinconstruction");
            nomLieu = rsM.getString("nomL");
            descriptionLieu = rsM.getString("description");
            accessibiliteLieu = rsM.getString("accessibilite");
            numAdres = rsM.getInt("numero");
            voieAdres = rsM.getString("voie");
            cpAdres = rsM.getString("codepostal");
            villeAdres = rsM.getString("ville");
            nomQuartier = rsM.getString("nomQ");
            typeVisite = rsM.getString("libtypevisite");
        }
    }
	
	// METHODES STATIQUES
	private static List<Monument> listeDesMonuments;
	
	public static List<Monument> getListeDesMonuments() throws SQLException{
		listeDesMonuments =new ArrayList<Monument>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query  = "SELECT "
							+ "l.nom AS nomL, l.description, l.accessibilite, "
							+ "a.numero, a.voie, a.codepostal, a.ville, "
							+ "q.nom AS nomQ, "
							+ "t.libtypevisite, "
							+ "m.anneeconstruction, m.anneefinconstruction, m.idmonument "
						+ "FROM monuments m "
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
			Monument m = new Monument();
			m.idMonument = rs.getInt("idmonument");
			m.annCons = rs.getInt("anneeconstruction");
			m.annFinCons = rs.getInt("anneefinconstruction");
			m.nomLieu = rs.getString("nomL");
			m.descriptionLieu = rs.getString("description");
			m.accessibiliteLieu = rs.getString("accessibilite");
			m.numAdres = rs.getInt("numero");
			m.voieAdres = rs.getString("voie");
			m.cpAdres = rs.getString("codepostal");
			m.villeAdres = rs.getString("ville");
			m.nomQuartier = rs.getString("nomQ");
			m.typeVisite = rs.getString("libtypevisite");
			

			listeDesMonuments.add(m);
		}
		
		return listeDesMonuments;
	}

}
