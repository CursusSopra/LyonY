package fr.cursusSopra.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PlageHoraire {
	
	private int idPlageHoraire;
	private Date heureDebut;
	private Date heureFin;
	private DateFormat format = new SimpleDateFormat("HH:mm");
	
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	
	public PlageHoraire() {
		
		try {
			
			heureDebut = format.parse("9:00");
			heureFin = format.parse("20:00");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
	}
	
}
