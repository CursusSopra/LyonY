
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Détails du parc ou de la palce</h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				Nom du parc ou de la place :
				<s:property value="nomLieu" />
			</div>
			<div>
				Quartier :
				<s:property value="nomQuartier" />
			</div>
			<div>
				Adresse :
				<s:property value="numAdres" />
				<s:property value="voieAdres" />
				<s:property value="villeAdres" />
			</div>
			<div>
				Description :
				<s:property value="descriptionLieu" />
			</div>
			<div>
				Construction :
				<s:property value="annCons"/> &nbsp;-<s:property value="annFinCons"/>
			</div>

			<div>
				Accessibilité :
				<s:property value="accessibiliteLieu" />
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
					<s:iterator value="listeDesHorairesDuneSortie">
						<tr>
							<td><s:property value="jour" /></td>
							<td><s:date name="heuredebut" format="hh:mm" /></td>
							<td><s:date name="heurefin" format="hh:mm" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>


		</div>
		<div class="col-md-1"></div>
	</div>


</div>