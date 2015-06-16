package fr.cursusSopra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ouverture {

	private int idHoraire;
	private int idSortie;

	public Ouverture(int idHoraire, int idSortie) {
		this.idHoraire = idHoraire;
		this.idSortie = idSortie;
	}

	public int save(Connection cnx) throws Exception {
		PreparedStatement psOuvertures = cnx.prepareStatement("INSERT INTO ouvertures(idhoraire, idsortie) VALUES (?, ?)");
		psOuvertures.setInt(1, idHoraire);
		psOuvertures.setInt(2, idSortie);
		return psOuvertures.executeUpdate();
	}
}
