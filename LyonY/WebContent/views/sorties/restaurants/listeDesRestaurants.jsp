<%@ taglib prefix="s" uri="/struts-tags"%>


<h1>Restaurants de Lyon</h1>

<div>
	<a href="<s:url action='formCreationRestaurant'/>">Ajouter un
		restaurant</a>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<table id ="listeDesRestaurants" class="display table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Nom du restaurant</th>
						<th>Ambiance</th>
						<th>Prix min</th>
						<th>Prix max</th>
						<th>Popularité</th>
						<th>Quartier</th>
						<th>Photos</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="listeDesRestaurants">
						<tr>
							<s:url action="detailsRestaurant" var="dr">
								<s:param name="idRestaurant">
									<s:property value="idRestaurant" />
								</s:param>
							</s:url>

							<td><a href="<s:property value='#dr'/>"> <s:property
										value="nomrestaurant" /></a></td>
							<td><s:property value="libambiance" /></td>
							<td><s:property value="prixmin" /></td>
							<td><s:property value="prixmax" /></td>
							<td><s:if test='%{nbavis == 0}'>
									Aucun avis, <a href="">soyez le premier !</a>
								</s:if> <s:else>
												<input id="input-5b" data-size="xxs" class="rating"  data-symbol="&#xf0f5;" data-glyphicon="false" data-show-caption="false" data-show-clear="false" value=<s:property value="notemoy" />  data-min="0" data-max="5" data-step="0.5" data-disabled="true" data-rating-class="rating-fa" >
(<s:property value="nbavis" /> avis)
								</s:else></td>
							<td><s:property value="nomquartier" /></td>
							<td>
								<s:iterator value="listeDesPhotosDeRestaurant">
								
									<a href="<s:property value="libPhoto" />"><img
			src="<s:property value="libPhoto" />" height="50" /></a>
									
								</s:iterator>
							</td>
						</tr>

					</s:iterator>


				</tbody>

			</table>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>