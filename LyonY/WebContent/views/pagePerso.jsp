<%@ taglib prefix="s" uri="/struts-tags" %>

page personnelle de <s:property value="pseudo"/> <br/>
email: <s:property value="email" /><br/>

<a href="<s:url action='ModifUtilisateur'/>">Modifier le profil</a> <br/>
<a href="<s:url action='AjouteAvis'/>">Ajouter un avis</a> <br/>
<a href="<s:url action='SupprimUtilisateur'/>">Supprimer le compte</a> <br/>
<a href="<s:url action='index'/>">Retour à la page d'accueil</a><br/>