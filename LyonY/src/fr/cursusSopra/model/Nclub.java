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
	private String codePostal;
	private String ville;
	private String description;
	private String ambiance;
	private float notemoy;
	private int nbavis;
	private List<Avis> listeDesAvisDunLieu;

	// Getters and Setters

	public int getIdNightclub() {
		return idNightclub;
	}
	public void setIdNightclub(int idNightclub) {
		this.idNightclub = idNightclub;
	}
	public String getNomnightclub() {
		return nomnightclub;
	}
	public void setNomnightclub(String nomnightclub) {
		this.nomnightclub = nomnightclub;
	}
	public String getNomquartier() {
		return nomquartier;
	}
	public void setNomquartier(String nomquartier) {
		this.nomquartier = nomquartier;
	}
	public int getPrixmin() {
		return prixmin;
	}
	public void setPrixmin(int prixmin) {
		this.prixmin = prixmin;
	}
	public int getPrixmax() {
		return prixmax;
	}
	public void setPrixmax(int prixmax) {
		this.prixmax = prixmax;
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
	public void setListeDesAvisDunLieu(List<Avis> listeDesAvisDunLieu) {
		this.listeDesAvisDunLieu = listeDesAvisDunLieu;
	}
	public static void setListeDesAmbiancesDeNclub(
			List<Ambiance> listeDesAmbiancesDeNclub) {
		Nclub.listeDesAmbiancesDeNclub = listeDesAmbiancesDeNclub;
	}
	public static void setListeDesNightclubs(List<Nclub> listeDesNightclubs) {
		Nclub.listeDesNightclubs = listeDesNightclubs;
	}

	//CTORS
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
			codePostal = rs.getString("codepostal");
			ville = rs.getString("ville");
			description = rs.getString("description");
			notemoy = rs.getFloat("notemoy");
			nbavis = rs.getInt("nbavis");
			idl = rs.getInt("idlieu");
		}
		// Construction de la liste des horaires - Méthode de la classe mère
		getListeDesHoraires(idSortie);
		
		Lieu lieu = new Lieu(idl);
        listeDesAvisDunLieu = lieu.getListeDesAvisDunLieu();  
	}

	public Nclub(int idSortie, String nomnightclub) {
		this.setIdSortie(idSortie);
		this.setNomnightclub(nomnightclub);
		
	}

	// METHODES PUBLIQUES
		public int save(Connection cnx) throws Exception {
			String query = " INSERT INTO nightclubs (idsortie) VALUES (?)";
			PreparedStatement ps = cnx.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idSortie);
	
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				idNightclub = rs.getInt(1);
			} else {
				throw new Exception();
			}
			return idNightclub;
		}
	
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
			a.setIdAmbiance(rs.getInt("idambiance"));
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
	
	
	//Modification
	public void modifNightclub(String nomnightclub,int idambiance, int idquartier, int numero, String voie, String codepostal, String ville, String description, String accessibilite, int prixmin, int prixmax ) throws SQLException {

		

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		
		String withQuery = "WITH A AS "
				+ "("
				+ "select * FROM nightclubs "
				+ "INNER JOIN sorties USING (idsortie) "
				+ "INNER JOIN lieux USING (idlieu) "
				+ "INNER JOIN adresses USING (idadresse) "
				+ "INNER JOIN quartiers using (idquartier) "
				+ "INNER JOIN ambiances USING (idambiance) "
				+ "WHERE idnightclub = "+ idNightclub
				+ ") ";
		
		// Requête à exécuter
		String query1 ="UPDATE lieux l SET nom = ?,description = ?,accessibilite = ? FROM  A WHERE l.idlieu = A.idlieu ";
		String query2 ="UPDATE adresses ad SET numero = ?,voie = ?,codepostal = ?,ville = ?,idquartier = ? FROM  A WHERE ad.idadresse = A.idadresse ";
		String query3 ="UPDATE sorties s SET prixmin = ?, prixmax = ?, idambiance = ? FROM  A WHERE s.idsortie = A.idsortie ";
				
				

		
		// Object instruction SQL
		PreparedStatement stmt = cnx.prepareStatement(withQuery + query1);
		
		stmt.setString(1,nomnightclub);
		stmt.setString(2,description);
		stmt.setString(3,accessibilite);
		
		// execution de la requete de mise à jour
		stmt.executeUpdate();
		
		
		
		
		
		stmt = cnx.prepareStatement(withQuery + query2);
		stmt.setInt(1,numero);
		stmt.setString(2,voie);
		stmt.setString(3,codepostal);
		stmt.setString(4,ville);
		stmt.setInt(5,idquartier);
		stmt.executeUpdate();
		
		
		stmt = cnx.prepareStatement(withQuery + query3);
		stmt.setInt(1,prixmin);
		stmt.setInt(2,prixmax);
		stmt.setInt(3,idambiance);
		stmt.executeUpdate();
		
		


	}
}
