
<%@ taglib prefix="s" uri="/struts-tags" %>
    
	<h1>Liste des Monuments</h1>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Nom</th>
								<th>Type de monument</th>
								<th>Popularité</th>
								<th>Quartier</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listeDesMonuments">
								<s:url action="detailsMonuments" var="dm">
									<s:param name="idMonument">
										<s:property value="idMonument"/>
									</s:param>
								</s:url>
								<tr>
									<td><a href="<s:property value='#dm'/>"><s:property value="nomLieu"/></a></td>
									<td><s:property value="typeVisite"/></td>
									<td>
										<s:if test='<s:property value="nbavis"/> != 0'>
											String.format("%f - %d avis", <s:property value="notemoy"/>, <s:property value="nbavis"/>);
										</s:if>
										<s:else>
											Aucun avis, <a href="">soyez le premier !</a>
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
