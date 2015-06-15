package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import fr.cursusSopra.model.Bar;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsBarAction extends SortiesAction {

	private static final long serialVersionUID = 1L;

	public DetailsBarAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Sorties", "sorties", null));
	}

	public String executeDetailsBar() {
		try {
			bar = new Bar(idBar);
			return SUCCESS;
		} catch (SQLException e) {
			return ERROR;
		}
	}

	private int idBar;
	
	public void setIdBar(int idBar) {
		this.idBar = idBar;
	}
	
	private Bar bar;

	public Bar getBar() {
		return bar;
	}
}