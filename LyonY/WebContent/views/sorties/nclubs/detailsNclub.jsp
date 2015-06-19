<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Détails du Night Club</h1>

<div>
	<s:url action="formModifNclub" var="mn">
		<s:param name="idNightclub">
			<s:property value="nclub.idNightclub"/>
		</s:param>
	</s:url>
	<a href="<s:property value='#mn'/>">Modifier les informations</a>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
			<input id="input-5b" data-size="sm" class="rating"  data-symbol="&#xf001;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="nclub.notemoy" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
			
				Nom du Night Club :
				<s:property value="nclub.nomnightclub" />

				 
			</div>
			<div>
				Quartier :
				<s:property value="nclub.nomquartier" />
			</div>
			<div>
				Ambiance :
				<s:property value="nclub.libambiance" />
			</div>
			<div>
				Adresse :
				<s:property value="nclub.numero" />
				<s:property value="nclub.voie" />
				<s:property value="nclub.codepostal" />
				<s:property value="nclub.ville" />
			</div>
			<div>
				Description :
				<s:property value="nclub.description" />
			</div>
			<div>
				Accessibilité :
				<s:property value="nclub.accessibilite" />
			</div>
			<div>
				Budget :
				<s:property value="nclub.prixmin" />
				-
				<s:property value="nclub.prixmax" />
				&euro;
			</div>

			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Jour de la semaine</th>
						<th>Heure d'ouverture</th>
						<th>Heure de fermeture</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="nclub.listeDesHoraires">
						<tr>
							<td><s:property value="jour" /></td>
							<td><s:date name="plageHoraire.heureDebut" format="HH:mm" /></td>
							<td><s:date name="plageHoraire.heureFin" format="HH:mm" /></td>
						</tr>
					</s:iterator>


				</tbody>
			</table>

			<div>

				<iframe class="map-top" width="598" height="450"
					src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCIXm3hVBQgLwOmmsORoaxue1ZSqYx4rc0
&q=<s:property value="nclub.nomnightclub" />,<s:property value="nclub.numero" />+<s:property value="nclub.voie" />,<s:property value="nclub.ville" />"></iframe>
			</div>
			
			<div>
				Avis :
				<table class="table table-striped table-hover" >
				<s:iterator value="nclub.listeDesAvisDunLieu"> 
					<tr> 
					<td ><s:property value="pseudo"/>&nbsp;</td> 
					
					<td><input data-size="xxs" id="input-5b" class="rating"  data-symbol="&#xf001;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="note" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
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
