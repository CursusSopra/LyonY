package fr.cursusSopra.model;

public class Utilisateur {
	
	private int idUtilisateur;
	private String pseudo;
	private String motDePasse;
	private String nom;
	private String prenom;
	private boolean sexe;
	private String email;
	private String avatar;
	
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
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public boolean isSexe() {
		return sexe;
	}
	
	

}
