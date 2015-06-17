package fr.cursusSopra.json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.opensymphony.xwork2.Action;

import fr.cursusSopra.tech.PostgresConnection;


public class JSONUtilisateurEmailAction {
	private String email;
	private boolean emailDispo;
	
	public boolean isEmailDispo() {
		Connection cnx = PostgresConnection.getConnexion();
		String query = "SELECT COUNT(*) AS nb FROM utilisateurs WHERE email=?";
		
		PreparedStatement ps;
		try {
			ps = cnx.prepareStatement(query);
			
			ps.setString(1, email);
			ps.execute();

			ResultSet rs = ps.executeQuery();
			rs.next();
			emailDispo = rs.getInt("nb") == 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emailDispo;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String execute() {
		return Action.SUCCESS;
	}
}
