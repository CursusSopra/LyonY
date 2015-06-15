<%@ taglib prefix="s" uri="/struts-tags" %>

page personnelle de <s:property value="pseudo"/> <br/>
email: <s:property value="email" /><br/>
idUtilisateur: <s:property value="idUtilisateur" /><br/>

<s:url action="SupprimUtilisateur" var="su">
							<s:param name="pseudo">
								<s:property value="pseudo"/>
							</s:param>
</s:url>

<s:url action="FormModifUtilisateur" var="mo">
							<s:param name="pseudo">
								<s:property value="pseudo"/>
							</s:param>
</s:url>

<s:url action="displayAvisUtilisateur" var="ma">
							<s:param name="idUtilisateur">
								<s:property value="idUtilisateur"/>
							</s:param>
							<s:param name="pseudo">
								<s:property value="pseudo"/>
							</s:param>
</s:url>

<a href="<s:property value='#mo'/>">Modifier le profil</a> <br/>
<a href="<s:property value='#ma'/>">Mes Avis</a> <br/>
<a href="<s:url action='AjouteAvis'/>">Ajouter un avis</a> <br/>
<a href="<s:property value= '#su' />">Supprimer le compte</a> <br/>
<a href="<s:url action='index'/>">Retour à la page d'accueil</a><br/>