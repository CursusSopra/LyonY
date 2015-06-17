package fr.cursusSopra.model;

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
	
}
