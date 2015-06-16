import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.cursusSopra.model.PlageHoraire;
import fr.cursusSopra.tech.PostgresConnection;


public class jUnitPlageHoraire {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Connection cnx = PostgresConnection.getConnexion();
		PlageHoraire ph = new PlageHoraire("10:00", "18:00");
		try {
			int idPlageHoraire =  ph.save(cnx);
			Assert.assertEquals(8, idPlageHoraire);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
