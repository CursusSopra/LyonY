
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
								<th>Description</th>
								<th>Adresse</th>
								<th>Accessibilité</th>
								<th>Années de construction</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listeDesMonuments">
								<tr>

									<td><s:property value="nomLieu"/></td>
									<td><s:property value="descriptionLieu"/></td>
									<td><s:property value="numAdres"/>&nbsp;<s:property value="voieAdres"/>&nbsp;<s:property value="villeAdres"/></td>
									<td><s:property value="annCons"/>&nbsp;<s:property value="annFinCons"/>&nbsp;</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
