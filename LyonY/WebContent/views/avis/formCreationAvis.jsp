
<%@ taglib prefix="s" uri="/struts-tags"%>

	<h1>Creation d'un nouvel avis</h1>
	
	
	<form class="form-horizontal" method="post" id="idFormCreationAvis" action="<s:url action='creationAvis'/>">
		
<!-- 		// -->
<!-- 		//Ne pas oublier de mettre champs cachés pour idlieu et id utilisateur -->
<!-- 		// -->
<!-- 		// -->
		
		
		<div class="form-group">
			<label for="idAvisNote" class="col-sm-2 control-label">Note:</label>
			<div class="col-sm-3">
				<div class="row">
					<input type="text" class="form-control" id="idAvisNote" name="note" placeholder="Donner une note sur 5."/>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
		
		<div class="form-group">
			<label for="idAvisMessage" class="col-sm-2 control-label">Avis</label>
			<div class="col-sm-3">
				<div class="row">
					<TEXTAREA id="idAvisMessage" name="message" rows=4 cols=40 placeholder="Donner votre avis"></TEXTAREA>
				</div>
				<span class="col-lg-20 control-label">&nbsp;</span>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="row">
					<button type="reset" class="btn btn-default">Etat initial</button>
					<button type="submit" class="btn btn-default">Soumettre mon avis</button>
				</div>
			</div>
		</div>
		
		
	</form>