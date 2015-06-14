package fr.cursusSopra.action.general;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.tech.Breadcrumbs;

public class ActionGeneral extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected List<Breadcrumbs> listeBreadcrumbs = new ArrayList<Breadcrumbs>();

	public ActionGeneral () {

		// base breadcrumb
		listeBreadcrumbs.add(new Breadcrumbs("Accueil", "index", null));
	}

	public List<Breadcrumbs> getListeBreadcrumbs() {
		return listeBreadcrumbs;
	}


}
