package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.action.general.ActionGeneral;
import fr.cursusSopra.model.Horaire;
import fr.cursusSopra.model.Sortie;
import fr.cursusSopra.tech.Breadcrumbs;


public class SortiesAction extends ActionGeneral {

	private static final long serialVersionUID = 1L;
	
	private int idSortie;
	
	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}
	
	private List<Horaire> listeDesHorairesDuneSortie;
	
	public List<Horaire> getListeDesHorairesDuneSortie() {
		return listeDesHorairesDuneSortie;
	}
	public SortiesAction() {
	}


	public String executeGetListeDesHorairesDuneSortie(int idSortie) {		
		listeDesHorairesDuneSortie = getListeDesHorairesDuneSortie();
		return SUCCESS;
	}

}