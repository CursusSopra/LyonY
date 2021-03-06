
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<h1>Liste des Monuments</h1>
<div>
	<a href="<s:url action='formCreationMonument'/>">Ajouter un monument</a>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			
			<table id ="listeDesMonuments" class="display table table-striped table-hover table-bordered">
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
						<s:url action="detailsMonument" var="dm">
							<s:param name="idMonument">
								<s:property value="idMonument"/>
							</s:param>
						</s:url>
						<s:url action="formCreationAvis" var="am">
							<s:param name="idLieu">
								<s:property value="idLieu"/>
							</s:param>
						</s:url>
						<tr>
							<td><a href="<s:property value='#dm'/>"><s:property value="nomLieu"/></a></td>
							<td><s:property value="typeVisite"/></td>
							<td>
								<s:if test='%{nbavis == 0}'>
									Aucun avis, <a href="<s:property value='#am'/>">soyez le premier</a>
								</s:if>
								<s:else>
									<s:property value="notemoy"/> - <s:property value="nbavis"/> avis
									&nbsp;/&nbsp;<a href="<s:property value='#am'/>">Donnez votre avis</a>
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
