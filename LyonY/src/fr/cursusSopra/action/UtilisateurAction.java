package fr.cursusSopra.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Utilisateur;
import fr.cursusSopra.tech.PostgresConnection;

public class UtilisateurAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private int idUtilisateur;
	private String pseudo;
	private String dateNaissance;
	private String motDePasse;
	private boolean sexe;
	private String email;
	private int idadresse;
	private String avatar;
	

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAvatar() {
		return avatar;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
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
	public boolean isSexe() {
		return sexe;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	public String executeCreation(){
		Connection cnx = PostgresConnection.getConnexion();
		
		Utilisateur uti = new Utilisateur();
		uti.setPseudo(pseudo);
		uti.setMotDePasse(motDePasse);
		uti.setEmail(email);
		uti.setAvatar(avatar);
		uti.setSexe(sexe);
		
		try {
			//uti.setDateNaissance(new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissance));
			return uti.create(cnx) != 0 ? SUCCESS : ERROR;
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		 }

			//		 catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return ERROR;
//		}
	}
	
	public String executeConnexion(){
		Utilisateur uti = new Utilisateur();
		
		return SUCCESS;
	}
}