package fr.cursusSopra.model;

import java.util.List;

public class Horaire {
	
	private String jour;
	private PlageHoraire plageHoraire;
	public static List<Integer> listeDesIdHoraireDuneSortie;
	public static List<Horaire> listeDesHorairesDuneSortie;

	
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}
	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	
	public Horaire() {
		plageHoraire = new PlageHoraire();
	}

}
