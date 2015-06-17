package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.sun.jndi.ldap.Connection;

public class Avis {
	
	private float note;
	private String message;
	private String pseudo;
	private int idUtilisateur;
	private int idLieu;
	private int idAvis;
	
	// GETSETS
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}
	public int getIdAvis() {
		return idAvis;
	}
	public void setIdAvis(int idAvis) {
		this.idAvis = idAvis;
	}
	
	// CTOR
	public Avis(){
	}
	
    public Avis(int idLieu, float note,  String message, int idUtilisateur) {
    	this.idLieu = idLieu;
    	this.note=note;
    	this.message =message;
    	this.idUtilisateur=idUtilisateur;
    }
	
    //Methodes publiques 

    public int save(Connection cnx) throws Exception{
		String queryAvis = "INSERT INTO avis (idlieu, note, message, idutilisateur) VALUES (?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(queryAvis, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idLieu);
		ps.setFloat(2, note);
		ps.setString(3, message);
		ps.setInt(4, idUtilisateur);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idAvis = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idAvis;
	
	}
	
	
//	public Avis(String message) {
//		this.message = message;
//	}
	
	
}
