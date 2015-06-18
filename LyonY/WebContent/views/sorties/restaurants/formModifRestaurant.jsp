<%@ taglib prefix="s" uri="/struts-tags"%>


<h1>Modification d'un restaurant</h1>

<form class="form-horizontal" method="post" id="idFormModifRestaurant"
	action="<s:url action='modifRestaurant'/>">

	<input type="hidden" id="idRestaurant" name="idRestaurant"
		value="<s:property value = "restaurant.idRestaurant"/>" />

	<div id="idFormAlertError" class="alert alert-danger hidden"
		role="alert">Le formulaire contient des erreurs. Veuillez
		réessayer</div>

<fieldset>
	<legend>Identification du Restaurant</legend>
	<div class="form-group">
		<label for="idNom" class="col-sm-2 control-label">Nom du
			Restaurant</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNom"
					name="nomrestaurant"
					value="<s:property value = "restaurant.nomrestaurant"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>


	
	<div class="form-group">
		<label for="idAmbiance" class="col-sm-2 control-label">Ambiance</label>
		<div class="col-sm-3">
			<div class="row">
				<select id="idAmbiance" name="idAmbiance">
					<s:iterator value="listeDesAmbiances">
						<option value="<s:property value="idAmbiance" />"
							${restaurant.libambiance == libambiance ? 'selected' : ''}><s:property
								value="libambiance" /></option>
					</s:iterator>
				</select>
			</div>
			<div class="row">
				<a href="<s:url action='creationAmbiance'/>">Ajouter une
					ambiance</a>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idQuartier" class="col-sm-2 control-label">Quartier</label>
		<div class="col-sm-3">
			<div class="row">
				<select id="idQuartier" name="idQuartier"">
					<s:iterator value="listeDesQuartiers">
						<option value="<s:property	value="idQuartier" />"
							${restaurant.nomquartier == nom ? 'selected' : ''}>


							<s:property value="nom" />
						</option>
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
		<label for="idNumero" class="col-sm-2 control-label">Numéro</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idNumero" name="numero"
					value="<s:property value = "restaurant.numero"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVoie" class="col-sm-2 control-label">Voie</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVoie" name="voie"
					value="<s:property value = "restaurant.voie"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idCodepostal" class="col-sm-2 control-label">Code
			postal</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idCodepostal"
					name="codePostal"
					value="<s:property value = "restaurant.codePostal"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idVille" class="col-sm-2 control-label">Ville</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idVille" name="ville"
					value="<s:property value = "restaurant.ville"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
	
	</fieldset>

<fieldset>
	<legend>Caractéristiques</legend>

	<div class="form-group">
		<label for="idDescription" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA name="description" rows=4 cols=40
					><s:property value = "restaurant.description"/></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAccessibilité" class="col-sm-2 control-label">Comment
			y accéder ?</label>
		<div class="col-sm-3">
			<div class="row">
				<TEXTAREA id="idAccessibilité" name="accessibilite" rows=4 cols=40
					><s:property value = "restaurant.accessibilite"/></TEXTAREA>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idPrixmin" class="col-sm-2 control-label">Prix
			mini</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idPrixmin"
					name="prixmin" value="<s:property value = "restaurant.prixmin"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idPrixmax" class="col-sm-2 control-label">Prix
			maxi</label>
		<div class="col-sm-3">
			<div class="row">
				<input type="text" class="form-control" id="idPrixmax"
					name="prixmax" value="<s:property value = "restaurant.prixmax"/>" />
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idReservation" class="col-sm-2 control-label">Réservation</label>
		<div class="col-sm-3">
			<div class="row">
				Oui
				<s:if test="%{restaurant.reservation}">
					<input type="radio" class="form-align" id="idReservation"
						name="reservation" value="true" checked />
					&nbsp; Non <input type="radio" class="form-align"
						id="idReservation" name="reservation" value="false" />
				</s:if>
				<s:else>
					<input type="radio" class="form-align" id="idReservation"
						name="reservation" value="true" />
					&nbsp; Non <input type="radio" class="form-align"
						id="idReservation" name="reservation" value="false" checked />
				</s:else>

			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>

	<div class="form-group">
		<label for="idAemporter" class="col-sm-2 control-label">A
			emporter</label>
		<div class="col-sm-3">
			<div class="row">	
				Oui
				<s:if test="%{restaurant.aemporter}">
					<input type="radio" class="form-align" id="idAemporter"
						name="aemporter" value="true" checked />
					&nbsp; Non <input type="radio" class="form-align"
						id="idAemporter" name="aemporter" value="false" />
				</s:if>
				<s:else>
					<input type="radio" class="form-align" id="idAemporter"
						name="aemporter" value="true" />
					&nbsp; Non <input type="radio" class="form-align"
						id="idAemporter" name="aemporter" value="false" checked />
				</s:else>
			</div>
			<span class="col-lg-20 control-label">&nbsp;</span>
		</div>
	</div>
</fieldset>

<fieldset>
	<legend>Horaires</legend>
</fieldset>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="row">
				<button type="submit" class="btn btn-default">Envoyer</button>
			</div>
		</div>
	</div>

</form>
