package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import fr.cursusSopra.action.sorties.SortiesAction;

import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Nclub;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsNclubAction extends SortiesAction {

	private static final long serialVersionUID = 1L;

	private List<Bar> listeDesNclubs;

	public List<Bar> getListeDesNclubs() {

		return listeDesNclubs;

	}

	public DetailsNclubAction() {
		
		super();
		listeBreadcrumbs.add(new Breadcrumbs("Les Night Clubs", "listeDesNclubs", null));
		
	}

	public String execute() {

		return SUCCESS;
	}

	private int idnightclub;
	private Nclub nclub;

	public void setIdnightclub(int idnightclub) {
		this.idnightclub = idnightclub;
	}

	public Nclub getNclub() {
		return nclub;
	}

	public String executeDetailsNclub() {
		try {
			nclub = new Nclub(idnightclub);
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}

	}
}