package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.model.Typevisite;
import fr.cursusSopra.tech.PostgresConnection;

public class Monument {

	private int idMonument;
	private int annCons;
	private int annFinCons;

	private int idVisite;
	
	private int idTypevisite;
	private String typeVisite;

	private int idLieu;
	private String nomLieu;
	private String descriptionLieu;
	private String accessibiliteLieu;

	private int idAdresse;
	private int numAdres;
	private String voieAdres;
	private String cpAdres;
	private String villeAdres;
	
	private int idQuartier;
	private String nomQuartier;
	
	private float notemoy;
	private int nbavis;
	private List<Avis> listeDesAvisDunLieu;
	
	//GETSETS 

	public int getIdMonument() {
		return idMonument;
	}
	public void setIdMonument(int idMonument) {
		this.idMonument = idMonument;
	}
	public int getAnnCons() {
		return annCons;
	}
	public void setAnnCons(int annCons) {
		this.annCons = annCons;
	}
	public int getAnnFinCons() {
		return annFinCons;
	}
	public void setAnnFinCons(int annFinCons) {
		this.annFinCons = annFinCons;
	}

	public int getIdVisite() {
		return idVisite;
	}
	public void setIdVisite(int idVisite) {
		this.idVisite = idVisite;
	}

	public int getIdTypevisite() {
		return idTypevisite;
	}
	public void setIdTypevisite(int idTypevisite) {
		this.idTypevisite = idTypevisite;
	}
	public String getTypeVisite() {
		return typeVisite;
	}
	public void setTypeVisite(String typeVisite) {
		this.typeVisite = typeVisite;
	}

