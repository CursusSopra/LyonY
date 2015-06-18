package fr.cursusSopra.action;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Avis;
import fr.cursusSopra.tech.PostgresConnection;

public class AvisAction extends ActionSupport{
	

	private static final long serialVersionUID = 1L;
	
	private float note;
	private String message;
	private int idUtilisateur;
	private int idLieu;
	private int idAvis;
	private Avis avis;
	
	//Getter & Setter
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
	public Avis getAvis() {
		return avis;
	}
	public void setAvis(Avis avis) {
		this.avis = avis;
	}
	
	//Methodes executes
	public String executeFormCreationAvis(){
		return SUCCESS;
		
	}
	
	public String executeCreationAvis(){
	
			Connection cnx = PostgresConnection.getConnexion();

			avis = new Avis(idLieu, note, message);
		
			try {
				return avis.save(cnx) == 0 ? ERROR : SUCCESS ;
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}	
		
	}
	

}
