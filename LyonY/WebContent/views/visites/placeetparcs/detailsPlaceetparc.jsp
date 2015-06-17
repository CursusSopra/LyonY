
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Détails du parc ou de la place</h1>
<div>
	<s:url action="formModifPlaceetparc" var="mp">
		<s:param name="idPlaceetparc">
			<s:property value="placeetparc.idPlaceetparc"/>
		</s:param>
	</s:url>
	<a href="<s:property value='#mp'/>">Modifier les informations</a>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				<td><input data-size="xs" id="input-5b"  class="rating"  data-symbol="&#xf1bb;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="placeetparc.notemoy" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
			
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
			
			<div>
				Avis :
				<table class="table table-striped table-hover" >
				<s:iterator value="placeetparc.listeDesAvisDunLieu"> 
					<tr> 
					<td ><s:property value="pseudo"/>&nbsp;</td> 
					
					<td><input data-size="xxs" id="input-5b" class="rating"  data-symbol="&#xf1bb;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="note" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
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