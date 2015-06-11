<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LyonY <tiles:getAsString name="title" /></title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<tiles:insertAttribute name="menuConnexion" />
	<tiles:insertAttribute name="body" />
	
	<a href="<s:url action='sorties'/>">Sorties</a>
	<script type="text/javascript" src="js/jQuery/jquery-2.1.1.min.js"></script>
</body>
</html>