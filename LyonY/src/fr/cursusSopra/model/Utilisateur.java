package fr.cursusSopra.model;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
	
//	public String gestionSexe (JRadioButton male){
//		if (male.isSelected()) {
//			sexe = "M";
//		} else {
//			sexe = "F";
//		}
//		return sexe;
//	}
	

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

	
	public Utilisateur() {
	}
	
	public int create (Connection cnx) throws SQLException {
		
		String query = "INSERT INTO utilisateurs (pseudo, datenaissance, sexe, email, avatar, motdepasse) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);
		ps.setDate(2,  new java.sql.Date(dateNaissance.getTime()));
		ps.setString(3, sexe);
		ps.setString(4, email);
		ps.setString(5, avatar);
		ps.setString(6, motDePasse);
		
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
	
	public int delete(Connection cnx) throws SQLException{
		
		String query="DELETE FROM utilisateurs WHERE pseudo=?";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);
		
		return ps.executeUpdate();
	}
	
	public int modif(Connection cnx) throws SQLException {
		
		String query = "UPDATE utilisateurs SET pseudo=?, email=?, avatar=?, motdepasse=?  WHERE idcandidat=?";
		
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setString(1, pseudo);
		ps.setString(2, email);
		ps.setString(3, avatar);
		ps.setString(4, motDePasse);
				
		return ps.executeUpdate();
	}
}
