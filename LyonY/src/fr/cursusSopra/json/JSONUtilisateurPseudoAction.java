package fr.cursusSopra.json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.opensymphony.xwork2.Action;

import fr.cursusSopra.tech.PostgresConnection;


public class JSONUtilisateurPseudoAction {
	private String pseudo;
	private boolean pseudoDispo;
		
	public boolean isPseudoDispo() {
		Connection cnx = PostgresConnection.getConnexion();
		String query = "SELECT COUNT(*) AS nb FROM utilisateurs WHERE pseudo=?";
		
		PreparedStatement ps;
		try {
			ps = cnx.prepareStatement(query);
			
			ps.setString(1, pseudo);
			ps.execute();

			ResultSet rs = ps.executeQuery();
			rs.next();
			pseudoDispo = rs.getInt("nb") == 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pseudoDispo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String execute() {
		return Action.SUCCESS;
	}
}
