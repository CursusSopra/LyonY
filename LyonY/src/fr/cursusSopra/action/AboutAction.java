/**
 * File modified by : Benoît
 */
package fr.cursusSopra.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.cursusSopra.model.Collaborateurs;

public class AboutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 524351754340439768L;

	private List<Collaborateurs> listCollab = new ArrayList<Collaborateurs>();

	public AboutAction() {
		listCollab
				.add(new Collaborateurs(
						"mathematiques.jpg", // Image de fond
						"guineta.jpg", // Image identité
						"Alexandre", // Nom complet
						"Responsable des pavés numériques", // Titre
						"Lyon, France",
						"ag@lyony.fr",
						"",
						"Après un master de recherches sur les 4 opérations arithmétiques, s'oriente vers quelque chose de plus simple : Pacbase", // Bio
						"POO, Algorithmique, ...")); // Compétences

		listCollab.add(new Collaborateurs("stationdetravail.jpg", // Image de fond
				"rgesnik.jpg", // Image identité
				"Rémy", // Nom complet
				"Responsable des Stations de Travail", // Titre
				"Lyon, France", "rg@lyony.fr", "", "bio", // Bio
				"Les T-Shirts au nom de l'école, ...")); // Compétences

		listCollab.add(new Collaborateurs("croixrousse.jpg", // Image de fond
				"cazais.jpg", // Image identité
				"Camille", // Nom complet
				"Dresseur de Chiens et Ramasseur de Balles", // Titre
				"Lyon, France", "ca@lyony.fr", "", "bio", // Bio
				"competences, ...")); // Compétences

		listCollab.add(new Collaborateurs("brasseriecarnot.jpg", // Image de fond
				"jtanchon.jpg", // Image identité
				"Julien", // Nom complet
				"Responsable des Annulations de Réservation", // Titre
				"Lyon, France", "jt@lyony.fr", "", "bio", // Bio
				"competences, ...")); // Compétences

		listCollab.add(new Collaborateurs("slovenie.jpg", // Image de fond
				"fdudych.jpg", // Image identité
				"Florence", // Nom complet
				"Manager en Pendaison de Crémaillère", // Titre
				"Lyon, France", "fd@lyony.fr", "", "bio", // Bio
				"Questionning, ...")); // Compétences

		listCollab.add(new Collaborateurs("velov.jpg", // Image de fond
				"parodesch.jpg", // Image identité
				"Pierre-Antoine", // Nom complet
				"Responsable du Stationnement", // Titre
				"Lyon, France", "par@lyony.fr", "", "Diplomé Ingénieur en Mécanique des Vélos", // Bio
				"SOAP, Pull & Push, ...")); // Compétences

		listCollab.add(new Collaborateurs("celtique.jpg", // Image de fond
				"gjouen.jpg", // Image identité
				"Gaïdig", // Nom complet
				"Traductrice de Java en Breton", // Titre
				"Lyon, France", "gd@lyony.fr", "", "bio", // Bio
				"competences, ...")); // Compétences

		listCollab.add(new Collaborateurs("football.jpg", // Image de fond
				"aechalier.jpg", // Image identité
				"Alexandre", // Nom complet
				"Responsable des Animations", // Titre
				"Clermont, France", "ae@lyony.fr", "", "bio", // Bio
				", ...")); // Compétences

		listCollab.add(new Collaborateurs("poulets.gif", // Image de fond
				"ymigne.jpg", // Image identité
				"Yvann", // Nom complet
				"Responsable des Tombées du Cul du Camion", // Titre
				"Lyon, France", "ym@lyony.fr", "", "bio", // Bio
				"Poulets à la Plancha, ...")); // Compétences

		listCollab.add(new Collaborateurs("rolandgarros.jpg", // Image de fond
				"mvitaglione.jpg", // Image identité
				"Maxime", // Nom complet
				"Responsable des Retransmissions de Roland Garros", // Titre
				"Lyon, France", "mv@lyony.fr", "", "bio", // Bio
				"Sait lire l'heure, ...")); // Compétences

		listCollab.add(new Collaborateurs("fond.png", "dl.png",
				"Daniel", "Responsable des déblocages de pull-push",
				"La Rochelle, France", "dl@lyony.fr", "",
				"Sévit encore et encore sur les Cursus Sopra !",
				"Blagues nulles, ..."));

		listCollab
				.add(new Collaborateurs(
						"CoucherSoleilMinimes.jpg",
						"gavroche.jpg",
						"Gavroche",
						"Responsable du bien-être et des approvisionnements",
						"Morlaix, France",
						"gavroche@lyony.fr",
						"",
						"A testé pour vous tous les bouchons lyonnais, afin de trouver les meilleurs producteurs de France et surtout de Navarre",
						"Sommeil flash, veille technologique sur les bons plats lyonnais, gardiennage des zones sensibles (salle de déjeuner,...)."));

	}

	@Override
	public String execute() {

		return SUCCESS;
	}

	public List<Collaborateurs> getListCollab() {
		return listCollab;
	}
}
