
<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour à la page d'accueil</a> --%>

<h1>Détails du monument</h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				Nom du monument :
				<s:property value="monument.nomLieu" />
			</div>
			<div>
				Quartier :
				<s:property value="monument.nomQuartier" />
			</div>
			<div>
				Adresse :
				<s:property value="monument.numAdres" />&nbsp;<s:property value="monument.voieAdres" />,&nbsp;<s:property value="monument.cpAdres" />&nbsp;<s:property value="monument.villeAdres" />
			</div>
			<div>
				Construction :
				<s:property value="monument.annCons"/>&nbsp;-&nbsp;<s:property value="monument.annFinCons"/>
			</div>
			<div>
				Description :
				<s:property value="monument.descriptionLieu" />
			</div>

			<div>
				Accessibilité :
				<s:property value="monument.accessibiliteLieu" />
			</div>
			
<!-- 			<table class="table table-striped table-hover"> -->
<!-- 				<thead> -->
<!-- 					<tr> -->
<!-- 						<th>Jour de la semaine</th> -->
<!-- 						<th>Heure d'ouverture</th> -->
<!-- 						<th>Heure de fermeture</th> -->
<!-- 					</tr> -->
<!-- 				</thead> -->
<!-- 				<tbody> -->
<%-- 					<s:iterator value="listeDesHorairesDuneSortie"> --%>
<!-- 						<tr> -->
<%-- 							<td><s:property value="jour" /></td> --%>
<%-- 							<td><s:date name="heuredebut" format="hh:mm" /></td> --%>
<%-- 							<td><s:date name="heurefin" format="hh:mm" /></td> --%>
<!-- 						</tr> -->
<%-- 					</s:iterator> --%>
<!-- 				</tbody> -->
<!-- 			</table> -->

			<iframe class="map-top" width="598" height="450"
				src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCIXm3hVBQgLwOmmsORoaxue1ZSqYx4rc0
				&q=<s:property value="monument.nomLieu" />,<s:property value="monument.numAdres" />+<s:property value="monument.voieAdres" />,<s:property value="monument.villeAdres" />">
			</iframe>
			
			<div>
				<s:url action="modifMonument" var="mm">
					<s:param name="idMonument">
						<s:property value="monument.idMonument"/>
					</s:param>
				</s:url>
				<a href="<s:property value='#mm'/>">Modifier les informations</a>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>



</div>