package fr.cursusSopra.model;

public class Horaire {
	
	private int idHoraire;
	private String jour;
//	private int idPlageHoraire;
	
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	
	public Horaire() {
		jour = "lundi";
		PlageHoraire plageHoraire = new PlageHoraire();
	}
	
	public String getHoraireTest() {
		return jour;
		
		
		
	}

	
}
