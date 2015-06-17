package fr.cursusSopra.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Restaurant extends Sortie {

	private int idRestaurant;
	private String nomrestaurant;
	private String nomquartier;
	private int prixmin;
	private int prixmax;
	private String libambiance;
	private int numero;
	private String voie;
	private int codepostal;
	private String ville;
	private String description;
	private boolean reservation;
	private boolean aemporter;
	private String ambiance;
	private float notemoy;
	private int nbavis;
	private List<Avis> listeDesAvisDunLieu;

	public Restaurant() {
	}
	
	public Restaurant(int id) throws SQLException {
		idRestaurant = id;
		
		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		
		// Requête à exécuter
		String query = "SELECT l.idlieu, r.idsortie, r.idrestaurant, l.nom nomrestaurant,q.nom nomquartier, numero, voie, codepostal, ville, libambiance, prixmin, prixmax, description, reservation, aemporter, AVG(av.note) AS notemoy,COUNT(av.note) AS nbavis "
				+ "FROM restaurants r "
				+ "INNER JOIN sorties s ON s.idsortie=r.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "WHERE idrestaurant = " + idRestaurant
				+ " GROUP BY l.idlieu, r.idrestaurant, l.nom ,q.nom , libambiance, prixmin, prixmax, numero, voie, codepostal, ville, description";
		
		
		
		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		int idl = 0;
		if (rs.next()) {
			idRestaurant = rs.getInt("idrestaurant");
			idSortie = rs.getInt("idsortie");
			nomrestaurant = rs.getString("nomrestaurant");
			nomquartier = rs.getString("nomquartier");
			libambiance = rs.getString("libambiance");
			prixmin = rs.getInt("prixmin");
			prixmax = rs.getInt("prixmax");
			numero = rs.getInt("numero");
			voie = rs.getString("voie");
			codepostal = rs.getInt("codepostal");
			ville = rs.getString("ville");
			description = rs.getString("description");
			reservation = rs.getBoolean("reservation");
			aemporter = rs.getBoolean("aemporter");
			notemoy = rs.getFloat("notemoy");
			nbavis = rs.getInt("nbavis");
			idl = rs.getInt("idlieu");
			
		}
		// Construction de la liste des horaires - Méthode de la classe mère
		getListeDesHoraires();
		
		Lieu lieu = new Lieu(idl);
        listeDesAvisDunLieu = lieu.getListeDesAvisDunLieu();  
	}

	// /////////////// Getters and Setters/////////////////////////////////////////////////////////////

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idsortie) {
		this.idSortie = idsortie;
	}

	public String getNomrestaurant() {
		return nomrestaurant;
	}

	public void setNomrestaurant(String nomrestaurant) {
		this.nomrestaurant = nomrestaurant;
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

	public boolean isReservation() {
		return reservation;
	}

	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}

	public boolean isAemporter() {
		return aemporter;
	}

	public void setAemporter(boolean aemporter) {
		this.aemporter = aemporter;
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

	
	// LISTE DES TYPES DE RESTAURANT
    private static List<Ambiance> listeDesAmbiancesDeRestaurant;
    
	public static List<Ambiance> getListeDesAmbiancesDeRestaurant() throws SQLException{
		listeDesAmbiancesDeRestaurant = new ArrayList<Ambiance>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query  = "SELECT idambiance, types, libambiance "
				+ "FROM ambiances "
				+ "WHERE types='R' "
				+ "ORDER BY libambiance;";
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
		while(rs.next()){
			Ambiance a = new Ambiance();
			a.setIdambiance(rs.getInt("idambiance"));
			a.setTypes(rs.getString("types"));
			a.setLibambiance(rs.getString("libambiance"));

			listeDesAmbiancesDeRestaurant.add(a);
		}
				
		return listeDesAmbiancesDeRestaurant;
	}

	/* Membres statiques */
	public static List<Restaurant> listeDesRestaurants;

	public static List<Restaurant> getListeDesRestaurants() throws SQLException {

		listeDesRestaurants = new ArrayList<Restaurant>();

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query = "SELECT r.idrestaurant, l.nom nomrestaurant,q.nom nomquartier, libambiance, prixmin, prixmax, AVG(av.note) AS notemoy, "
				+ "COUNT (av.note) AS nbavis "
				+ "FROM restaurants r "
				+ "INNER JOIN sorties s ON s.idsortie=r.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "GROUP BY nomrestaurant, nomquartier, libambiance, r.idrestaurant, prixmin, prixmax;";

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Restaurant r = new Restaurant();
			r.idRestaurant = rs.getInt("idrestaurant");
			r.nomrestaurant = rs.getString("nomrestaurant");
			r.nomquartier = rs.getString("nomquartier");
			r.libambiance = rs.getString("libambiance");
			r.prixmin = rs.getInt("prixmin");
			r.prixmax = rs.getInt("prixmax");
			r.notemoy = rs.getFloat("notemoy");
			r.nbavis = rs.getInt("nbavis");
			listeDesRestaurants.add(r);
		}

		return listeDesRestaurants;

	}

}
