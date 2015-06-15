<%@ taglib prefix="s" uri="/struts-tags"%>

<a href="<s:url action='index'/>">Retour à la page d'accueil</a>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<h1>Détails du Bar</h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
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
				<s:property value="restaurant.prixmin" /> - <s:property value="restaurant.prixmax" /> &euro;
			</div>
			<div>
				Reservation :
				<s:property value="restaurant.reservation" />
			</div>
			
			<div>
				A emporter :
				<s:property value="restaurant.aemporter" />
			</div>
			
			<div>
			
			<iframe class="map-top" width="598" height="450"
src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCIXm3hVBQgLwOmmsORoaxue1ZSqYx4rc0
&q=<s:property value="restaurant.nomrestaurant" />,<s:property value="restaurant.numero" />+<s:property value="restaurant.voie" />,<s:property value="restaurant.ville" />"></iframe>
			</div>


		</div>
		<div class="col-md-1"></div>
	</div>
</div>