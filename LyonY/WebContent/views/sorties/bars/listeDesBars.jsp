<%@ taglib prefix="s" uri="/struts-tags"%>


<h1>Bars de Lyon</h1>

<div>
	<a href="<s:url action='formCreationBar'/>">Ajouter un bar</a>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<table id ="listeDesBars" class="display table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Nom du bar</th>
						<th>Ambiance</th>
						<th>Prix min</th>
						<th>Prix max</th>
						<th>Popularité</th>
						<th>Quartier</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="listeDesBars">
						<tr>
							<s:url action="detailsBar" var="db">
								<s:param name="idBar">
									<s:property value="idBar" />
								</s:param>
							</s:url>

							<td><a href="<s:property value='#db'/>"> <s:property
										value="nombar" /></a></td>
							<td><s:property value="libambiance" /></td>
							<td><s:property value="prixmin" /></td>
							<td><s:property value="prixmax" /></td>
							<td class="nowrap"><s:if test='%{nbavis == 0}'>
									Aucun avis, <a href="">soyez le premier !</a>
								</s:if> <s:else>
									<input data-size="xxs"  id="input-5b" class="rating"  data-symbol="&#xf0fc;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="notemoy" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >(<s:property value="nbavis" /> avis)
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