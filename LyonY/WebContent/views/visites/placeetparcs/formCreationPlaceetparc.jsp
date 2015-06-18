<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <a href="<s:url action='index'/>">Retour à la page d'accueil</a> --%>

<h1>Ajout d'une place ou d'un parc</h1>

<form class="form-horizontal" method="post" id="idFormCreationPlaceetparc" action="<s:url action='creationPlaceetparc'/>">

	<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">
		Le formulaire contient des erreurs. Veuillez réessayer.
	</div>


	<legend>Identification</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du lieu *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom" name="nomL" placeholder="Exemple : Gros Caillou"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>


	<div class="form-group">
		<label for="idTypevisite" class="col-sm-2 control-label">Type de lieu *</label>
		<div class="col-sm-3">
			<div class="row">				
				<select id="idTypevisite" name="idTypevisite">
					<option value="">Choisissez...</option>
					<s:iterator value="listeDesTypevisites">
						<option value="<s:property value="idTypevisite" />"><s:property value="libtypevisite" /></option>
					</s:iterator>
				</select>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
			<div id="idAppelModal">
				<p>
					<a data-toggle="modal" href="#form-content">Ajouter un type</a>
				</p>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="idQuartier" class="col-sm-2 control-label">Quartier *</label>
		<div class="col-sm-3">
			<div class="row">
				<select id="idQuartier" name="idQuartier">
					<option value="">Choisissez...</option>
					<s:iterator value="listeDesQuartiers">
						<option value="<s:property value="idQuartier" />"><s:property value="nom" /></option>
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
				<input type="text" class="form-control" id="idNumero" name="numero" placeholder="Exemple : 1" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie" placeholder="Exemple : place du Gros Caillou"/>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodepostal" class="col-sm-2 control-label">Code postal *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal" name="codePostal" placeholder="Exemple : 69004" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville *</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville" value="Lyon" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<legend>Caractéristiques</legend>
	
	<div class="form-group">
		<label for="idAvecFontaine" class="col-sm-2 control-label">Y a-t-il une fontaine ?</label>
		<div class="col-sm-3">
			<div class="row">
				Oui <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="true"> &nbsp;
				Non <input type="radio" class="form-align" id="idAvecFontaine" name="avecFontaine" value="false">
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idDescription" name="description" rows=4 cols=40 placeholder="Décrivez le monument, son architecture, etc"></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	<div class="form-group">
		<label for="idAccessibilité" class="col-sm-2 control-label">Comment y accéder ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilité" name="accessibilite" rows=4 cols=40 placeholder="Expliquez comment l'on peut s'y rendre"></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">(* : champ obligatoire)</div>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">
				<button type="reset" class="btn btn-default">Etat initial</button>
				<button type="submit" class="btn btn-default">Ajouter ce lieu</button>
			</div>
		</div>
	</div>

</form>

<div id="form-content" class="modal hide fade in" style="display: none;">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>Send me a message</h3>
	</div>
	<div class="modal-body">
		<form class="contact" name="contact">
			<label class="label" for="name">Your Name</label><br>
			<input type="text" name="name" class="input-xlarge"><br>
			<label class="label" for="email">Your E-mail</label><br>
			<input type="email" name="email" class="input-xlarge"><br>
			<label class="label" for="message">Enter a Message</label><br>
			<textarea name="message" class="input-xlarge"></textarea>
		</form>
	</div>
	<div class="modal-footer">
		<input class="btn btn-success" type="submit" value="Ajouter ce type" id="submit">
		<a href="#" class="btn" data-dismiss="modal">Nah.</a>
	</div>
</div>