<%@ taglib prefix="s" uri="/struts-tags"%>




<h1>Discothèques de Lyon</h1>

<div>
	<a href="<s:url action='formCreationNclub'/>">Ajouter une
		discothèque</a>
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

							<td><a href="<s:property value='#dn'/>"> <s:property
										value="nomnightclub" /></a></td>
							<td><s:property value="libambiance" /></td>
							<td><s:property value="prixmin" /></td>
							<td><s:property value="prixmax" /></td>
							<td><s:if test='%{nbavis == 0}'>
									Aucun avis, <a href="">soyez le premier !</a>
								</s:if> <s:else>
									<s:property value="notemoy" /> - <s:property value="nbavis" /> avis
								</s:else></td>
							<td><s:property value="nomquartier" /></td>
						</tr>

					</s:iterator>


				</tbody>

			</table>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>