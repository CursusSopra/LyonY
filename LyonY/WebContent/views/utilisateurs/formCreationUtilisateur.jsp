<%@ taglib prefix="s" uri="/struts-tags"%>
<h1>Création de votre profil Lyon'Y</h1>

<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">Alerte !</div>
<form class="form-horizontal" method="post"
	id="idSendCreationUtilisateur"
	action="<s:url action='sendCreationUtilisateur'/>">
	<fieldset>
		<legend>Login</legend>
		<div class="form-group">
			<label for="idNewPseudo" class="col-lg-4 control-label">Pseudo</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idNewPseudo"
							name="pseudo" placeholder="Pseudo" required />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="idNewMotDePasse" class="col-lg-4 control-label">Mot
				de passe</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="password" class="form-control" id="idNewMotDePasse"
							name="motDePasse" placeholder="Mot de Passe" required />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>Informations personnelles</legend>
		<div class="form-group">
			<label for="idNewEmail" class="col-lg-4 control-label">Adresse
				mail</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idNewEmail" name="email"
							placeholder="exemple.exemple@gmail.fr" required />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="idDateNaissance" class="col-lg-4 control-label">Date
				de Naissance</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idDateNaissance"
							name="dateNaissance" placeholder="aaaa-mm-jj" pattern="\d{4}-\d{2}-\d{2}" required />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="idSexe" class="col-lg-4 control-label">Sexe</label>
			<div class="row">
				<input type="radio" name="sexe" value="M" required>Homme 
				<input type="radio" name="sexe" value="F" required>Femme 
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
							name="avatar" />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>


	<input type="submit" value="Créer le compte" />
</form>
