package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Sortie {
	protected int idSortie;	
	
	public static List<Horaire> listeDesHoraires;

	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}

	// Recupère les 7 horaires d'une sortie
	public List<Horaire> getListeDesHoraires() throws SQLException {
		listeDesHoraires = new ArrayList<Horaire>();
		// Connexion à la base de données postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		
		// Requête à exécuter
		String query = "SELECT jour, heuredebut, heurefin "
				+ "FROM ouvertures "
				+ 	"INNER JOIN horaires USING(idhoraire) "
				+ 	"INNER JOIN plagehoraires  USING(idplagehoraire) "
				+ "WHERE idsortie ="
				+ idSortie;

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Horaire h = new Horaire();
			PlageHoraire ph = new PlageHoraire();
			h.setJour(rs.getString("jour"));			
			h.setPlageHoraire(ph);
			ph.setHeureDebut(rs.getTime("heuredebut"));			
			ph.setHeureFin(rs.getTime("heureFin"));
			
			listeDesHoraires.add(h);	
		}
			
		return listeDesHoraires;			
	}
}
