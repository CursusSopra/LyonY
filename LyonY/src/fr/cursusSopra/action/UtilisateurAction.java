package fr.cursusSopra.action;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Utilisateur;

public class UtilisateurAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private int idUtilisateur;
	private String pseudo;
	private String motDePasse;
	private String nom;
	private String prenom;
	private boolean sexe;
	private String email;
	private String avatar;
	
	public int getIdUtilisateur() {
		return idUtilisateur;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public boolean isSexe() {
		return sexe;
	}
	public String getMail() {
		return email;
	}
	public void setMail(String mail) {
		this.email = mail;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String nouvelUtilisateur () {
		Utilisateur uti = new Utilisateur();
		return "nimportequoi";
		
	}
	
	public String executeCreation(){
		return SUCCESS;
	}
	
	public String executeConnexion(){
		Utilisateur uti = new Utilisateur();
		
		return SUCCESS;
	}

}