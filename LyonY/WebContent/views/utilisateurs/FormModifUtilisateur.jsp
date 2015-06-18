<%@ taglib prefix="s" uri="/struts-tags"%>
<h1>Bonjour <s:property value='pseudo'/>, <br>Vous êtes sur le point de modifier votre profil utilisateur Lyon'Y.</h1>

<form class="form-horizontal" method="post" id="idSendModifUtilisateur" action="<s:url action='sendModifUtilisateur'/>">
	<input type="hidden" name="idUtilisateur" value="<s:property value='idUtilisateur'/>" />
	<input type ="hidden" name="idAdresse" value="<s:property value='idAdresse'/>"/>
	<input type ="hidden" name="idQuartier" value="<s:property value='idQuartier'/>"/>
	
	<fieldset>
		<legend>Login</legend>
		<div class="form-group">
			<label for="idNewPseudo" class="col-lg-2 control-label">Pseudo</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idNewPseudo"
							name="pseudo" value="<s:property value='pseudo' />" />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="idNewMotDePasse" class="col-lg-2 control-label">Entrez
				votre nouveau mot de passe</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idNewMotDePasse"
							name="motDePasse"
							value="<s:property value='motDePasse' />" />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>Contacts et Adresse</legend>
		<div class="form-group">
			<label for="idNewEmail" class="col-lg-2 control-label">Adresse
				mail</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idNewEmail" name="email" value="<s:property value='email' />" />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>
	
	<fieldset>
	<div class="form-group">
			<label for="idNumero" class="col-lg-2 control-label">Numéro</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-5">
						<input type="text" class="form-control" id="idNumero" name="numero" value="<s:property value='adresse.numero' />" />
					</div>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>

		<div class="form-group">
			<label for="idVoie" class="col-lg-2 control-label">Voie</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-10">
						<input type="text" class="form-control" id="idVoie" name="voie" value="<s:property value='adresse.voie' />" />
					</div>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>

		<div class="form-group">
			<label for="idQuartier" class="col-lg-2 control-label">Quartier</label>
			<div class="col-lg-4">
				<div class="row">
					<select id="idQuartier" name="quartier">
						<option value="" /> <s:property value="adresse.quartier.nom"/>  </option>
							<s:iterator value="listeDesQuartiers">
								<option value="<s:property value="idQuartier" />"> <s:property value="nom" /> </option>
							</s:iterator>
					</select>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	
		<div class="form-group">
			<label for="idCodepostal" class="col-lg-2 control-label">Code postal</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-5">
						<input type="text" class="form-control" id="idCodepostal" name="codePostal" value="<s:property value='adresse.codePostal' />" />
					</div>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>

		<div class="form-group">
			<label for="idVille" class="col-lg-2 control-label">Ville</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-4">
						<input type="text" class="form-control" id="idVille" name="ville" value="<s:property value='adresse.ville' />" />
					</div>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>Optionnel</legend>
		<div class="form-group">
			<label for="idAvatar" class="col-lg-2 control-label">Avatar</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idAvatar" name="avatar" value="<s:property value='avatar' />" />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>

	<div class="form-group">
		<div class="row">
			<input type="submit" value="Modifier le compte" />
			<input type="reset" value="Etat initial" />
		</div>
	</div>
</form>
