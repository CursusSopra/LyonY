<%@ taglib prefix="s" uri="/struts-tags"%>


<a href="<s:url action='index'/>">Retour à la page d'accueil</a>

<h1>Discothèques de Lyon</h1>

<div>
	<s:url action="formAjoutNclub" var="fan">
		<s:param name="idNclub">
			<s:property value="nclub.idNclub"/>
		</s:param>
	</s:url>
	<a href="<s:property value='#fan'/>">Ajouter une discothèque</a>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Nom du club</th>
						<th>Ambiance</th>
						<th>Prix min</th>
						<th>Prix max</th>
						<th>Popularité</th>
						<th>Quartier</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="listeDesNclubs">
						<tr>
							<s:url action="detailsNclub" var="dn">
								<s:param name="idNightclub">
									<s:property value="idNightclub" />
								</s:param>
							</s:url>


							<td><a href="<s:property value='#dn'/>"> <s:property value="nomnightclub" /></a></td>
							<td><s:property value="libambiance" /></td>
							<td><s:property value="prixmin" /></td>
							<td><s:property value="prixmax" /></td>
							<td><s:property value="" /></td>
							<td><s:property value="nomquartier" /></td>
						</tr>

					</s:iterator>


				</tbody>

			</table>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>