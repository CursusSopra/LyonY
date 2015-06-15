package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.action.sorties.SortiesAction;
import fr.cursusSopra.model.Bar;

public class ListeDesBarsAction extends SortiesAction {

	private static final long serialVersionUID = 1L;

	private List<Bar> listeDesBars;

	public List<Bar> getListeDesBars() {

		return listeDesBars;

	}

	public ListeDesBarsAction() {
	}
	
	public String execute() {

		return SUCCESS;
	}

	public String executeListeDesBars() {

		try {

			listeDesBars = Bar.getListeDesBars();

			return SUCCESS;

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return ERROR;

		}

	}

}