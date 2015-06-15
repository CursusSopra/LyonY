package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.cursusSopra.tech.PostgresConnection;

public class Sortie {
	protected int idSortie;	
	
	public static List<Horaire> listeDesHorairesDuneSortie;
	private ArrayList<String> listeDesHorairesDuneSortieEnString;
	public String jourString;
	public String heureDebutString;
	public String heureFinString;	


	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}

	// Recupère les 7 horaires d'un bar
	public List<Horaire> getListeDesHorairesDuneSortie() throws SQLException {
		listeDesHorairesDuneSortie = new ArrayList<Horaire>();
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
			h.setJour(rs.getString("jour"));
			h.getPlageHoraire().setHeureDebut(rs.getTime("heuredebut"));
			h.getPlageHoraire().setHeureFin(rs.getTime("heureFin"));
			
			listeDesHorairesDuneSortie.add(h);						
		}
			
		return listeDesHorairesDuneSortie;			
	}

	
//	Formate les 7 horaires d'un bar en mettant les heures de début et heures de fin en String
	public List<String> getListeDesHorairesDuneSortieEnString() throws SQLException {

		DateFormat df = new SimpleDateFormat("HH:mm");
		
		listeDesHorairesDuneSortie = getListeDesHorairesDuneSortie();
		listeDesHorairesDuneSortieEnString = new ArrayList<String>();
		
		for (int i = 0; i < listeDesHorairesDuneSortie.size(); i++) {
			
			jourString = listeDesHorairesDuneSortie.get(i).getJour();				
			listeDesHorairesDuneSortieEnString.add(jourString);
			
			heureDebutString = df.format(listeDesHorairesDuneSortie.get(i).getPlageHoraire().getHeureDebut());
			listeDesHorairesDuneSortieEnString.add(heureDebutString);
			
			heureFinString = df.format(listeDesHorairesDuneSortie.get(i).getPlageHoraire().getHeureFin());
			listeDesHorairesDuneSortieEnString.add(heureFinString);
		}
		return listeDesHorairesDuneSortieEnString;	
	}
	

}
