package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.cursusSopra.tech.PostgresConnection;

public class Visite {
	
	private int idVisite;
	private int idLieu;
	private int idTypevisite;
	
	// GETSETS
	public int getIdVisite() {
		return idVisite;
	}
	public void setIdVisite(int idVisite) {
		this.idVisite = idVisite;
	}
	public int getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}
	public int getIdTypevisite() {
		return idTypevisite;
	}
	public void setIdTypevisite(int idTypevisite) {
		this.idTypevisite = idTypevisite;
	}
	
	// CTOR
	public Visite(){
		
	}
	
	public Visite(int idv) throws SQLException{
		idVisite = idv;
        // connexion à la BDD PostGresSQL
        Connection cnx = PostgresConnection.getConnexion();
        // Objet instruction SQL
        Statement stmt = cnx.createStatement();
        // Requête à exécuter
        String query  = "SELECT idlieu, idtypevisite "
        	+ "FROM visites "
    		+ "WHERE idvisite= "  + idVisite +";";
	    // Obtention de l'ensemble résultat
	    ResultSet rsV = stmt.executeQuery(query);
	    // Parcourt l'ensemble des résultats et crée objets candidats puis màj la liste
	    if(rsV.next()){
	        idLieu = rsV.getInt("idlieu");
	        idTypevisite = rsV.getInt("idtypevisite");
	    }
	}
	
	public Visite(int idLieu, int idTypevisite) {
		this.idLieu = idLieu;
		this.idTypevisite = idTypevisite;
	}
	
	// METHODES PUBLIQUES
	public int save(Connection cnx) throws Exception {
		String query = " INSERT INTO visites (idlieu,idtypevisite) VALUES (?,?)";
		PreparedStatement ps = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idLieu);
		ps.setInt(2, idTypevisite);
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			idVisite = rs.getInt(1);
		} else {
			throw new Exception();
		}
		return idVisite;
	}
	
	public int update(Connection cnx, int idTypevisite) throws Exception {
		String query = "UPDATE visites SET idtypevisite=? WHERE idvisite=" + idVisite + ";";
		PreparedStatement ps = cnx.prepareStatement(query);
		ps.setInt(1, idTypevisite);
		
		return ps.executeUpdate();
	}
	
}
