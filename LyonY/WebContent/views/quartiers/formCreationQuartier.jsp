<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>


<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->


<!-- <title>Création d'un nouveau quartier</title> -->
<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->
<!-- </head> -->
<!-- <body> -->

<!-- 	<!-- ************************************************** --> -->

<!-- 	<br /> -->
<!-- 	<br /> -->

<!-- 	<div class="row"> -->
<!-- 		<div class="col-lg-offset-3 col-lg-3 col-sm-offset-3 col-sm6"> -->
<%-- 			<section class="content-wrapper main-content clear-fix"> --%>

<!-- 				<div id="idFormAlertError" class="alert alert-danger hidden" -->
<!-- 					role="alert">Alerte !</div> -->

				<!-- ******************************************************************************* -->
	
	<h1>Création d'un nouveau quartier</h1>


				<form class="form-horizontal" method="post"
					id="idSendCreationQuartier"
					action="<s:url action='SendCreationQuartier'/>">

					<fieldset>
					<div class="form-group">
						<label for="idNom" class="col-lg-4 control-label">Nom</label>
						<div class="col-lg-4">
							<div class="row">
								<div class="col-lg-6">
									<input type="text" class="form-control" id="idNom" name="nom"
										placeholder="Nom" required />
								</div>
								<span class="col-lg-6 control-label">&nbsp;</span>
							</div>
						</div>
					</div>
					</fieldset>
					
					<fieldset>

						<legend>Description</legend>

						<div class="form-group">
							<label for="idBudgetMoyen" class="col-lg-4 control-label">Budget
								Moyen</label>
							<div class="col-lg-4">
								<div class="row">
									<div class="col-lg-6">
										<input type="text" class="form-control" id="idBudgetMoyen"
											name="budgetMoyen" required />
									</div>
									<span class="col-lg-6 control-label">&nbsp;</span>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="idDistanceCentreVille" class="col-lg-4 control-label">Distance
								du centre-ville</label>
							<div class="col-lg-4">
								<div class="row">
									<div class="col-lg-6">
										<input type="text" class="form-control"
											id="idDistanceCentreVille" name="distanceCentreVille"
											required />
									</div>
									<span class="col-lg-6 control-label">&nbsp;</span>
								</div>
							</div>
						</div>

					</fieldset>
				<input type="submit" value="Créer le quartier" /> <a

				</form>

				<!-- ******************************************************************************* -->


<!-- 				<input type="submit" value="Créer le compte" /> <a -->
<%-- 					href="<s:url action='listeDesCandidats'/>">Retour</a> --%>
<%-- 			</section> --%>
<!-- 		</div> -->
<!-- 	</div> -->


<%-- 	</script> --%>

<!-- 	<!-- 	AJAX = asynchronius javascript xml --> -->



<!-- 	<!-- ************************************************** --> -->


<%-- 	<script type="text/javascript" src="js/jQuery/jquery-2.1.1.min.js"></script> --%>

<!-- </body> -->
<!-- </html> -->









