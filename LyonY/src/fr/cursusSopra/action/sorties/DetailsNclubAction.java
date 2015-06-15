package fr.cursusSopra.action.sorties;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Bar;
import fr.cursusSopra.model.Nclub;
import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsNclubAction extends ListeDesNclubsAction {

	private static final long serialVersionUID = 1L;

	private List<Nclub> listeDesNclubs;

	public List<Nclub> getListeDesNclubs() {

		return listeDesNclubs;

	}

	public DetailsNclubAction() {
		
		super();
		listeBreadcrumbs.add(new Breadcrumbs("Night Clubs", "listeDesNclubs", null));
		
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