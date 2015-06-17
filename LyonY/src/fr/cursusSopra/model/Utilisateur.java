package fr.cursusSopra.model;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JRadioButton;

import fr.cursusSopra.tech.PostgresConnection;

public class Utilisateur {

	private int idUtilisateur;
	private String pseudo;
	private Date dateNaissance;
	private String motDePasse;
	private String sexe;
	private String email;
	private int idadresse;
	private String avatar;
	private JRadioButton male;
	private int idQuartier;

	public Utilisateur() {
	}

	/* Création d'un compte utilisateur Candidat */
/* =================================================================================== */
	public boolean create(Connection cnx) {

		String query = "INSERT INTO utilisateurs (pseudo, datenaissance, sexe, email, avatar, motdepasse, idadresse) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = cnx.prepareStatement(query);
			ps.setString(1, pseudo);
			ps.setDate(2, new java.sql.Date(dateNaissance.getTime()));
			ps.setString(3, sexe);
			ps.setString(4, email);
			ps.setString(5, avatar);
			ps.setString(6, motDePasse);
			ps.setInt(7, idadresse);

			ps.executeUpdate();

			return true;

		} catch (SQLIntegrityConstraintViolationException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	/* Vérification si le pseudo est déjà uitilisé */
/* =================================================================================== */
	public boolean checkExists(Connection cnx) throws SQLException {

		String query = "SELECT pseudo, motdepasse, email, idutilisateur FROM utilisateurs WHERE pseudo=? AND motdepasse=?";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);
		ps.setString(2, motDePasse);
		ps.execute();
		ResultSet rs = ps.getResultSet();
		if (rs.next()) {
			this.email = rs.getString("email");
			this.idUtilisateur = rs.getInt("idutilisateur");
			return true;
		}
		return false;
	}

	/* Supression du compte */
/* =================================================================================== */
	public int delete(Connection cnx) throws SQLException {

		String query = "DELETE FROM utilisateurs WHERE pseudo=?";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);

		return ps.executeUpdate();
	}

	/* Modification du compte */
/* =================================================================================== */
	public int modif(Connection cnx) throws SQLException {

		String query = "UPDATE utilisateurs SET pseudo=?, email=?, avatar=?, motdepasse=?  WHERE idutilisateur=?";

		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);
		ps.setString(2, email);
		ps.setString(3, avatar);
		ps.setString(4, motDePasse);
		ps.setInt(5, idUtilisateur);

		return ps.executeUpdate();
	}

	/* Liste des utilisateurs */
/* =================================================================================== */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public static void setListeDesUtilisateurs(
			List<Utilisateur> listeDesUtilisateurs) {
		Utilisateur.listeDesUtilisateurs = listeDesUtilisateurs;
	}
	
	private static List<Utilisateur> listeDesUtilisateurs;

	public static List<Utilisateur> getListeDesUtilisateurs()
			throws SQLException {
		listeDesUtilisateurs = new ArrayList<Utilisateur>();
		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		Statement stmt = cnx.createStatement();
		// requete à executer
		String query = "SELECT (idutilisateur, pseudo, datenaissance, sexe, email, avatar, motdepasse) "
				+ "FROM utilisateurs";
		// obtention de l'ensemble resultat
		ResultSet rs = stmt.executeQuery(query);// rs demande les valeur pour un
												// ligne, ligne par ligne
		while (rs.next()) {
			Utilisateur u = new Utilisateur();
			u.idUtilisateur = rs.getInt("idutilisateur");
			u.pseudo = rs.getString("pseudo");
			u.dateNaissance = rs.getDate("datenaissance");
			u.sexe = rs.getString("sexe");
			u.avatar = rs.getString("avatar");
			u.motDePasse = rs.getString("motdepasse");
			listeDesUtilisateurs.add(u);
		}
		return listeDesUtilisateurs;
	}

	/* Modification du compte
/* =================================================================================== */
	public void detailsModif() throws SQLException {
		// Connexion à la base de données postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// requête SQL
		String query = "SELECT idutilisateur, email, motdepasse, avatar "
				+ "FROM utilisateurs " + "WHERE pseudo=?";
		// System.out.println(query);
		// Obtention de l'ensemble résultat
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			this.idUtilisateur = rs.getInt("idutilisateur");
			this.email = rs.getString("email");
			this.motDePasse = rs.getString("motdepasse");
			this.avatar = rs.getString("avatar");
		}
	}

	/* Liste des avis */
/* =================================================================================== */
	private List<Avis> listeDesAvis;

	public List<Avis> getListeDesAvis() throws SQLException {
		listeDesAvis = new ArrayList<Avis>();
		// connexion a la base de donnees postgresSQL
		Connection cnx = PostgresConnection.getConnexion();
		// objet instruction SQL
		try {
			Statement stmt = cnx.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// requete à executer
		String query = "SELECT message "
				+ "FROM utilisateurs "
				+ "INNER JOIN avis USING (idUtilisateur) "
				+ "WHERE idutilisateur = ?";
		// obtention de l'ensemble resultat
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, idUtilisateur);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Avis a = Avis(rs.getString("message"));
			listeDesAvis.add(a);
			System.out.println("un avis");
		}
		return listeDesAvis;
	}

	private Avis Avis(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Get-Set
/* =================================================================================== */
	public JRadioButton getMale() {
		return male;
	}
	public void setMale(JRadioButton male) {
		this.male = male;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAvatar() {
		return avatar;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdadresse() {
		return idadresse;
	}
	public void setIdadresse(int idadresse) {
		this.idadresse = idadresse;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public int getIdQuartier() {
		return idQuartier;
	}
	public void setIdQuartier(int idQuartier) {
		this.idQuartier = idQuartier;
	}

}
