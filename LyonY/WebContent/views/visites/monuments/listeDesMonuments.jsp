
<%@ taglib prefix="s" uri="/struts-tags" %>

<a href="<s:url action='index'/>">Retour à la page d'accueil</a>
    
	<h1>Liste des Monuments</h1>
		
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
								<th>Type de monument</th>
								<th>Années de construction</th>
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
									<td><s:property value="numAdres"/>&nbsp;<s:property value="voieAdres"/>, &nbsp;<s:property value="cpAdres"/>&nbsp;<s:property value="villeAdres"/></td>
									<td><s:property value="nomQuartier"/></td>
									<td><s:property value="typeVisite"/></td>
									<td><s:property value="annCons"/>&nbsp;-&nbsp;<s:property value="annFinCons"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
