package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ambiance {
	
	private int idAmbiance;
	private String types;
	private String libambiance;
	
///////////Getters & Setters///////////////

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
	
	public int getIdAmbiance() {
		return idAmbiance;
	}
	public void setIdAmbiance(int idAmbiance) {
		this.idAmbiance = idAmbiance;
	}
	
	
		// CTOR
		public Ambiance(){
			
		}
		
		public Ambiance (String types, String libambiance) {
			this.types = types;
			this.libambiance = libambiance;
		}
		
	    // METHODES PUBLIQUES
		public int save(Connection cnx) throws Exception {
			String query = " INSERT INTO ambiances (types, libambiance) VALUES (?,?)";
			PreparedStatement ps = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, types);
			ps.setString(2, libambiance);
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				idAmbiance = rs.getInt(1);
			} else {
				throw new Exception();
			}
			return idAmbiance;
		}
}
