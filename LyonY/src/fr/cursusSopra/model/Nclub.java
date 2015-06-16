package fr.cursusSopra.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Nclub extends Sortie {

	private int idNightclub;
	private String nomnightclub;
	private String nomquartier;
	private int prixmin;
	private int prixmax;
	private String libambiance;
	private int numero;
	private String voie;
	private int codepostal;
	private String ville;
	private String description;
	private String ambiance;
	private float notemoy;
	private int nbavis;
	private List<Avis> listeDesAvisDunLieu;



	public Nclub() {
	}
	
	public Nclub(int id) throws SQLException {
		idNightclub = id;
		
		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		
		// Requête à exécuter
		String query = "SELECT l.idlieu, n.idsortie, n.idnightclub, l.nom nomnightclub,q.nom nomquartier, libambiance, prixmin, prixmax, numero, voie, codepostal, ville, description, AVG(av.note) AS notemoy,COUNT(av.note) AS nbavis "
				+ "FROM nightclubs n "
				+ "INNER JOIN sorties s ON s.idsortie=n.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "WHERE n.idnightclub =" + idNightclub
				+ " GROUP BY l.idlieu, n.idnightclub, l.nom ,q.nom , libambiance, prixmin, prixmax, numero, voie, codepostal, ville, description";
		
		
		
		
		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		int idl = 0;
		if (rs.next()) {
			idNightclub = rs.getInt("idnightclub");
			idSortie = rs.getInt("idsortie");
			nomnightclub = rs.getString("nomnightclub");
			nomquartier = rs.getString("nomquartier");
			libambiance = rs.getString("libambiance");
			prixmin = rs.getInt("prixmin");
			prixmax = rs.getInt("prixmax");
			numero = rs.getInt("numero");
			voie = rs.getString("voie");
			codepostal = rs.getInt("codepostal");
			ville = rs.getString("ville");
			description = rs.getString("description");
			notemoy = rs.getFloat("notemoy");
			nbavis = rs.getInt("nbavis");
			idl = rs.getInt("idlieu");
		}
		// Construction de la liste des horaires - Méthode de la classe mère
		getListeDesHoraires();
		
		Lieu lieu = new Lieu(idl);
        listeDesAvisDunLieu = lieu.getListeDesAvisDunLieu();  
	}

	// Getters and Setters

	public String getNomnightclub() {
		return nomnightclub;
	}
	public String getNomquartier() {
		return nomquartier;
	}
	public int getPrixmin() {
		return prixmin;
	}
	public int getPrixmax() {
		return prixmax;
	}
	public int getIdNightclub() {
		return idNightclub;
	}
	public void setIdNightclub(int idNightclub) {
		this.idNightclub = idNightclub;
	}
	public String getLibambiance() {
		return libambiance;
	}
	public void setLibambiance(String libambiance) {
		this.libambiance = libambiance;
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
	public int getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAmbiance() {
		return ambiance;
	}

	public void setAmbiance(String ambiance) {
		this.ambiance = ambiance;
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


	// public int save() throws SQLException {
	// Connection cnx = PostgresConnection.getConnexion();
	// String query =
	// "INSERT INTO candidats(nom, prenom, datenaissance, villenaissance) "
	// + "VALUES (?, ?, ?, ?)";
	// PreparedStatement ps = cnx.prepareStatement(query);
	// ps.setString(1, nom);
	// ps.setString(2, prenom);
	// ps.setDate(3, new java.sql.Date(dateNaissance.getTime()));
	// ps.setString(4, villeNaissance);
	//
	// int ret = ps.executeUpdate();
	//
	// return ret;
	//
	// }
	//
	// public int edit() throws SQLException {
	// Connection cnx = PostgresConnection.getConnexion();
	// String query =
	// "UPDATE candidats SET nom=?, prenom=?, datenaissance=?, villenaissance=? "
	// + "WHERE idCandidat=?";
	// PreparedStatement ps = cnx.prepareStatement(query);
	// ps.setString(1, nom);
	// ps.setString(2, prenom);
	// ps.setDate(3, new java.sql.Date(dateNaissance.getTime()));
	// ps.setString(4, villeNaissance);
	// ps.setInt(5, idCandidat);
	//
	//
	// int ret = ps.executeUpdate();
	//
	// return ret;
	//
	// }
	//
	// public int delete() throws SQLException {
	// Connection cnx = PostgresConnection.getConnexion();
	// String query = "DELETE FROM candidats "
	// + "WHERE idCandidat=?";
	// PreparedStatement ps = cnx.prepareStatement(query);
	// ps.setInt(1, idCandidat);
	//
	// int ret = ps.executeUpdate();
	//
	// return ret;
	//
	// }
	
	 // LISTE DES TYPES DE NCLUB
    private static List<Ambiance> listeDesAmbiancesDeNclub;
    
	public static List<Ambiance> getListeDesAmbiancesDeNclub() throws SQLException{
		listeDesAmbiancesDeNclub = new ArrayList<Ambiance>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query  = "SELECT idambiance, types, libambiance "
				+ "FROM ambiances "
				+ "WHERE types='N' "
				+ "ORDER BY libambiance;";
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
		while(rs.next()){
			Ambiance a = new Ambiance();
			a.setIdambiance(rs.getInt("idambiance"));
			a.setTypes(rs.getString("types"));
			a.setLibambiance(rs.getString("libambiance"));

			listeDesAmbiancesDeNclub.add(a);
		}
				
		return listeDesAmbiancesDeNclub;
	}

	/* Membres statiques */
	public static List<Nclub> listeDesNightclubs;

	public static List<Nclub> getListeDesNightclubs() throws SQLException {

		listeDesNightclubs = new ArrayList<Nclub>();

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query = "SELECT n.idnightclub, l.nom nomnightclub,q.nom nomquartier, libambiance, prixmin, prixmax, AVG(av.note) AS notemoy, "
				+ "COUNT (av.note) AS nbavis "
				+ "FROM nightclubs n  "
				+ "INNER JOIN sorties s ON s.idsortie=n.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "GROUP BY nomnightclub, nomquartier, libambiance, n.idnightclub, prixmin, prixmax;";

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Nclub n = new Nclub();
			n.idNightclub = rs.getInt("idnightclub");
			n.nomnightclub = rs.getString("nomnightclub");
			n.nomquartier = rs.getString("nomquartier");
			n.libambiance = rs.getString("libambiance");
			n.prixmin = rs.getInt("prixmin");
			n.prixmax = rs.getInt("prixmax");
			n.notemoy = rs.getFloat("notemoy");
			n.nbavis = rs.getInt("nbavis");
			listeDesNightclubs.add(n);
		}
		return listeDesNightclubs;
	}
}
