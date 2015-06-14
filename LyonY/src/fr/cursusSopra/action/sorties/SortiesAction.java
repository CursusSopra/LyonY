package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import fr.cursusSopra.action.general.ActionGeneral;
import fr.cursusSopra.model.Horaire;
import fr.cursusSopra.model.Sortie;
import fr.cursusSopra.tech.Breadcrumbs;


public class SortiesAction extends ActionGeneral {

	private static final long serialVersionUID = 1L;
	
	private List<Horaire> listeDesHorairesDuneSortie;
	
	public List<Horaire> getListeDesHorairesDuneSortie() {
		return listeDesHorairesDuneSortie;
	}
	public SortiesAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Les sorties", "listeProduits", null));
	}


	public String executeGetListeDesHorairesDuneSortie(int idSortie) {		
		try {
			listeDesHorairesDuneSortie = Sortie.getListeDesHorairesDuneSortie(idSortie);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}