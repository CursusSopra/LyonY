<%@ taglib prefix="s" uri="/struts-tags"%>

<a href="<s:url action='index'/>">Retour à la page d'accueil</a>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<h1>Détails du Bar</h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				Nom du bar :
				<s:property value="bar.nombar" />
			</div>
			<div>
				Quartier :
				<s:property value="bar.nomquartier" />
			</div>
			<div>
				Ambiance :
				<s:property value="bar.libambiance" />
			</div>
			<div>
				Adresse :
				<s:property value="bar.numero" />
				<s:property value="bar.voie" />
				<s:property value="bar.ville" />
			</div>
			<div>
				Description :
				<s:property value="bar.description" />
			</div>
			<div>
				Budget :
				<s:property value="bar.prixmin" /> - <s:property value="bar.prixmax" /> &euro;
			</div>
			<div>
				Happy hours :
				<s:property value="bar.happyhour" />
			</div>
			<div>
			<iframe class="map-top" width="598" height="450"
src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCIXm3hVBQgLwOmmsORoaxue1ZSqYx4rc0
&q=<s:property value="bar.nombar" />,<s:property value="bar.numero" />+<s:property value="bar.voie" />,<s:property value="bar.ville" />"></iframe>
			</div>


		</div>
		<div class="col-md-1"></div>
	</div>
</div>