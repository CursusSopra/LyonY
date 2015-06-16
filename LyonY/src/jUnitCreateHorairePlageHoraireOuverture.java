import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import fr.cursusSopra.model.Horaire;
import fr.cursusSopra.model.Ouverture;
import fr.cursusSopra.model.PlageHoraire;
import fr.cursusSopra.tech.PostgresConnection;

public class jUnitCreateHorairePlageHoraireOuverture {

	@Test
	public void test() {
		Connection cnx = PostgresConnection.getConnexion();
		PlageHoraire ph = new PlageHoraire("13:00", "18:00");

		try {
			int idPlageHoraire = ph.save(cnx);
			Horaire h = new Horaire("mardi", idPlageHoraire);
			int idHoraire = 0;

			try {
				idHoraire = h.save(cnx);
				Ouverture ouv = new Ouverture(idHoraire, 6);
				ouv.save(cnx);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Assert.assertEquals(12, idHoraire);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
