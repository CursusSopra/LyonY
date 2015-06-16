package fr.cursusSopra.model;

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
	
//	public Avis(String message) {
//		this.message = message;
//	}
	
	
}
