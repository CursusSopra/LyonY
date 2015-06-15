
<%@ taglib prefix="s" uri="/struts-tags" %>

<a href="<s:url action='index'/>">Retour � la page d'accueil</a>
    
	<h1>Liste des Places et Parcs</h1>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Adresse</th>
								<th>Quartier</th>
								<th>Type d'endroit</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listeDesPlaceetparcs">
								<s:url action="detailsPlaceetparcs" var="dpp">
									<s:param name="idPlaceetparc">
										<s:property value="idPlaceetparc"/>
									</s:param>
								</s:url>
								<tr>
									<td><a href="<s:property value='#dpp'/>"><s:property value="nomLieu"/></a></td>
									<td><s:property value="cpAdres"/>&nbsp;<s:property value="villeAdres"/></td>
									<td><s:property value="nomQuartier"/></td>
									<td><s:property value="typeVisite"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
								