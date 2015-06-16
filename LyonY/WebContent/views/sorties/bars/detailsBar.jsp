<%@ taglib prefix="s" uri="/struts-tags"%>

<a href="<s:url action='index'/>">Retour à la page d'accueil</a>

<h1>Détails du Bar</h1>

<div>
	<s:url action="modifBar" var="mb">
		<s:param name="idBar">
			<s:property value="bar.idBar"/>
		</s:param>
	</s:url>
	<a href="<s:property value='#mb'/>">Modifier les informations</a>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				Nom du bar :
				<s:property value="bar.nombar" />
				 (<s:property value="bar.notemoy" />)
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
				<s:property value="bar.prixmin" />
				-
				<s:property value="bar.prixmax" />
				&euro;
			</div>
			<div>
				Happy hours :
				<s:property value="bar.happyhour" />
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
						<s:iterator value="bar.listeDesHoraires">
						<tr>
							<td><s:property value="jour"/></td>
							<td><s:date name="plageHoraire.heureDebut" format="HH:mm" /></td>
							<td><s:date name="plageHoraire.heureFin" format="HH:mm" /></td>
						</tr>
					</s:iterator>
						

				</tbody>
			</table>


			<iframe class="map-top" width="598" height="450"
				src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCIXm3hVBQgLwOmmsORoaxue1ZSqYx4rc0
&q=<s:property value="bar.nombar" />,<s:property value="bar.numero" />+<s:property value="bar.voie" />,<s:property value="bar.ville" />"></iframe>


		</div>
		<div class="col-md-1"></div>
	</div>
</div>