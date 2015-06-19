package fr.cursusSopra.action.sorties;

import java.sql.Connection;

import fr.cursusSopra.action.general.ActionGeneral;
import fr.cursusSopra.model.Ambiance;
import fr.cursusSopra.model.Typevisite;
import fr.cursusSopra.tech.PostgresConnection;

public class ManageAmbianceAction extends ActionGeneral {

	private static final long serialVersionUID = 1L;

	private int idAmbiance;
	private String types;
	private String libambiance;
	private Ambiance ambiance;
	
	// GETSETS
	public int getIdAmbiance() {
		return idAmbiance;
	}
	public void setIdAmbiance(int idAmbiance) {
		this.idAmbiance = idAmbiance;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getLibambiance() {
		return libambiance;
	}
	public void setLibambiance(String libambiance) {
		this.libambiance = libambiance;
	}
	public Ambiance getAmbiance() {
		return ambiance;
	}
	public void setAmbiance(Ambiance ambiance) {
		this.ambiance = ambiance;
	}
	
	// METHODES PUBLIQUES

	// CREATION
	public String executeCreationAmbiance(){
		Connection cnx = PostgresConnection.getConnexion();

		try {
			ambiance = new Ambiance(types, libambiance);
			idAmbiance = ambiance.save(cnx);
			return idAmbiance == 0 ? ERROR : SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
}
