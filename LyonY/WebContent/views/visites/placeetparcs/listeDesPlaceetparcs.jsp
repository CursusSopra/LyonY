
<%@ taglib prefix="s" uri="/struts-tags" %>
    
	<h1>Liste des Places et Parcs</h1>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Type d'endroit</th>
								<th>Popularité</th>
								<th>Quartier</th>
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
									<td><s:property value="typeVisite"/></td>
									<td>
										<s:if test='%{nbavis == 0}'>
											Aucun avis, <a href="">soyez le premier !</a>
										</s:if>
										<s:else>
											<s:property value="notemoy"/> - <s:property value="nbavis"/> avis
										</s:else>
									</td>
									<td><s:property value="nomQuartier"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
								