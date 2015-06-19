package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
    // METHODES PUBLIQUES
	public int save(Connection cnx) throws Exception {
		String query = " INSERT INTO typevisites (typev, libtypevisite) VALUES (?,?)";
		PreparedStatement ps = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, typev);
		ps.setString(2, libtypevisite);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idTypevisite = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idTypevisite;
	}
}
