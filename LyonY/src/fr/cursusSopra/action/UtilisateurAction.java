package fr.cursusSopra.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButton;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Utilisateur;
import fr.cursusSopra.tech.PostgresConnection;

public class UtilisateurAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int idUtilisateur;
	private String pseudo;
	private String dateNaissance;
	private String motDePasse;
	private String sexe;
	private String email;
	private int idadresse;
	private String avatar;
	private JRadioButton male;

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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String execute() {
		return SUCCESS;
	}

	/* Création d'un compte utilisateur Candidat */
	/*
	 * ==========================================================================
	 * ======================
	 */
	public String executeCreation() {
		Connection cnx = PostgresConnection.getConnexion();

		Utilisateur uti = new Utilisateur();
		uti.setPseudo(pseudo);
		uti.setMotDePasse(motDePasse);
		uti.setEmail(email);
		uti.setAvatar(avatar);
		uti.setSexe(sexe);

		try {
			uti.setDateNaissance(new SimpleDateFormat("yyyy-MM-dd")
					.parse(dateNaissance));
			return uti.create(cnx) != 0 ? SUCCESS : ERROR;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}

		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}

	/* Fin de création */
	/*
	 * ==========================================================================
	 * ======================
	 */

	/* Connection au compte utilisateur */
	/*
	 * ==========================================================================
	 * ======================
	 */
	public String executeConnexion() {
		Connection cnx = PostgresConnection.getConnexion();
		Utilisateur uti = new Utilisateur();
		uti.setPseudo(pseudo);
		uti.setMotDePasse(motDePasse);
		try {
			if (uti.checkExists(cnx)) {
				this.email = uti.getEmail();
				return SUCCESS;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}

		return "erreurIdentification";
	}

	/* Fin de connection */
	/*
	 * ==========================================================================
	 * ======================
	 */

	/* Supression du compte */
	/*
	 * ==========================================================================
	 * ======================
	 */
	public String executeDemandeSuppression() {
		Utilisateur uti = new Utilisateur();
		uti.setIdadresse(idUtilisateur);
		uti.setPseudo(pseudo);
		uti.setPseudo(motDePasse);
		uti.setPseudo(email);
		uti.setPseudo(avatar);
		return SUCCESS;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String executeSuppression() {
		Connection cnx = PostgresConnection.getConnexion();
		Utilisateur uti = new Utilisateur();
		uti.setPseudo(pseudo);
		try {
			uti.delete(cnx);
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	/* Fin de supression */
	/*
	 * ==========================================================================
	 * ======================
	 */

	/* Modification du compte */
	/*
	 * ==========================================================================
	 * ======================
	 */

	public String modification() {

		try {
			Utilisateur uti = new Utilisateur();
			uti.setPseudo(pseudo);
			uti.detailsModif();
			email = uti.getEmail();
			motDePasse = uti.getMotDePasse();
			avatar = uti.getAvatar();
			idUtilisateur = uti.getIdUtilisateur();
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}

	public String executeModif() {
		Connection cnx = PostgresConnection.getConnexion();

		Utilisateur uti = new Utilisateur();
		uti.setIdUtilisateur(idUtilisateur);
		uti.setPseudo(pseudo);
		uti.setAvatar(avatar);
		uti.setMotDePasse(motDePasse);
		uti.setEmail(email);

		try {
			return uti.modif(cnx) != 0 ? SUCCESS : ERROR;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/* Fin de modification du compte */
	/*
	 * ==========================================================================
	 * ======================
	 */
}