<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
		<form id="idConnexion" name="Connexion" method="POST" action="<s:url action='ConnexionUtilisateur' />">
			Identifiant:<input type="text" name="pseudo" required
				placeholder="Identifiant" /> Mot de passe:<input type="password"
				name="motDePasse" required placeholder="Mot de passe" /> <input
				type="submit" value="Connexion" />
		</form>
		<a href='<s:url action="FormCreationUtilisateur"/>'>Inscription</a>
</div>