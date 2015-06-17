
<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour à la page d'accueil</a> --%>

<h1>Détails du monument</h1>
<div>
	<s:url action="formModifMonument" var="mm">
		<s:param name="idMonument">
			<s:property value="monument.idMonument"/>
		</s:param>
	</s:url>
	<a href="<s:property value='#mm'/>">Modifier les informations</a>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				<td><input data-size="xs" id="input-5b"  class="rating"  data-symbol="&#xf19c;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="monument.notemoy" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
			
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
				Avis :
				<table class="table table-striped table-hover" >
				<s:iterator value="monument.listeDesAvisDunLieu"> 
					<tr> 
					<td ><s:property value="pseudo"/>&nbsp;</td> 
					
					<td><input data-size="xxs" id="input-5b" class="rating"  data-symbol="&#xf19c;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="note" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
					</td> 
					
					<td><s:property value="message"/>&nbsp;</td>
					</tr>
				</s:iterator>
				</table>
				
			</div>
			
			
		</div>
		<div class="col-md-1"></div>
	</div>



</div>