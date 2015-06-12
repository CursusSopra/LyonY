package fr.cursusSopra.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PlageHoraire {
	
	private Date heureDebut;
	private Date heureFin;
	private DateFormat df = new SimpleDateFormat("HH:mm");
	
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
	}
	
}

//		try {			
//			heureDebut = df.parse("09:00");
//			heureFin = df.parse("20:00");
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}				