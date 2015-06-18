<%@ taglib prefix="s" uri="/struts-tags"%>
<h1>Création de votre profil Lyon'Y</h1>

<div id="idFormAlertError" class="alert alert-danger hidden" role="alert">Alerte !</div>
<form class="form-horizontal" method="post" id="idSendCreationUtilisateur" action="<s:url action='sendCreationUtilisateur'/>">

	<div class="form-group">
		<div class="col-sm-offset-1 col-sm-10">
			<div class="row">(* : champ obligatoire)</div>
		</div>
	</div>

	<fieldset>
		<legend>Login</legend>
		<div class="form-group">
			<label for="idNewPseudo" class="col-lg-2 control-label">Pseudo
				*</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idNewPseudo" name="pseudo" placeholder="Pseudo" required />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="idNewMotDePasse" class="col-lg-2 control-label">Mot
				de passe *</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="password" class="form-control" id="idNewMotDePasse" name="motDePasse" placeholder="Mot de Passe" required />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>Informations personnelles</legend>
		<div class="form-group">
			<label for="idDateNaissance" class="col-lg-2 control-label">Date
				de Naissance *</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idDateNaissance" name="dateNaissance" placeholder="aaaa-mm-jj" pattern="\d{4}-\d{2}-\d{2}" required />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="idSexe" class="col-lg-2 control-label">Sexe *</label>
			<div class="row">
				<input type="radio" name="sexe" value="M" required>Homme <input
					type="radio" name="sexe" value="F" required>Femme
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>Contacts et Adresse</legend>
		<div class="form-group">
			<label for="idNewEmail" class="col-lg-2 control-label">Adresse mail *</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-8">
						<input type="text" class="form-control" id="idNewEmail" name="email" placeholder="exemple.exemple@gmail.fr" required />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>

		<div class="form-group">
			<label for="idNumero" class="col-lg-2 control-label">Numéro</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-5">
						<input type="text" class="form-control" id="idNumero" name="numero" placeholder="Exemple : 66" />
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
						<input type="text" class="form-control" id="idVoie" name="voie" placeholder="Exemple : cours Charlemagne" />
					</div>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>

		<div class="form-group">
			<label for="idQuartier" class="col-lg-2 control-label">Quartier *</label>
			<div class="col-lg-4">
				<div class="row">
					<select id="idQuartier" name="quartier">
						<option value="">Choisissez...</option>
							<s:iterator value="listeDesQuartiers">
								<option value="<s:property value="idQuartier" />"><s:property value="nom" /></option>
							</s:iterator>
					</select>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
	
		<div class="form-group">
			<label for="idCodepostal" class="col-lg-2 control-label">Code postal *</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-5">
						<input type="text" class="form-control" id="idCodepostal" name="codePostal" placeholder="Exemple : 69002" />
					</div>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>

		<div class="form-group">
			<label for="idVille" class="col-lg-2 control-label">Ville *</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-4">
						<input type="text" class="form-control" id="idVille" name="ville"
							value="Lyon" />
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
						<input type="text" class="form-control" id="idAvatar" name="avatar" />
					</div>
					<span class="col-lg-20 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>

	<div class="form-group">
		<div class="row">
			<input type="submit" value="Créer le compte" />
			<input type="reset" value="Etat initial" />
		</div>
	</div>
</form>
