
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Détails du parc ou de la place</h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				Nom du parc ou de la place :
				<s:property value="placeetparc.nomLieu" />
			</div>
			<div>
				Quartier :
				<s:property value="placeetparc.nomQuartier" />
			</div>
			<div>
				Adresse :
				<s:property value="placeetparc.cpAdres" />
				<s:property value="placeetparc.villeAdres" />
			</div>
			<div>
				Description :
				<s:property value="placeetparc.descriptionLieu" />
			</div>

			<div>
				Accessibilité :
				<s:property value="placeetparc.accessibiliteLieu" />
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
				&q=<s:property value="placeetparc.nomLieu" />,<s:property value="placeetparc.villeAdres" />">
			</iframe>
			
		</div>
		<div class="col-md-1"></div>
	</div>


</div>