package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Lieu {

	private int idLieu;
	private String nom;
	private String description;
	private String accessibilite;
	private int idAdresse;
	
	// Adresse du lieu
	private Adresse adresse;
	
	// Constructeur vide non accessible 
	private Lieu() {};

	// Constructeur à partir du nom
	public Lieu(String nom, int idAdresse, String description, String accessibilite) throws SQLException {
		this.nom = nom;
		this.adresse = new Adresse(idAdresse);
		this.setDescription(description);
		this.setAccessibilite(accessibilite);
	}

	// Constructeur d'un lieu correspondant à partir d'un identifiant
	public Lieu(int idL) throws SQLException{
		idLieu = idL;
		// Connexion à la base de données postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		// Requete à executer
		String query = "SELECT nom, idadresse, description, accessibilite "
				+ "FROM lieux "
				+ "WHERE idlieu = " + idLieu + " ; ";
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			nom = rs.getString("nom");
			idAdresse = rs.getInt("idadresse");
			description = rs.getString("description");
			accessibilite = rs.getString("accessibilite");		
		} else {
			throw new SQLException();
		}
		
		
	}

	// Rentre un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int save(Connection cnx) throws Exception {
		String query = " INSERT INTO lieux(nom,idAdresse,description,accessibilite) VALUES (?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, nom);
		ps.setInt(2, idAdresse);
		ps.setString(3, description);
		ps.setString(4, accessibilite);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idLieu = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idLieu;
	}

	// Modifie un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int update(Connection cnx, String nom, int idAdresse,
			String description, String accessibilite) throws SQLException {
		String query = " UPDATE lieux  SET nom=?, idadresse=?, description=?, accessibilite=? "
				+ " WHERE idlieu=" + idLieu;
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, nom);
		ps.setInt(2, idAdresse);
		ps.setString(3, description);
		ps.setString(4, accessibilite);
		return ps.executeUpdate();
	}

	// Supprime un lieu dans la base de donnée
	// Prend en paramètre une connection (synchronisation entre les classes
	// métiers)
	public int delete(Connection cnx) throws SQLException {
		String query = "DELETE FROM lieux" + " WHERE idlieu= " + idLieu;
		PreparedStatement ps = cnx.prepareStatement(query);
		return ps.executeUpdate();
	}

	// Renvoie le contenu d'un lieu (pour vérif')
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Le Lieu s'appelle" + nom);
		sb.append("Il se trouve au" + adresse.toString());
		sb.append("Il a une description"
				+ ((description == "") ? "VRAI" : "FAUX"));
		sb.append("Son accessibilité est décrite"
				+ ((accessibilite == "") ? "VRAI" : "FAUX"));
		return sb.toString();
	}

	// Liste des Lieux
	private static List<Lieu> listeDesLieux;
	public static List<Lieu> getListeDesLieux() throws SQLException {
		listeDesLieux = new ArrayList<Lieu>();
		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT nom, idadresse, description, accessibilite "
				+ "FROM lieux " ;
		// obtention de l'ensemble resultat
		ResultSet rs = stmt.executeQuery(query);// rs demande les valeur pour un ligne, ligne par ligne
		while (rs.next()) {
			Lieu l = new Lieu();
			l.idLieu = rs.getInt("idlieu");
			l.nom = rs.getString("nom");
			l.adresse = new Adresse(rs.getInt("idadresse"));
			l.description = rs.getString("description");
			l.accessibilite = rs.getString("accessibilite");
			listeDesLieux.add(l);
		}
		return listeDesLieux;
	}
	
	
	//Liste des avis pour un seul lieu
	private List<Avis> listeDesAvisDunLieu;
	
	public List<Avis> getListeDesAvisDunLieu() throws SQLException {
		listeDesAvisDunLieu = new ArrayList<Avis>();
		// connexion à la BDD PostGresSQL
		Connection cnx = null;
		cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		
		// Requête à exécuter
		String queryAvis = "SELECT pseudo, note, message FROM avis "
        		+ "INNER JOIN lieux USING (idlieu) "
        		+ "INNER JOIN utilisateurs USING (idutilisateur) "
        		+ "WHERE idlieu =" +idLieu ;
    
		// Obtention de l'ensemble résultat
		ResultSet rs = stmt.executeQuery(queryAvis);
		
		while(rs.next()){
			Avis a = new Avis(); 
			a.setNote(rs.getInt("note"));
			a.setMessage (rs.getString("message"));
			a.setPseudo (rs.getString("pseudo"));
			
			listeDesAvisDunLieu.add(a);
		}
		
		return listeDesAvisDunLieu;
	}

	// Setters And Getters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAccessibilite() {
		return accessibilite;
	}
	public void setAccessibilite(String accessibilite) {
		this.accessibilite = accessibilite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdLieu() {
		return idLieu;
	}

	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public static void setListeDesLieux(List<Lieu> listeDesLieux) {
		Lieu.listeDesLieux = listeDesLieux;
	}
	
}