	public int getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}
	public String getNomLieu() {
		return nomLieu;
	}
	public void setNomLieu(String nomLieu) {
		this.nomLieu = nomLieu;
	}
	public String getDescriptionLieu() {
		return descriptionLieu;
	}
	public void setDescriptionLieu(String descriptionLieu) {
		this.descriptionLieu = descriptionLieu;
	}
	public String getAccessibiliteLieu() {
		return accessibiliteLieu;
	}
	public void setAccessibiliteLieu(String accessibiliteLieu) {
		this.accessibiliteLieu = accessibiliteLieu;
	}

	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public int getNumAdres() {
		return numAdres;
	}
	public void setNumAdres(int numAdres) {
		this.numAdres = numAdres;
	}
	public String getVoieAdres() {
		return voieAdres;
	}
	public void setVoieAdres(String voieAdres) {
		this.voieAdres = voieAdres;
	}
	public String getCpAdres() {
		return cpAdres;
	}
	public void setCpAdres(String cpAdres) {
		this.cpAdres = cpAdres;
	}
	public String getVilleAdres() {
		return villeAdres;
	}
	public void setVilleAdres(String villeAdres) {
		this.villeAdres = villeAdres;
	}
	
	public int getIdQuartier() {
		return idQuartier;
	}
	public void setIdQuartier(int idQuartier) {
		this.idQuartier = idQuartier;
	}
	public String getNomQuartier() {
		return nomQuartier;
	}
	public void setNomQuartier(String nomQuartier) {
		this.nomQuartier = nomQuartier;
	}

	public float getNotemoy() {
		return notemoy;
	}
	public void setNotemoy(float notemoy) {
		this.notemoy = notemoy;
	}
	public int getNbavis() {
		return nbavis;
	}
	public void setNbavis(int nbavis) {
		this.nbavis = nbavis;
	}
	public List<Avis> getListeDesAvisDunLieu() {
		return listeDesAvisDunLieu;
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
            		+ "l.idlieu, l.nom AS nomL, l.description, l.accessibilite, "
            		+ "a.idadresse, a.numero, a.voie, a.codepostal, a.ville, "
            		+ "q.idquartier, q.nom AS nomQ, "
            		+ "t.idtypevisite, t.libtypevisite, "
            		+ "v.idvisite, "
            		+ "m.anneeconstruction, m.anneefinconstruction, m.idmonument, "
            		+ "AVG(av.note) AS notemoy, COUNT(av.note) AS nbavis  "
            	+ "FROM monuments m "
            		+ "INNER JOIN visites v USING (idvisite) "
            		+ "INNER JOIN lieux l USING (idlieu) "
            		+ "INNER JOIN adresses a USING (idadresse) "
            		+ "INNER JOIN quartiers q USING (idquartier) "
            		+ "INNER JOIN typevisites t ON v.idtypevisite = t.idtypevisite "
            		+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
        		+ "WHERE m.idmonument= "  + idMonument 
        		+ "GROUP BY l.idlieu, nomL, l.description, l.accessibilite, "
            		+ "a.idadresse, a.numero, a.voie, a.codepostal, a.ville, "
            		+ "q.idquartier, nomQ, "
            		+ "v.idvisite, "
            		+ "t.idtypevisite, t.libtypevisite, "
            		+ "m.anneeconstruction, m.anneefinconstruction, m.idmonument";

        // Obtention de l'ensemble résultat
        ResultSet rsM = stmt.executeQuery(queryNomCompl);
        // Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
        if(rsM.next()){
            annCons = rsM.getInt("anneeconstruction");
            annFinCons = rsM.getInt("anneefinconstruction");
            
            idLieu = rsM.getInt("idlieu");
            nomLieu = rsM.getString("nomL");
            descriptionLieu = rsM.getString("description");
            accessibiliteLieu = rsM.getString("accessibilite");
            
            idAdresse = rsM.getInt("idadresse");
            numAdres = rsM.getInt("numero");
            voieAdres = rsM.getString("voie");
            cpAdres = rsM.getString("codepostal");
            villeAdres = rsM.getString("ville");

            idQuartier = rsM.getInt("idquartier");
            nomQuartier = rsM.getString("nomQ");

            idVisite = rsM.getInt("idvisite");
            
            idTypevisite = rsM.getInt("idtypevisite");
            typeVisite = rsM.getString("libtypevisite");
            
            notemoy = rsM.getFloat("notemoy");
            nbavis = rsM.getInt("nbavis");
        }
        
        Lieu lieu = new Lieu(idLieu);
        listeDesAvisDunLieu = lieu.getListeDesAvisDunLieu();  
           
    }
	
    public Monument(int idVisite, int annCons, int annFinCons) {
    	this.idVisite=idVisite;
    	this.annCons=annCons;
    	this.annFinCons=annFinCons;
    }
    
    // METHODES PUBLIQUES
	public int save(Connection cnx) throws Exception {
		String query = " INSERT INTO monuments (idvisite,anneeconstruction,anneefinconstruction) VALUES (?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idVisite);
		ps.setInt(2, annCons);
		ps.setInt(3, annFinCons);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idMonument = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idMonument;
	}
	
	public int update(Connection cnx, int idVisite, int annCons, int annFinCons) throws SQLException {
		
		String query = " UPDATE monuments SET idvisite=?, anneeconstruction=?, anneefinconstruction=? WHERE idmonument=" + idMonument + ";";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, idVisite);
		ps.setInt(2, annCons);
		ps.setInt(3, annFinCons);
		return ps.executeUpdate();
		
	}
    
    // LISTE DES TYPES DE MONUMENT
    private static List<Typevisite> listeDesTypevisitesDeMonument;
    
	public static List<Typevisite> getListeDesTypevisitesDeMonument() throws SQLException{
		listeDesTypevisitesDeMonument = new ArrayList<Typevisite>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query  = "SELECT idtypevisite, typev, libtypevisite "
						+ "FROM typevisites "
						+ "WHERE typev='M' "
						+ "ORDER BY libtypevisite;"	;
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
		while(rs.next()){
			Typevisite tv = new Typevisite();
			tv.setIdTypevisite(rs.getInt("idtypevisite"));
			tv.setLibtypevisite(rs.getString("libtypevisite"));

			listeDesTypevisitesDeMonument.add(tv);
		}
				
		return listeDesTypevisitesDeMonument;
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
		String query  = "SELECT l.nom AS nomL, l.idlieu AS idLieu, q.nom AS nomQ, "
				+ "t.libtypevisite, m.idmonument, "
				+ "AVG(av.note) AS notemoy, COUNT(av.note) AS nbavis "
				+ "FROM monuments m "
				+ "INNER JOIN visites v USING (idvisite) "
				+ "INNER JOIN lieux l USING (idlieu) "
				+ "INNER JOIN adresses a USING (idadresse) "
				+ "INNER JOIN quartiers q USING (idquartier) "
				+ "INNER JOIN typevisites t ON v.idtypevisite = t.idtypevisite "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "GROUP BY l.nom, q.nom, t.libtypevisite, m.idmonument, l.idLieu "
				+ "ORDER BY l.nom;";

		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
		while(rs.next()){
			Monument m = new Monument();
			m.idMonument = rs.getInt("idmonument");
			m.nomLieu = rs.getString("nomL");
			m.nomQuartier = rs.getString("nomQ");
			m.typeVisite = rs.getString("libtypevisite");
			m.notemoy = rs.getFloat("notemoy");
			m.nbavis = rs.getInt("nbavis");
			m.idLieu = rs.getInt("idLieu");

			listeDesMonuments.add(m);
		}
		
		return listeDesMonuments;
	}

}
