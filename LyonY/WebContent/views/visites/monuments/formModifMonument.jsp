<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>Modification d'un monument</h1>

<form class="form-horizontal" method="post" id="idFormModifMonument" action="<s:url action='modifMonument'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">
		Le formulaire contient des erreurs. Veuillez r�essayer.
	</div>

	<fieldset>
		<legend>Identification</legend>
		<div class="form-group">
			<label for="idNom" class="col-sm-2 control-label">Nom du monument *</label>
			<div class="col-sm-3">
				<div class="row">
					<input type="text" class="form-control" id="idNom" name="nomL" value="<s:property value="monument.nomLieu" />"/>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	
		<div class="form-group">
			<label for="idTypevisite" class="col-sm-2 control-label">Type de monument *</label>
			<div class="col-sm-3">
				<div class="row">				
					<select id="idTypevisite" name="idTypevisite">
						<s:iterator value="listeDesTypevisites">
							<s:if test='%{idTypevisite == monument.idTypevisite}'>
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
							<s:if test='%{idQuartier == monument.idQuartier}'>
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
	</fieldset>
	
	<fieldset>
		<legend>Adresse</legend>
	
		<div class="form-group">
			<label for="idNumero" class="col-sm-2 control-label">Num�ro</label>
			<div class="col-sm-3">
				<div class="row">
					<s:if test="%{monument.numAdres == 0}">
						<input type="text" class="form-control" id="idNumero" name="numero" />
					</s:if>
					<s:else>
						<input type="text" class="form-control" id="idNumero" name="numero" value="<s:property value="monument.numAdres" />" />
					</s:else>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	
		<div class="form-group">
			<label for="idVoie" class="col-sm-2 control-label">Voie</label>
			<div class="col-sm-3">
				<div class="row">
					<input type="text" class="form-control" id="idVoie" name="voie" value="<s:property value="monument.voieAdres" />"/>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	
		<div class="form-group">
			<label for="idCodepostal" class="col-sm-2 control-label">Code postal *</label>
			<div class="col-sm-3">
				<div class="row">
					<input type="text" class="form-control" id="idCodepostal" name="codePostal" value="<s:property value="monument.cpAdres" />" />
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	
		<div class="form-group">
			<label for="idVille" class="col-sm-2 control-label">Ville *</label>
			<div class="col-sm-3">
				<div class="row">
					<input type="text" class="form-control" id="idVille" name="ville" value="<s:property value="monument.villeAdres" />"/>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Caract�ristiques</legend>
		
		<div class="form-group">
			<label for="idAnnCons" class="col-sm-2 control-label">Ann�e de d�but de construction</label>
			<div class="col-sm-3">
				<div class="row">
					<input type="text" class="form-control" id="idAnnCons" name="annCons" value="<s:property value="monument.annCons" />"/>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	
		<div class="form-group">
			<label for="idAnnFinCons" class="col-sm-2 control-label">Ann�e de fin de construction</label>
			<div class="col-sm-3">
				<div class="row">
					<input type="text" class="form-control" id="idAnnFinCons" name="annFinCons" value="<s:property value="monument.annFinCons" />"/>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
		
		<div class="form-group">
			<label for="idDescription" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-3">
				<div class="row">
					<TEXTAREA id="idDescription" name="description" rows=4 cols=40 ><s:property value="monument.descriptionLieu" /></TEXTAREA>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
		
		<div class="form-group">
			<label for="idAccessibilit�" class="col-sm-2 control-label">Comment y acc�der ?</label>
			<div class="col-sm-3">
				<div class="row">
					<TEXTAREA id="idAccessibilit�" name="accessibilite" rows=4 cols=40 ><s:property value="monument.accessibiliteLieu" /></TEXTAREA>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	</fieldset>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">(* : champ obligatoire)</div>
		</div>
	</div>
	
	<!-- INPUT HIDDEN -->
	<input type="hidden" name="idAdresse" value="<s:property value="monument.idAdresse" />"/>
	<input type="hidden" name="idLieu" value="<s:property value="monument.idLieu" />"/>
	<input type="hidden" name="idVisite" value="<s:property value="monument.idVisite" />"/>
	<input type="hidden" name="idMonument" value="<s:property value="monument.idMonument" />"/>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">
				<button type="reset" class="btn btn-default">Etat initial</button>
				<button type="submit" class="btn btn-default">Modifier ce monument</button>
			</div>
		</div>
	</div>

</form>