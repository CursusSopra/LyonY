package fr.cursusSopra.action.visites;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.model.Adresse;
import fr.cursusSopra.model.Lieu;
import fr.cursusSopra.model.Monument;
import fr.cursusSopra.model.Placeetparc;
import fr.cursusSopra.model.Quartier;
import fr.cursusSopra.model.Typevisite;
import fr.cursusSopra.model.Visite;
import fr.cursusSopra.tech.Breadcrumbs;
import fr.cursusSopra.tech.PostgresConnection;

public class ManagePlaceetparcAction extends VisitesAction {

	private static final long serialVersionUID = 1L;
	
	private int idPlaceetparc;
	private Placeetparc placeetparc;
	private Visite visite;
	private Lieu lieu;
	private Adresse adresse;
	private List<Quartier> listeDesQuartiers;
	private List<Typevisite> listeDesTypevisites;

	private int idQuartier;
	private int numero;
	private String voie;
	private int codePostal;
	private String ville;
	private String nomL;
	private String description;
	private String accessibilite;
	private int idTypevisite;
	private boolean avecFontaine;
	
	//GET SETS
	public int getIdPlaceetparc() {
		return idPlaceetparc;
	}
	public void setIdPlaceetparc(int idPlaceetparc) {
		this.idPlaceetparc = idPlaceetparc;
	}
	public Placeetparc getPlaceetparc() {
		return placeetparc;
	}
	public void setPlaceetparc(Placeetparc placeetparc) {
		this.placeetparc = placeetparc;
	}
	public Visite getVisite() {
		return visite;
	}
	public void setVisite(Visite visite) {
		this.visite = visite;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<Quartier> getListeDesQuartiers() {
		return listeDesQuartiers;
	}
	public void setListeDesQuartiers(List<Quartier> listeDesQuartiers) {
		this.listeDesQuartiers = listeDesQuartiers;
	}
	public List<Typevisite> getListeDesTypevisites() {
		return listeDesTypevisites;
	}
	public void setListeDesTypevisites(List<Typevisite> listeDesTypevisites) {
		this.listeDesTypevisites = listeDesTypevisites;
	}
	
	public int getIdQuartier() {
		return idQuartier;
	}
	public void setIdQuartier(int idQuartier) {
		this.idQuartier = idQuartier;
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
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNomL() {
		return nomL;
	}
	public void setNomL(String nomL) {
		this.nomL = nomL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccessibilite() {
		return accessibilite;
	}
	public void setAccessibilite(String accessibilite) {
		this.accessibilite = accessibilite;
	}
	public int getIdTypevisite() {
		return idTypevisite;
	}
	public void setIdTypevisite(int idTypevisite) {
		this.idTypevisite = idTypevisite;
	}
	public boolean isAvecFontaine() {
		return avecFontaine;
	}
	public void setAvecFontaine(boolean avecFontaine) {
		this.avecFontaine = avecFontaine;
	}
	
	//CTOR
	public ManagePlaceetparcAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Visites", "visites", null));
		listeBreadcrumbs.add(new Breadcrumbs("Places et parcs", "listeDesPlaceetparcs", null));
	}

	//METHODES PUBLIQUES
	// INITIALISATION FORMULAIRE CREATION
	public String execute() {
		try {
			listeDesQuartiers = Quartier.getListeDesQuartiers();
			listeDesTypevisites = Placeetparc.getListeDesTypevisitesDePlaceetparc();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	// DETAILS
	public String executeDetailsPlaceetparc(){
		
		try {
			placeetparc = new Placeetparc(idPlaceetparc);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();			
			return 	ERROR;
		}
	}
	
	// CREATION
	public String executeCreationPlaceetparc(){
		Connection cnx = PostgresConnection.getConnexion();
		
		try {
			adresse = new Adresse(numero, voie, codePostal, ville, idQuartier);
			int idAdresse = adresse.save(cnx);
			
			lieu = new Lieu(nomL, idAdresse, description, accessibilite);
			int idLieu = lieu.save(cnx);
			
			visite = new Visite(idLieu, idTypevisite);
			int idVisite = visite.save(cnx);
			
			placeetparc = new Placeetparc(idVisite, avecFontaine);
			
			return placeetparc.save(cnx) == 0 ? ERROR : SUCCESS ;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	// MODIFICATION
	public String executeFormModifPlaceetparc(){

			try {
				listeDesQuartiers = Quartier.getListeDesQuartiers();
				listeDesTypevisites = Placeetparc.getListeDesTypevisitesDePlaceetparc();
				placeetparc = new Placeetparc(idPlaceetparc);
				return SUCCESS;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ERROR;
			}

	}
	
	public String executeModifPlaceetparc(){

		return SUCCESS;
	}
	

}
