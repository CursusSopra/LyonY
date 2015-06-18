
<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour à la page d'accueil</a> --%>

<h1>Détails du monument</h1>
<div>
	<s:url action="formModifMonument" var="mm">
		<s:param name="idMonument">
			<s:property value="monument.idMonument"/>
		</s:param>
	</s:url>
<%-- 	<s:url action="formSupprMonument" var="sm"> --%>
<%-- 		<s:param name="idMonument"> --%>
<%-- 			<s:property value="monument.idMonument"/> --%>
<%-- 		</s:param> --%>
<%-- 	</s:url> --%>
	<a href="<s:property value='#mm'/>">Modifier les informations</a><!-- ou <a href="<s:property value='#sm'/>">supprimer ce monument</a>-->
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				<input data-size="xs" id="input-5b"  class="rating"  data-symbol="&#xf19c;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="monument.notemoy" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa">
			
				<strong>Nom du monument :</strong>
				<s:property value="monument.nomLieu" />
			</div>
			<div>
				<strong>Type :</strong>
				<s:property value="monument.typeVisite" />
			</div>
			<div>
				<strong>Quartier :</strong>
				<s:property value="monument.nomQuartier" />
			</div>
			<div>
				<strong>Adresse :</strong>
				<s:property value="monument.numAdres" />&nbsp;<s:property value="monument.voieAdres" />,&nbsp;<s:property value="monument.cpAdres" />&nbsp;<s:property value="monument.villeAdres" />
			</div>
			<div>
				<strong>Construction :</strong>
				<s:property value="monument.annCons"/>&nbsp;-&nbsp;<s:property value="monument.annFinCons"/>
			</div>
			<div>
				<strong>Description :</strong>
				<s:property value="monument.descriptionLieu" />
			</div>

			<div>
				<strong>Accessibilité :</strong>
				<s:property value="monument.accessibiliteLieu" />
			</div>

			<iframe class="map-top" width="598" height="450"
				src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCIXm3hVBQgLwOmmsORoaxue1ZSqYx4rc0
				&q=<s:property value="monument.nomLieu" />,<s:property value="monument.numAdres" />+<s:property value="monument.voieAdres" />,<s:property value="monument.villeAdres" />">
			</iframe>
			
			<div>
				<h3>Avis :</h3>
				
				<s:url action="formCreationAvis" var="am">
					<s:param name="idLieu">
						<s:property value="monument.idLieu"/>
					</s:param>
				</s:url>

				<s:if test='%{monument.nbavis == 0}'>
				Aucun avis, <a href="<s:property value='#am'/>">soyez le premier !</a>
				</s:if>
					<s:else>
						<a href="<s:property value='#am'/>">Donnez votre avis</a>
						<table class="table table-striped table-hover" >
							<s:iterator value="monument.listeDesAvisDunLieu"> 
								<tr> 
									<td ><s:property value="pseudo"/>&nbsp;</td> 
									<td><input data-size="xxs" id="input-5b" class="rating"  data-symbol="&#xf1bb;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="note" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa"></td> 		
									<td><s:property value="message"/>&nbsp;</td>
								</tr>
							</s:iterator>
						</table>
					</s:else>	
			</div>
			
			
		</div>
		<div class="col-md-1"></div>
	</div>



</div>