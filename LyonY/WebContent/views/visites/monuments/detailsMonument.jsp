
<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour � la page d'accueil</a> --%>

<h1>D�tails du monument</h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<div>
				Nom du monument :
				<s:property value="monument.nomLieu" />
			</div>
			<div>
				Quartier :
				<s:property value="monument.nomQuartier" />
			</div>
			<div>
				Adresse :
				<s:property value="monument.numAdres" />
				<s:property value="monument.voieAdres" />
				<s:property value="monument.villeAdres" />
			</div>
			<div>
				Description :
				<s:property value="monument.descriptionLieu" />
			</div>
			<div>
				Construction :
				<s:property value="monument.annCons"/> &nbsp;-<s:property value="monument.annFinCons"/>
			</div>

			<div>
				Accessibilit� :
				<s:property value="monument.accessibiliteLieu" />
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