package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Placeetparc  {

	private int idPlaceetparc;
	private boolean avecFontaine;

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
	
	// GETSETS
	public int getIdPlaceetparc() {
		return idPlaceetparc;
	}
	public void setIdPlaceetparc(int idPlaceetparc) {
		this.idPlaceetparc = idPlaceetparc;
	}
	public boolean isAvecFontaine() {
		return avecFontaine;
	}
	public void setAvecFontaine(boolean avecFontaine) {
		this.avecFontaine = avecFontaine;
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

	// CTOR
	public Placeetparc() {
		
	}
	
    public Placeetparc(int idVisite, boolean avecFontaine) {
    	this.idVisite=idVisite;
    	this.avecFontaine=avecFontaine;
    }

    public Placeetparc(int idp) throws SQLException {
        idPlaceetparc = idp;
        // connexion à la BDD PostGresSQL
        Connection cnx = null;
        cnx = PostgresConnection.getConnexion();
        // Objet instruction SQL
        Statement stmt = cnx.createStatement();
        // Requête à exécuter
        String queryPPCompl  = "SELECT "
        		+ "l.idlieu, l.nom AS nomL, l.description, l.accessibilite, "
        		+ "a.idadresse, a.numero, a.voie, a.codepostal, a.ville, "
        		+ "q.idquartier, q.nom AS nomQ, "
        		+ "t.idtypevisite, t.libtypevisite, "
        		+ "v.idvisite, "
        		+ "p.idplaceetparc, p.avecfontaine, "
        		+ "AVG(av.note) AS notemoy, COUNT(av.note) AS nbavis  "
        	+ "FROM placeetparcs p "
        		+ "INNER JOIN visites v USING (idvisite) "
        		+ "INNER JOIN lieux l USING (idlieu) "
        		+ "INNER JOIN adresses a USING (idadresse) "
        		+ "INNER JOIN quartiers q USING (idquartier) "
        		+ "INNER JOIN typevisites t ON v.idtypevisite = t.idtypevisite "
        		+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
    		+ "WHERE p.idplaceetparc = "+ idPlaceetparc
    		+ "GROUP BY l.idlieu, nomL, l.description, l.accessibilite, "
            	+ "a.idadresse, a.numero, a.voie, a.codepostal, a.ville, "
            	+ "q.idquartier, nomQ, "
            	+ "v.idvisite, "
            	+ "t.idtypevisite, t.libtypevisite, "
        		+ "p.idplaceetparc, p.avecfontaine;";
        // Obtention de l'ensemble résultat
        ResultSet rsPP = stmt.executeQuery(queryPPCompl);
        // Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
        if(rsPP.next()){
            avecFontaine = rsPP.getBoolean("avecfontaine");
            
            idLieu = rsPP.getInt("idlieu");
            nomLieu = rsPP.getString("nomL");
            descriptionLieu = rsPP.getString("description");
            accessibiliteLieu = rsPP.getString("accessibilite");
            
            idAdresse = rsPP.getInt("idadresse");
            numAdres = rsPP.getInt("numero");
            voieAdres = rsPP.getString("voie");
            cpAdres = rsPP.getString("codepostal");
            villeAdres = rsPP.getString("ville");

            idQuartier = rsPP.getInt("idquartier");
            nomQuartier = rsPP.getString("nomQ");

            idVisite = rsPP.getInt("idvisite");
            
            idTypevisite = rsPP.getInt("idtypevisite");
            typeVisite = rsPP.getString("libtypevisite");
            
            notemoy = rsPP.getFloat("notemoy");
            nbavis = rsPP.getInt("nbavis");
        }
        
        Lieu lieu = new Lieu(idLieu);
        listeDesAvisDunLieu = lieu.getListeDesAvisDunLieu();  
        
    }

	// METHODES PUBLIQUES
    // INSERTION NV PLACE ET PARC EN BDD
	public int save(Connection cnx) throws Exception {
		String query = "INSERT INTO placeetparcs (idvisite,avecfontaine) VALUES (?,?)";
		PreparedStatement ps = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idVisite);
		ps.setBoolean(2, avecFontaine);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idPlaceetparc = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idPlaceetparc;
	}
	
	public int update(Connection cnx, int idVisite, boolean avecFontaine) throws SQLException {

		// Mise à jour de l'objet courant
		this.idVisite=idVisite;
		this.avecFontaine=avecFontaine;
		
		// Mise à jour de la bse de données
		String query = " UPDATE placeetparcs SET idvisite=?, avecfontaine=? WHERE idplaceetparc=" + idPlaceetparc + ";";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, idVisite);
		ps.setBoolean(2, avecFontaine);
		return ps.executeUpdate();
		
	}
    
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
							+ "l.nom AS nomL, l.idlieu AS idLieu, "
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
						+ "GROUP BY l.nom, t.libtypevisite, q.nom, p.idplaceetparc, l.idLieu "
						+ "ORDER BY l.nom;"	;
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets Placeetparc puis màj la liste
		while(rs.next()){
			Placeetparc p = new Placeetparc();
			p.idPlaceetparc = rs.getInt("idplaceetparc");
			p.nomLieu = rs.getString("nomL");
			p.nomQuartier = rs.getString("nomQ");
			p.typeVisite = rs.getString("libtypevisite");
			p.notemoy = rs.getFloat("notemoy");
			p.nbavis = rs.getInt("nbavis");
			p.idLieu = rs.getInt("idLieu");
			

			listeDesPlaceetparcs.add(p);
		}
		
		return listeDesPlaceetparcs;
	}

	// LISTE DES TYPES DE PLACEETPARC
    private static List<Typevisite> listeDesTypevisitesDePlaceetparc;
    
	public static List<Typevisite> getListeDesTypevisitesDePlaceetparc() throws SQLException{
		listeDesTypevisitesDePlaceetparc = new ArrayList<Typevisite>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query  = "SELECT idtypevisite, typev, libtypevisite "
						+ "FROM typevisites "
						+ "WHERE typev='P' "
						+ "ORDER BY libtypevisite;"	;
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
		while(rs.next()){
			Typevisite tv = new Typevisite();
			tv.setIdTypevisite(rs.getInt("idtypevisite"));
			tv.setLibtypevisite(rs.getString("libtypevisite"));

			listeDesTypevisitesDePlaceetparc.add(tv);
		}
				
		return listeDesTypevisitesDePlaceetparc;
	}
	
}
