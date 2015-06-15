package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import fr.cursusSopra.model.Nclub;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsNclubAction extends SortiesAction {

	private static final long serialVersionUID = 1L;
	private int idNightclub;
	private Nclub nclub;

	public void setIdNightclub(int idNightclub) {
		this.idNightclub = idNightclub;
	}
	public Nclub getNclub() {
		return nclub;
	}

	public DetailsNclubAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
	}

	public String executeDetailsNclub() {
		try {
			nclub = new Nclub(idNightclub);
			return SUCCESS;
		} catch (SQLException e) {
			return ERROR;
		}
	}
}