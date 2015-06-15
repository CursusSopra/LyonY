<%@ taglib prefix="s" uri="/struts-tags" %>

<h1>Etes-vous sûr de vouloir supprimer votre profil, <s:property value='pseudo'/>?</h1>
<h2>Si oui, cliquer sur Supprimer</h2>
<form action="validateSuppression">
	<input name="pseudo" type="hidden" value="<s:property value='pseudo'/>"/>
	<input type="submit" value="Supprimer"/>
</form>