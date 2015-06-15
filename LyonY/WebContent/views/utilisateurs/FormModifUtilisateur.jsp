<%@ taglib prefix="s" uri="/struts-tags"%>
<h1>Bonjour <s:property value='pseudo'/>, <br>Vous êtes sur le point de modifier votre profil utilisateur Lyon'Y.</h1>

<form class="form-horizontal" method="post" id="idSendModifUtilisateur"
	action="<s:url action='sendModifUtilisateur'/>">
	<input type="hidden" name="idUtilisateur" value="<s:property value='idUtilisateur'/>" />
	<fieldset>
		<legend>Login</legend>
		<div class="form-group">
			<label for="idPseudo" class="col-lg-4 control-label">Pseudo</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idPseudo"
							name="pseudo" value="<s:property value='pseudo' />" />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="idMotDePasse" class="col-lg-4 control-label">Entrez
				votre nouveau mot de passe</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idMotDePasse"
							name="motDePasse"
							value="<s:property value='motDePasse' />" />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>Informations personnelles</legend>
		<div class="form-group">
			<label for="idEmail" class="col-lg-4 control-label">Adresse
				mail</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idEmail" name="email"
							value="<s:property value='email' />" />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>

	</fieldset>

	<fieldset>
		<legend>Optionnel</legend>
		<div class="form-group">
			<label for="idAvatar" class="col-lg-4 control-label">Avatar</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idAvatar"
							name="avatar" value="<s:property value='avatar' />" />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>


	<input type="submit" value="Modifier le compte" />
</form>
