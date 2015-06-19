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
	private String codePostal;
	private String ville;
	private String description;
	private String accessibilite;
	private boolean reservation;
	private boolean aemporter;
	private String ambiance;
	private float notemoy;
	private int nbavis;
	private List<Avis> listeDesAvisDunLieu;
	private List<Photo> listeDesPhotosDeRestaurant;
	

//////////////Getters and Setters////////////////////
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
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
	public String getAccessibilite() {
		return accessibilite;
	}
	public void setAccessibilite(String accessibilite) {
		this.accessibilite = accessibilite;
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
	public void setListeDesAvisDunLieu(List<Avis> listeDesAvisDunLieu) {
		this.listeDesAvisDunLieu = listeDesAvisDunLieu;
	}
	public List<Avis> getListeDesAvisDunLieu() {
		return listeDesAvisDunLieu;
	}

	public List<Photo> getListeDesPhotosDeRestaurant() {
		return listeDesPhotosDeRestaurant;
	}
	public void setListeDesPhotosDeRestaurant(List<Photo> listeDesPhotosDeRestaurant) {
		this.listeDesPhotosDeRestaurant = listeDesPhotosDeRestaurant;
	}
	//CTORS
	public Restaurant() {
		
		listeDesPhotosDeRestaurant= new ArrayList<Photo>();
	}
	
	public Restaurant(int id) throws SQLException {
		idRestaurant = id;
		
		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		
		// Requête à exécuter
		String query = "SELECT l.idlieu, r.idsortie, r.idrestaurant, l.nom nomrestaurant,q.nom nomquartier, numero, "
				+ "voie, codePostal, ville, libambiance, prixmin, prixmax, description, accessibilite, "
				+ "reservation, aemporter, AVG(av.note) AS notemoy,COUNT(av.note) AS nbavis, idphoto, libphoto	"
				+ "FROM restaurants r "
				+ "INNER JOIN sorties s ON s.idsortie=r.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "INNER JOIN photos p on p.idlieu = l.idlieu "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu"
				+ "WHERE idrestaurant = "+ idRestaurant
				+ " GROUP BY l.idlieu, r.idrestaurant, l.nom ,q.nom , libambiance, prixmin, prixmax, numero, voie, "
				+ "codePostal, ville, description, idphoto";
		
		
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
			codePostal = rs.getString("codePostal");
			ville = rs.getString("ville");
			description = rs.getString("description");
			accessibilite = rs.getString("accessibilite");
			reservation = rs.getBoolean("reservation");
			aemporter = rs.getBoolean("aemporter");
			notemoy = rs.getFloat("notemoy");
			nbavis = rs.getInt("nbavis");
			idl = rs.getInt("idlieu");
			
		}
	
	
	
	// Construction de la liste des horaires - Méthode de la classe mère
	getListeDesHoraires(idSortie);
	
	Lieu lieu = new Lieu(idl);
    listeDesAvisDunLieu = lieu.getListeDesAvisDunLieu();  
}

	public Restaurant(int idSortie, boolean reservation, boolean aemporter) {
		this.setIdSortie(idSortie);
		this.setReservation(reservation);
		this.setAemporter(aemporter);
	}

	// METHODES PUBLIQUES
		public int save(Connection cnx) throws Exception {
			String query = " INSERT INTO restaurants (idsortie, reservation, aemporter) VALUES (?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idSortie);
			ps.setBoolean(2, reservation);
			ps.setBoolean(3, aemporter);

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				idRestaurant = rs.getInt(1);
			} else {
				throw new Exception();
			}
			return idRestaurant;
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
			a.setIdAmbiance(rs.getInt("idambiance"));
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
		String query = "SELECT DISTINCT r.idrestaurant, l.nom nomrestaurant,q.nom nomquartier, libambiance, prixmin, prixmax, AVG(av.note) AS notemoy, "
				+ "COUNT (av.note) AS nbavis "
				+ "FROM restaurants r "
				+ "INNER JOIN sorties s ON s.idsortie=r.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "INNER JOIN photos p ON l.idlieu = p.idlieu "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "GROUP BY nomrestaurant, nomquartier, libambiance, r.idrestaurant, prixmin, prixmax";

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
			
			Statement stmt2= cnx.createStatement();
			
			String query2 = "SELECT  idphoto "
					+ "FROM photos p "
					+ "INNER JOIN lieux l ON p.idlieu=l.idlieu "
					+ "INNER JOIN sorties s ON l.idlieu=s.idlieu "
					+ "INNER JOIN restaurants r ON s.idsortie=r.idsortie "
					+ "WHERE idrestaurant =" + r.idRestaurant;
			
			ResultSet rs2 = stmt2.executeQuery(query2);
					
			while (rs2.next()) {
				
				r.listeDesPhotosDeRestaurant.add(new Photo(rs2.getInt("idphoto")));
				
			
			}

			
			listeDesRestaurants.add(r);
		}

		return listeDesRestaurants;

	}
	
public void modifRestaurant(String nomrestaurant,int idAmbiance, int idQuartier, int numero, String voie, String codePostal, String ville, String description, String accessibilite, int prixmin, int prixmax,boolean reservation, boolean aemporter ) throws SQLException {

		

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		
		String withQuery = "WITH A AS "
				+ "("
				+ "select * FROM restaurants "
				+ "INNER JOIN sorties USING (idsortie) "
				+ "INNER JOIN lieux USING (idlieu) "
				+ "INNER JOIN adresses USING (idadresse) "
				+ "INNER JOIN quartiers using (idquartier) "
				+ "INNER JOIN ambiances USING (idambiance) "
				+ "WHERE idrestaurant = "+ idRestaurant
				+ ") ";
		
		// Requête à exécuter
		String query1 ="UPDATE lieux l SET nom = ?,description = ?,accessibilite = ? FROM  A WHERE l.idlieu = A.idlieu ";
		String query2 ="UPDATE adresses ad SET numero = ?,voie = ?,codePostal = ?,ville = ?,idquartier = ? FROM  A WHERE ad.idadresse = A.idadresse ";
		String query3 ="UPDATE sorties s SET prixmin = ?, prixmax = ?, idambiance = ? FROM  A WHERE s.idsortie = A.idsortie ";
		String query4 ="UPDATE restaurants r SET reservation = ?, aemporter = ? FROM  A WHERE r.idsortie = A.idsortie ";
				
				

		
		// Object instruction SQL
		PreparedStatement stmt = cnx.prepareStatement(withQuery + query1);
		
		stmt.setString(1,nomrestaurant);
		stmt.setString(2,description);
		stmt.setString(3,accessibilite);
		
		// execution de la requete de mise à jour
		stmt.executeUpdate();
		
		
		
		
		
		stmt = cnx.prepareStatement(withQuery + query2);
		stmt.setInt(1,numero);
		stmt.setString(2,voie);
		stmt.setString(3,codePostal);
		stmt.setString(4,ville);
		stmt.setInt(5,idQuartier);
		stmt.executeUpdate();
		
		
		stmt = cnx.prepareStatement(withQuery + query3);
		stmt.setInt(1,prixmin);
		stmt.setInt(2,prixmax);
		stmt.setInt(3,idAmbiance);
		stmt.executeUpdate();
		
		stmt = cnx.prepareStatement(withQuery + query4);
		stmt.setBoolean(1,reservation);
		stmt.setBoolean(2,aemporter);
		stmt.executeUpdate();
		
		


	}

}
