<%@ taglib prefix="s" uri="/struts-tags"%>


<a href="<s:url action='index'/>">Retour à la page d'accueil</a>

<h1>Restaurants de Lyon</h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Nom du restaurant</th>
						<th>Ambiance</th>
						<th>Prix min</th>
						<th>Prix max</th>
						<th>Popularité</th>
						<th>Quartier</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="listeDesRestaurants">
						<tr>
<%-- 							<s:url action="detailsRestaurant" var="dr"> --%>
<%-- 								<s:param name="idrestaurant"> --%>
<%-- 									<s:property value="idrestaurant" /> --%>
<%-- 								</s:param> --%>
<%-- 							</s:url> --%>


<%-- 							<td><a href="<s:property value='#db'/>"> <s:property value="nomrestaurant" /></a></td> --%>
							<td><s:property value="nomrestaurant" /></td>
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