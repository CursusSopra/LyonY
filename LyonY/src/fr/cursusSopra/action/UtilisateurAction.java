package fr.cursusSopra.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JRadioButton;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Adresse;
import fr.cursusSopra.model.Quartier;
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
		
	private Adresse adresse;
	private int numero;
	private String voie;
	private String codePostal;
	private String ville;
	// Pour normaliser vers la classe métier
	private int idQuartier;
	// Le champ normalisé avec la JSP
	private int quartier;	

	private List<Quartier> listeDesQuartiers;
	
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}

	
	/* Création d'un compte utilisateur Candidat */
/* ================================================================================================ */
	public String execute() {

		try {
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String executeCreation() throws SQLException {
		Connection cnx = PostgresConnection.getConnexion();

		Utilisateur uti = new Utilisateur();
		uti.setPseudo(pseudo);
		uti.setMotDePasse(motDePasse);
		uti.setEmail(email);
		uti.setAvatar(avatar);
		uti.setSexe(sexe);
		
		try {
			// On se met en mode 'transaction'
			cnx.setAutoCommit(false);
			
			uti.setDateNaissance(new SimpleDateFormat("yyyy-MM-dd")
					.parse(dateNaissance));
			
			System.out.println("av création adresse" + numero + idQuartier);
			adresse = new Adresse(numero, voie, codePostal, ville, idQuartier);
			int idAdresse = adresse.save(cnx);
			
			uti.setIdadresse(idAdresse);			
			uti.create(cnx);		

			return SUCCESS;			
		} catch (ParseException e) {
			e.printStackTrace();
			return ERROR;
		} catch (Exception e) {
			try {
				cnx.rollback();
				e.printStackTrace();
				return ERROR;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// On remet en mode 'auto-commit'
				cnx.setAutoCommit(true);
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ERROR;		
	}

	/* Fin de création */
/* ================================================================================================ */
	
	/* Connection au compte utilisateur */
/* ================================================================================================ */
	public String executeConnexion() {
		Connection cnx = PostgresConnection.getConnexion();
		Utilisateur uti = new Utilisateur();
		uti.setPseudo(pseudo);
		uti.setMotDePasse(motDePasse);
		try {
			if (uti.checkExists(cnx)) {
				this.email = uti.getEmail();
				this.idUtilisateur = uti.getIdUtilisateur();
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
/* ================================================================================================ */
	
	/* Supression du compte */
/* ================================================================================================ */
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
/* ================================================================================================ */

	/* Modification du compte */
/* ================================================================================================ */

	public String modification() {

		try {
			Utilisateur uti = new Utilisateur();
			uti.setPseudo(pseudo);
			uti.detailsModif();
			email = uti.getEmail();
			motDePasse = uti.getMotDePasse();
			avatar = uti.getAvatar();
			idUtilisateur = uti.getIdUtilisateur();
			
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			adresse = uti.getAdresse();
//			numero = uti.getNumero();
//			voie = uti.getVoie();
//			ville = uti.getVille();
//			codePostal = uti.getCodePostal();
//			idadresse = uti.getIdadresse();
//			idQuartier = uti.getIdQuartier();
			
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

		/*try {
			return uti.modif(cnx) != 0 ? SUCCESS : ERROR;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;*/
		
		try {
			// On se met en mode 'transaction'
			cnx.setAutoCommit(false);
			
			adresse = new Adresse(numero, voie, codePostal, ville, idQuartier);
			int idAdresse = adresse.update(cnx, numero, voie, codePostal, ville, idQuartier);
			
			uti.setIdadresse(idAdresse);			
			uti.modif(cnx, idUtilisateur, email, avatar, pseudo, motDePasse, idadresse);		

			return SUCCESS;			
		} catch (Exception e) {
			try {
				cnx.rollback();
				//e.printStackTrace();
				return ERROR;
			} catch (SQLException e1) {
				//e1.printStackTrace();
			}
		} finally {
			try {
				// On remet en mode 'auto-commit'
				cnx.setAutoCommit(true);
				cnx.close();
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		}
		return ERROR;
	}
	
	
	/* Fin de modification du compte */
/* ================================================================================================ */
	
	// Liste des avis
/* ================================================================================================ */
	public String executeDisplayAvis() {

		Utilisateur uti = new Utilisateur();
		uti.setIdUtilisateur(idUtilisateur);
		uti.setPseudo(pseudo);

		try {
			return uti.getListeDesAvis().size() != 0 ? SUCCESS : ERROR;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	 
	
	// Get-Set
/* ================================================================================================ */
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
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
	public int getQuartier() {
		return quartier;
	}
	public void setQuartier(int quartier) {
		this.quartier = idQuartier = quartier;
	}
	 
}