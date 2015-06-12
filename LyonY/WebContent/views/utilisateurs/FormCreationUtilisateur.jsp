<%@ taglib prefix="s" uri="/struts-tags" %>
	<h1>Création de votre profil Lyon'Y</h1>

	<form class="form-horizontal" method="post" id="idSendCreationUtilisateur"
		action="<s:url action='SendCreationUtilisateur'/>">
		<fieldset>
			<legend>Login</legend>
			<div class="form-group">
				<label for="idPseudo" class="col-lg-4 control-label">Pseudo</label>
				<div class="col-lg-4">
					<div class="row">
						<div class="col-lg-6">
							<input type="text" class="form-control" id="idPseudo"
								name="pseudo" placeholder="Pseudo" required />
						</div>
						<span class="col-lg-6 control-label">&nbsp;</span>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="idMotDePasse" class="col-lg-4 control-label">Mot de passe</label>
				<div class="col-lg-4">
					<div class="row">
						<div class="col-lg-6">
							<input type="text" class="form-control" id="idMotDePasse"
								name="motDePasse" required />
						</div>
						<span class="col-lg-6 control-label">&nbsp;</span>
					</div>
				</div>
			</div>
		</fieldset>

		<fieldset>
			<legend>Informations personnelles</legend>
			<div class="form-group">
				<label for="idEmail" class="col-lg-4 control-label">Adresse mail</label>
				<div class="col-lg-4">
					<div class="row">
						<div class="col-lg-6">
							<input type="text" class="form-control" id="idEmail"
								name="email" placeholder="exemple.exemple@gmail.fr" required />
						</div>
						<span class="col-lg-6 control-label">&nbsp;</span>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="idDateNaissance" class="col-lg-4 control-label">Date de Naissance</label>
				<div class="col-lg-4">
					<div class="row">
						<div class="col-lg-6">
							<input type="text" class="form-control" id="idDateNaissance"
								name="dateNaissance" placeholder="aaaa-mm-jj"/>
						</div>
						<span class="col-lg-6 control-label">&nbsp;</span>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="idSexe" class="col-lg-4 control-label">Sexe</label>
				<div class="row">
					<input type="radio" name="sexe" value="male">Homme 
					<input type="radio" name="sexe" value="female">Femme
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
