<%@ taglib prefix="s" uri="/struts-tags"%>

<a href="<s:url action='index'/>">Retour � la page d'accueil</a>

<h1>D�tails du Night Club</h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
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
				<s:property value="nclub.ville" />
			</div>
			<div>
				Description :
				<s:property value="nclub.description" />
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


		</div>
		<div class="col-md-1"></div>
	</div>
</div>
