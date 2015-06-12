package fr.cursusSopra.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Bar;

public class DetailsNclubAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Bar> listeDesBars;

	public List<Bar> getListeDesBars() {

		return listeDesBars;

	}

	public DetailsNclubAction() {
	}

	public String execute() {

		return SUCCESS;
	}

	private int idbar;
	private Bar bar;

	public void setIdbar(int idbar) {
		this.idbar = idbar;
	}

	public Bar getBar() {
		return bar;
	}

	public String executeDetailsNclub() {
		try {
			bar = new Bar(idbar);
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}

	}
}