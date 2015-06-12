package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Horaire;
import fr.cursusSopra.model.Sortie;


public class SortiesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Horaire> listeDesHorairesDuneSortie;
	
	public List<Horaire> getListeDesHorairesDuneSortie() {
		return listeDesHorairesDuneSortie;
	}
	public SortiesAction() {}


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