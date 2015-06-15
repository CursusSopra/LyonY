package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.Nullable;

import fr.cursusSopra.tech.PostgresConnection;

public class Placeetparc {

	//Variables
	private int idPlaceetparc;
	private String nomLieu;
	private String descriptionLieu;
	private String accessibiliteLieu;
	private int numAdres;
	private String voieAdres; 
	private String cpAdres;
	private String villeAdres;
	private String nomQuartier;
	private String typeVisite;
	private float notemoy;
	private int nbavis;
	
	// GETS SETS
	public int getIdPlaceetparc() {
		return idPlaceetparc;
	}
	
	public void setIdPlaceetparc(int idPlaceetparc) {
		this.idPlaceetparc = idPlaceetparc;
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
	public float getNotemoy() {
		return notemoy;
	}
	public int getNbavis() {
		return nbavis;
	}


	//CTORS
	public Placeetparc () {
		
	}

	// METHODES STATIQUES
	  
    public Placeetparc(int idp) throws SQLException {
        idPlaceetparc = idp;
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
                            + "p.idPlaceetparc "
                        + "FROM placeetparcs p "
                            + "INNER JOIN visites v USING (idvisite) "
                            + "INNER JOIN lieux l USING (idlieu) "
                            + "INNER JOIN adresses a USING (idadresse) "
                            + "INNER JOIN quartiers q USING (idquartier) "
                            + "INNER JOIN typevisites t ON v.idtypevisite = t.idtypevisite "
                        + "WHERE p.idPlaceetparc=" + idPlaceetparc ;
        // Obtention de l'ensemble résultat
        ResultSet rsM = stmt.executeQuery(queryNomCompl);
        // Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
        if(rsM.next()){
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
							+ "l.nom AS nomL, "
							+ "t.libtypevisite, "
							+ "q.nom AS nomQ, "
							+ "p.idplaceetparc, "
							+ "AVG(av.note) AS notemoy, "
							+ "COUNT(av.note) AS nbavis "
						+ "FROM placeetparcs p "
							+ "INNER JOIN visites v USING (idvisite) "
							+ "INNER JOIN lieux l USING (idlieu) "
							+ "INNER JOIN adresses a USING (idadresse) "
							+ "INNER JOIN quartiers q USING (idquartier) "
							+ "INNER JOIN typevisites t ON v.idtypevisite = t.idtypevisite "
							+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
						+ "GROUP BY l.nom, t.libtypevisite, q.nom, p.idplaceetparc "
						+ "ORDER BY l.nom;"	;
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
		while(rs.next()){
			Placeetparc p = new Placeetparc();
			p.idPlaceetparc = rs.getInt("idplaceetparc");
			p.nomLieu = rs.getString("nomL");
			p.nomQuartier = rs.getString("nomQ");
			p.typeVisite = rs.getString("libtypevisite");
			p.notemoy = rs.getFloat("notemoy");
			p.nbavis = rs.getInt("nbavis");
			

			listeDesPlaceetparcs.add(p);
		}
		
		return listeDesPlaceetparcs;
	}
}
