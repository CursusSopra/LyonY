package fr.cursusSopra.action.visites;

import java.sql.Connection;

import fr.cursusSopra.action.general.ActionGeneral;
import fr.cursusSopra.model.Adresse;
import fr.cursusSopra.model.Typevisite;
import fr.cursusSopra.tech.PostgresConnection;

public class ManageTypevisiteAction extends ActionGeneral {

	private static final long serialVersionUID = 1L;

	private int idTypevisite;
	private String typev;
	private String libtypevisite;
	private Typevisite typevisite;
	
	// GETSETS
	public int getIdTypevisite() {
		return idTypevisite;
	}
	public void setIdTypevisite(int idTypevisite) {
		this.idTypevisite = idTypevisite;
	}
	public String getTypev() {
		return typev;
	}
	public void setTypev(String typev) {
		this.typev = typev;
	}
	public String getLibtypevisite() {
		return libtypevisite;
	}
	public void setLibtypevisite(String libtypevisite) {
		this.libtypevisite = libtypevisite;
	}
	public Typevisite getTypevisite() {
		return typevisite;
	}
	public void setTypevisite(Typevisite typevisite) {
		this.typevisite = typevisite;
	}
	
	// METHODES PUBLIQUES

	// CREATION
	public String executeCreationTypevisite(){
		Connection cnx = PostgresConnection.getConnexion();

		try {
			typevisite = new Typevisite(typev, libtypevisite);
		
			return typevisite.save(cnx) == 0 ? ERROR : SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}

}
