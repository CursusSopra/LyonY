<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LyonY <tiles:getAsString name="title" /></title>
<link href="css/bootstrap.css" rel="stylesheet">
	
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
	<tiles:insertAttribute name="menuConnexion" />
	<tiles:insertAttribute name="body" />
	
	<a href="<s:url action='sorties'/>">Sorties</a><br/>
	<a href="<s:url action='visites'/>">Visites</a>
	<script type="text/javascript" src="js/jQuery/jquery-2.1.1.min.js"></script>
	
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