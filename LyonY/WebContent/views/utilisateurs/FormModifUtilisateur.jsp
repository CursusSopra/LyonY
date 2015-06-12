<%@ taglib prefix="s" uri="/struts-tags"%>
<h1>Modification de votre profil utilisateur Lyon'Y</h1>

<form class="form-horizontal" method="post" id="idSendModifUtilisateur"
	action="<s:url action='sendModifUtilisateur'/>">
	<input type="hidden" value="<s:property value='idUtilisateur'/>" name="idUtilisateur" />
	<fieldset>
		<legend>Login</legend>
		<div class="form-group">
			<label for="idPseudo" class="col-lg-4 control-label">Pseudo</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idPseudo"
							name="pseudo" value="<s:property value='utilisateur.pseudo' />" />
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
							value="<s:property value='utilisateur.motDePasse' />" />
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
							value="<s:property value='utilisateur.email' />" />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>

		<!-- 			<div class="form-group"> -->
		<!-- 				<label for="idDateNaissance" class="col-lg-4 control-label">Date de Naissance</label> -->
		<!-- 				<div class="col-lg-4"> -->
		<!-- 					<div class="row"> -->
		<!-- 						<div class="col-lg-6"> -->
		<!-- 							<input type="text" class="form-control" id="idDateNaissance" -->
		<!-- 								name="dateNaissance" placeholder="aaaa-mm-jj"/> -->
		<!-- 						</div> -->
		<%-- 						<span class="col-lg-6 control-label">&nbsp;</span> --%>
		<!-- 					</div> -->
		<!-- 				</div> -->
		<!-- 			</div> -->

		<!-- 			<div class="form-group"> -->
		<!-- 				<label for="idSexe" class="col-lg-4 control-label">Sexe</label> -->
		<!-- 				<div class="row"> -->
		<!-- 					<input type="radio" name="sexe" value="male">Homme  -->
		<!-- 					<input type="radio" name="sexe" value="female">Femme -->
		<!-- 				</div> -->
		<!-- 			</div> -->
	</fieldset>

	<fieldset>
		<legend>Optionnel</legend>
		<div class="form-group">
			<label for="idAvatar" class="col-lg-4 control-label">Avatar</label>
			<div class="col-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<input type="text" class="form-control" id="idAvatar"
							name="avatar" value="<s:property value='utilisateur.avatar' />" />
					</div>
					<span class="col-lg-6 control-label">&nbsp;</span>
				</div>
			</div>
		</div>
	</fieldset>


	<input type="submit" value="Modifier le compte" />
</form>
