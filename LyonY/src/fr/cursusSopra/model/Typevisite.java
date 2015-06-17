package fr.cursusSopra.model;

public class Typevisite {
	
	private int idTypevisite;
	private String typev;
	private String libtypevisite;
	
	
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
	
	// CTOR
	public Typevisite(){
		
	}
	public Typevisite (String typev, String libtypevisite) {
		this.typev = typev;
		this.libtypevisite = libtypevisite;
	}
}
