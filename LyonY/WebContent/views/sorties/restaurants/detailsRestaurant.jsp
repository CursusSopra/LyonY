<%@ taglib prefix="s" uri="/struts-tags"%>


<h1>Détails du Restaurant</h1>

<div>
	<s:url action="formModifRestaurant" var="mr">
		<s:param name="idRestaurant">
			<s:property value="restaurant.idRestaurant"/>
		</s:param>
	</s:url>
	<a href="<s:property value='#mr'/>">Modifier les informations</a>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
			<input id="input-5b" class="rating"  data-symbol="&#xf0f5;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="restaurant.notemoy" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
				Nom du restaurant :
				<s:property value="restaurant.nomrestaurant" />
			
			</div>
			<div>
				Quartier :
				<s:property value="restaurant.nomquartier" />
			</div>
			<div>
				Ambiance :
				<s:property value="restaurant.libambiance" />
			</div>
			<div>
				Adresse :
				<s:property value="restaurant.numero" />
				<s:property value="restaurant.voie" />
				<s:property value="restaurant.codepostal" />
				<s:property value="restaurant.ville" />
			</div>
			<div>
				Description :
				<s:property value="restaurant.description" />
			</div>
			<div>
				Budget :
				<s:property value="restaurant.prixmin" />
				-
				<s:property value="restaurant.prixmax" />
				&euro;
			</div>
			<div>
				Reservation :


				<s:set var="res" value="restaurant.reservation" />				

				<s:if test="%{res}">
					Oui
				</s:if>
				<s:else>
    				Non
				</s:else>
			</div>

			<div>
				A emporter :

				<s:set var="aemp" value="restaurant.aemporter" />

				<s:if test="%{aemp}">
					Oui
				</s:if>
				<s:else>
    				Non
				</s:else>
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
						<s:iterator value="restaurant.listeDesHoraires">
						<tr>
							<td><s:property value="jour"/></td>
							<td><s:date name="plageHoraire.heureDebut" format="HH:mm" /></td>
							<td><s:date name="plageHoraire.heureFin" format="HH:mm" /></td>
						</tr>
					</s:iterator>
						

				</tbody>
			</table>

			<div>

				<iframe class="map-top" width="598" height="450"
					src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCIXm3hVBQgLwOmmsORoaxue1ZSqYx4rc0
&q=<s:property value="restaurant.nomrestaurant" />,<s:property value="restaurant.numero" />+<s:property value="restaurant.voie" />,<s:property value="restaurant.ville" />"></iframe>
			</div>
			
			<div>
				Avis :
				<table class="table table-striped table-hover" >
				<s:iterator value="restaurant.listeDesAvisDunLieu"> 
					<tr> 
					<td ><s:property value="pseudo"/>&nbsp;</td> 
					
					<td><input data-size="xxs" id="input-5b" class="rating"  data-symbol="&#xf0f5;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="note" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
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
