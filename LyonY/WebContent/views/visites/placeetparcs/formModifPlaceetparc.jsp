<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour à la page d'accueil</a> --%>

<h1>Modification d'une place ou d'un parc</h1>


<form class="form-horizontal" method="post" id="idFormModifPlaceetparc" action="<s:url action='modifPlaceetparc'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">
		Le formulaire contient des erreurs. Veuillez réessayer.
	</div>


	<legend>Identification</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du lieu *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nomL" value="<s:property value="placeetparc.nomLieu" />"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>


	<div class="form-group">
		<label for="idTypevisite" class="col-sm-2 control-label">Type de lieu *</label>
		<div class="col-sm-3">
			<div class="row">				
				<select id="idTypevisite" name="idTypevisite">
					<s:iterator value="listeDesTypevisites">
						<s:if test='%{idTypevisite == placeetparc.idTypevisite}'>
							<option value="<s:property value="idTypevisite"/>" selected="selected"><s:property value="libtypevisite" /></option>
						</s:if>
						<s:else>
							<option value="<s:property value="idTypevisite" />"><s:property value="libtypevisite" /></option>
						</s:else>
					</s:iterator>
				</select>
			</div>
<!-- 			<div class = "row"> -->
<%-- 				<a href="<s:url action='creationTypevisite'/>">Ajouter un type de monument</a> --%>
<!-- 			</div> -->
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idQuartier" class="col-sm-2 control-label">Quartier *</label>
		<div class="col-sm-3">
			<div class="row">
				<select id="idQuartier" name="idQuartier">
					<s:iterator value="listeDesQuartiers">
						<s:if test='%{idQuartier == placeetparc.idQuartier}'>
							<option value="<s:property value="idQuartier"/>" selected="selected"><s:property value="nom" /></option>
						</s:if>
						<s:else>
							<option value="<s:property value="idQuartier" />"><s:property value="nom" /></option>
						</s:else>
					</s:iterator>
				</select>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<legend>Adresse</legend>

	<div class="form-group">
		<label for="idNumero" class="col-sm-2 control-label">Numéro</label>
		<div class="col-sm-3">
			<div class="row">
				<s:if test="%{placeetparc.numAdres == 0}">
					<input type="text" class="form-control" id="idNumero" name="numero"/>
				</s:if>
				<s:else>
					<input type="text" class="form-control" id="idNumero" name="numero" value="<s:property value="placeetparc.numAdres" />" />
				</s:else>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie" value="<s:property value="placeetparc.voieAdres" />"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodepostal" class="col-sm-2 control-label">Code postal *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal" name="codePostal" value="<s:property value="placeetparc.cpAdres" />" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" value="<s:property value="placeetparc.villeAdres" />"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<legend>Caractéristiques</legend>
	
	<div class="form-group">
		<label for="idAvecFontaine" class="col-sm-2 control-label">Y a-t-il une fontaine ?</label>
		<div class="col-sm-3">
			<div class="row">
				<s:if test="%{placeetparc.avecFontaine}">
					Oui <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="true" checked="checked"> &nbsp;
					Non <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="false">
				</s:if>
				<s:else>
					Oui <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="true"> &nbsp;
					Non <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="false" checked="checked">
				</s:else>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idDescription" name="description" rows=4 cols=40 ><s:property value="placeetparc.descriptionLieu" /></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idAccessibilité" class="col-sm-2 control-label">Comment y accéder ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilité" name="accessibilite" rows=4 cols=40 ><s:property value="placeetparc.accessibiliteLieu" /></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">(* : champ obligatoire)</div>
		</div>
	</div>
	
	<!-- INPUT HIDDEN -->
	<input type="hidden" name="idAdresse" value="<s:property value="placeetparc.idAdresse" />"/>
	<input type="hidden" name="idLieu" value="<s:property value="placeetparc.idLieu" />"/>
	<input type="hidden" name="idVisite" value="<s:property value="placeetparc.idVisite" />"/>
	<input type="hidden" name="idPlaceetparc" value="<s:property value="placeetparc.idPlaceetparc" />"/>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">
				<button type="reset" class="btn btn-default">Etat initial</button>
				<button type="submit" class="btn btn-default">Modifier ce lieu</button>
			</div>
		</div>
	</div>

</form>