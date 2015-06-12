package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import fr.cursusSopra.tech.PostgresConnection;

public class Utilisateur {
	
	private int idUtilisateur;
	private String pseudo;
	private Date dateNaissance;
	private String motDePasse;
	private boolean sexe;
	private String email;
	private int idadresse;
	private String avatar;
	
	
	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	public boolean isSexe() {
		return sexe;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAvatar() {
		return avatar;
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

	
	public Utilisateur() {
	}
	
	public int create (Connection cnx) throws SQLException {
		
		String query = "INSERT INTO utilisateurs (pseudo, sexe, email, avatar, motdepasse) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);
		//ps.setDate(2,  new java.sql.Date(dateNaissance.getTime()));
		ps.setBoolean(2, sexe);
		ps.setString(3, email);
		ps.setString(4, avatar);
		ps.setString(5, motDePasse);
		
		return ps.executeUpdate();
		
	}
	
	public boolean checkExists(Connection cnx) throws SQLException{
		
		String query = "SELECT pseudo, motdepasse, email FROM utilisateurs WHERE pseudo=? AND motdepasse=?";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);
		ps.setString(2, motDePasse);
		ps.execute();
		ResultSet rs= ps.getResultSet();
		if(rs.next()) {
			this.email=rs.getString("email");
			return true;
		}
		return false;
	}

}
