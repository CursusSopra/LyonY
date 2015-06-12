package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Sortie {
	
	public static List<Horaire> listeDesHorairesDuneSortie;

	// Recupère les 7 horaires d'un bar
	public static List<Horaire> getListeDesHorairesDuneSortie(int idSortie) throws SQLException {
		listeDesHorairesDuneSortie = new ArrayList<Horaire>();
		// Connexion à la base de données postgreSQL
		Connection cnx = PostgresConnection.getConnexion();
		// Objet instruction SQL
		Statement stmt = cnx.createStatement();
		
		// Requête à exécuter
		String query = "SELECT jour, heuredebut, heurefin "
				+ "FROM ouvertures "
				+ 	"INNER JOIN horaires "
				+ 		"ON horaires.idhoraire = ouvertures.idhoraire "
				+ 	"INNER JOIN plagehoraires "
				+ 		"ON horaires.idplagehoraire = plagehoraires.idplagehoraire "
				+ "WHERE idsortie ="
				+ idSortie;

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Horaire h = new Horaire();
			h.setJour(rs.getString("jour"));
			h.getPlageHoraire().setHeureDebut(rs.getDate("heuredebut"));
			h.getPlageHoraire().setHeureFin(rs.getDate("heureFin"));
			
			listeDesHorairesDuneSortie.add(h);						
		}
			
			return listeDesHorairesDuneSortie;
			
	}
	

}
