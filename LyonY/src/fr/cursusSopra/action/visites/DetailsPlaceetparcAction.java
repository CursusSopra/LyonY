package fr.cursusSopra.action.visites;

import fr.cursusSopra.tech.Breadcrumbs;

public class DetailsPlaceetparcAction extends ListeDesPlaceetparcsAction {

	public DetailsPlaceetparcAction() {
		listeBreadcrumbs.add(new Breadcrumbs("Places et parcs", "listeDesPlaceetparcs", null));
	}

}
