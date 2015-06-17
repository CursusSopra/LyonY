package fr.cursusSopra.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Bar extends Sortie {

	private int idBar;
	private int happyhour;
	private String nombar;
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
	private String ambiance;
	private float notemoy;
	private int nbavis;
	private int idSortie;
	private List<Avis> listeDesAvisDunLieu;

	// Getters and Setters

	public String getNombar() {
		return nombar;
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
	public int getIdBar() {
		return idBar;
	}
	public void setIdBar(int idBar) {
		this.idBar = idBar;
	}
	public int getHappyhour() {
		return happyhour;
	}
	public void setHappyhour(int happyhour) {
		this.happyhour = happyhour;
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
	public int getIdSortie() {
		return idSortie;
	}
	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}
	public List<Avis> getListeDesAvisDunLieu() {
		return listeDesAvisDunLieu;
	}

	// CTORS

	public Bar() {
	}

	public Bar(int id) throws SQLException {
		idBar = id;

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();

		// Requête à exécuter
		String query = "SELECT l.idlieu, b.idbar, l.nom nombar,q.nom nomquartier, libambiance, "
				+ "prixmin, prixmax, numero, voie, codepostal, ville, description, l.accessibilite, happyhour, "
				+ "AVG(av.note) AS notemoy,COUNT(av.note) AS nbavis "
				+ "FROM bars b "
				+ "INNER JOIN sorties s ON s.idsortie=b.idsortie "
				+ "INNER JOIN lieux l ON s.idlieu=l.idlieu "
				+ "INNER JOIN adresses a ON a.idadresse=l.idadresse "
				+ "INNER JOIN quartiers q ON q.idquartier=a.idquartier "
				+ "INNER JOIN ambiances am ON am.idambiance=s.idambiance "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "WHERE b.idbar = "
				+ idBar
				+ " GROUP BY l.idlieu, b.idbar, l.nom ,q.nom , libambiance, prixmin, prixmax, numero, voie, codepostal, ville, "
				+ "description, l.accessibilite";

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		int idl = 0;
		if (rs.next()) {
			idBar = rs.getInt("idbar");
			nombar = rs.getString("nombar");
			nomquartier = rs.getString("nomquartier");
			libambiance = rs.getString("libambiance");
			prixmin = rs.getInt("prixmin");
			prixmax = rs.getInt("prixmax");
			numero = rs.getInt("numero");
			voie = rs.getString("voie");
			codePostal = rs.getString("codepostal");
			ville = rs.getString("ville");
			description = rs.getString("description");
			accessibilite = rs.getString("accessibilite");
			notemoy = rs.getFloat("notemoy");
			nbavis = rs.getInt("nbavis");
			idl = rs.getInt("idlieu");
		}
		// Construction de la liste des horaires - Méthode de la classe mère
		getListeDesHoraires();

		Lieu lieu = new Lieu(idl);
		listeDesAvisDunLieu = lieu.getListeDesAvisDunLieu();
	}

	public Bar(int idSortie, int happyhour) {
		this.setIdSortie(idSortie);
		this.happyhour = happyhour;
	}

	// METHODES PUBLIQUES
	public int save(Connection cnx) throws Exception {
		String query = " INSERT INTO bars (idsortie, happyhour) VALUES (?,?)";
		PreparedStatement ps = cnx.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idSortie);
		ps.setInt(2, happyhour);

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idBar = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idBar;
	}

	// LISTE DES TYPES DE BAR
	private static List<Ambiance> listeDesAmbiancesDeBar;

	public static List<Ambiance> getListeDesAmbiancesDeBar()
			throws SQLException {
		listeDesAmbiancesDeBar = new ArrayList<Ambiance>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query = "SELECT idambiance, types, libambiance "
				+ "FROM ambiances " + "WHERE types='B' "
				+ "ORDER BY libambiance;";
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		// Parcourt l'ensemble des résultats et crée objets candidats puis màj
		// la liste
		while (rs.next()) {
			Ambiance a = new Ambiance();
			a.setIdAmbiance(rs.getInt("idambiance"));
			a.setTypes(rs.getString("types"));
			a.setLibambiance(rs.getString("libambiance"));

			listeDesAmbiancesDeBar.add(a);
		}

		return listeDesAmbiancesDeBar;
	}

	/* Membres statiques */
	public static List<Bar> listeDesBars;

	public static List<Bar> getListeDesBars() throws SQLException {

		listeDesBars = new ArrayList<Bar>();

		// Connexion à la BDD postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Object instruction SQL
		Statement stmt = cnx.createStatement();
		// Requête à exécuter
		String query = "SELECT b.idbar, l.nom nombar,q.nom nomquartier, libambiance, prixmin, prixmax, AVG(av.note) AS notemoy, "
				+ "COUNT (av.note) AS nbavis "
				+ "FROM bars b "
				+ "INNER JOIN sorties s USING (idsortie) "
				+ "INNER JOIN lieux l USING (idlieu) "
				+ "INNER JOIN adresses a USING (idadresse) "
				+ "INNER JOIN quartiers q USING (idquartier) "
				+ "INNER JOIN ambiances am USING (idambiance) "
				+ "LEFT OUTER JOIN avis av ON l.idlieu = av.idlieu "
				+ "GROUP BY nombar, nomquartier, libambiance, b.idbar, prixmin, prixmax;";

		// Obtention de l'ensemble résultats
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Bar b = new Bar();
			b.idBar = rs.getInt("idbar");
			b.nombar = rs.getString("nombar");
			b.nomquartier = rs.getString("nomquartier");
			b.libambiance = rs.getString("libambiance");
			b.prixmin = rs.getInt("prixmin");
			b.prixmax = rs.getInt("prixmax");
			b.notemoy = rs.getFloat("notemoy");
			b.nbavis = rs.getInt("nbavis");
			listeDesBars.add(b);
		}
		return listeDesBars;
	}
}
