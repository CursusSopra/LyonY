package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;
import fr.cursusSopra.model.Nclub;
import fr.cursusSopra.tech.Breadcrumbs;

public class ListeDesNclubsAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	
	private List<Nclub> listeDesNclubs;
	
	public List<Nclub> getListeDesNclubs() {
		return listeDesNclubs;
	}

	public ListeDesNclubsAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String executeListeDesNclubs() {
		try {
			listeDesNclubs = Nclub.getListeDesNightclubs();
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}