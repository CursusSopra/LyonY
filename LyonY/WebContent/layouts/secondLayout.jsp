<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>LyonY <tiles:getAsString name="title" /></title>
<!-- BOOTSTRAP CORE STYLE  -->
<link href="_theme/css/bootstrap.css" rel="stylesheet" />
<!-- FONT AWESOME ICONS  -->
<link href="_theme/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="_theme/css/style.css" rel="stylesheet" />
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
<!-- ================================================== -->
<!--                  Extra CSS                         -->
<tiles:useAttribute name="moreStyles" scope="request" ignore="true" />
<c:if test="${not empty moreStyles}">
	<c:forEach items="${moreStyles}" var="cssFile">
		<link href="./${cssFile}" media="all" rel="stylesheet" type="text/css" />
	</c:forEach>
</c:if>

<tiles:useAttribute name="moreHttpStyles" scope="request" ignore="true" />
<c:if test="${not empty moreHttpStyles}">
	<c:forEach items="${moreHttpStyles}" var="cssFile">
		<link href="${cssFile}" media="all" rel="stylesheet" type="text/css" />
	</c:forEach>
</c:if>
<!-- ================================================== -->
</head>
<body>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<strong>Email: </strong>info@yourdomain.com &nbsp;&nbsp; <strong>Support:
					</strong>+90-897-678-44
				</div>

				<div class="col-md-8">
					<form class="form-inline"  id="idConnexion" name="Connexion" method="POST" action="<s:url action='ConnexionUtilisateur' />">
	  					<div class="form-group">
	    					<label for="exampleInputName2">Identifiant</label>
	    					<input type="text" class="form-control" id="idPseudo" name="pseudo" required>
	  					</div>
	  					<div class="form-group">
		    				<label for="exampleInputEmail2">Mot de passe</label>
		    				<input type="password" class="form-control" id="idMotDePasse" name="motDePasse" required>
					  	</div>
					  	<button type="submit" class="btn btn-default">Connexion</button>
					</form>
				
				
				
				
<%-- 				<form id="idConnexion" name="Connexion" method="POST" action="<s:url action='ConnexionUtilisateur' />"> --%>
<!-- 			Identifiant:<input type="text" name="pseudo" required -->
<!-- 				placeholder="Identifiant" /> Mot de passe:<input type="password" -->
<!-- 				name="motDePasse" required placeholder="Mot de passe" /> <input -->
<!-- 				type="submit" value="Connexion" /> -->
<!-- 		</form> -->
					<a href='<s:url action="FormCreationUtilisateur"/>'>Inscription</a>
				</div>
			</div>
		</div>
	</header>
	<!-- HEADER END-->
	<div class="navbar navbar-inverse set-radius-zero">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"> <img
					src="_theme/img/logo.png" />
				</a>

			</div>

			<div class="left-div">
				<div class="user-settings-wrapper">
					<ul class="nav">

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#" aria-expanded="false"> <span
								class="glyphicon glyphicon-user" style="font-size: 25px;"></span>
						</a>
							<div class="dropdown-menu dropdown-settings">
								<div class="media">
									<a class="media-left" href="#"> <img
										src="_theme/img/64-64.jpg" alt="" class="img-rounded" />
									</a>
									<div class="media-body">
										<h4 class="media-heading">Jhon Deo Alex</h4>
										<h5>Developer & Designer</h5>

									</div>
								</div>
								<hr />
								<h5>
									<strong>Personal Bio : </strong>
								</h5>
								Anim pariatur cliche reprehen derit.
								<hr />
								<a href="#" class="btn btn-info btn-sm">Full Profile</a>&nbsp; <a
									href="login.html" class="btn btn-danger btn-sm">Logout</a>

							</div></li>


					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- LOGO HEADER END-->
	<section class="menu-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="navbar-collapse collapse ">
						<ul id="menu-top" class="nav navbar-nav navbar-right">
							<li><a class="menu-top-active" href="index.html">Lyon'Y ...</a></li>
							<li><a href="ui.html">Lyon'Y Sort</a></li>
							<li><a href="table.html">Lyon'Y Mange</a></li>
							<li><a href="forms.html">Lyon'Y Boit</a></li>
							<li><a href="login.html">Lyon'Y Visite</a></li>
							<li><a href="blank.html">Lyon'Y Danse</a></li>

						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- BREADCRUMBS -->
					<ol class="breadcrumb">
						<s:iterator value="listeBreadcrumbs">
							<s:set var="targetAction" value="action" />
							<s:set var="myPar" value="queryString" />
							<s:url action="%{#targetAction}" var="act">
							</s:url>
							<li><a href="<s:property value='#act' /><s:property value='queryString' />"><s:property value='nom' /></a></li>
						</s:iterator>
						<li class="active"><tiles:getAsString name="title" /></li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<tiles:insertAttribute name="body" />
				</div>

			</div>
		</div>
	</div>
	<!-- CONTENT-WRAPPER SECTION END-->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					&copy; 2015 YourCompany | By : <a
						href="http://www.designbootstrap.com/" target="_blank">DesignBootstrap</a>
				</div>

			</div>
		</div>
	</footer>
	<!-- FOOTER SECTION END-->
	<!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- CORE JQUERY SCRIPTS -->
	<script type="text/javascript" src="js/jQuery/jquery-2.1.1.min.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="_theme/js/bootstrap.js"></script>
	
	<!-- ================================================== -->
	<!--                  Extra JavaScript                  -->
	<tiles:useAttribute name="moreHttpScripts" scope="request" ignore="true" />
	<c:if test="${not empty moreHttpScripts}">
		<c:forEach items="${moreHttpScripts}" var="jsFile">
			<script type="text/javascript" src="${jsFile}"></script>
		</c:forEach>
	</c:if>

	<tiles:useAttribute name="moreScripts" scope="request" ignore="true" />
	<c:if test="${not empty moreScripts}">
		<c:forEach items="${moreScripts}" var="jsFile">
			<script type="text/javascript" src="./${jsFile}"></script>
		</c:forEach>
	</c:if>	
	<!-- ================================================== -->
</body>
</html>
