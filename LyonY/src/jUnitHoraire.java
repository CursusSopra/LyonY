import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import fr.cursusSopra.model.Horaire;
import fr.cursusSopra.tech.PostgresConnection;


public class jUnitHoraire {

	@Test
	public void test() {
		Connection cnx = PostgresConnection.getConnexion();
		Horaire h = new Horaire("lundi", 8);
		
		try {
			int idHoraire =  h.save(cnx);
			Assert.assertEquals(8, idHoraire);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
