<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<a href="<s:url action='index'/>">Retour à la page d'accueil</a>

<h1>Bars de Lyon</h1>




	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">

				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>Nom du bar</th>
							<th>Ambiance</th>
							<th colspan="2">Fourchette de prix</th>
							<th>Popularité</th>
							<th>Quartier</th>
						</tr>
					</thead>

					<tbody>
						<s:iterator value="listeDesCandidats">
							<s:url action="detailsCandidat" var = "dc">
							<s:param name ="idCandidat">
							<s:property value="idCandidat"/>
							</s:param>
							</s:url>
							
							<tr>
								<td>
									<a href="<s:property value='#dc'/>"> <s:property value="nom" />
									</a>
								</td>
								
								<td><s:property value="ambiance" /></td>
								
								<td colspan="2"><s:property value="fourchettePrix" /> 
								
								<td <s:property value="popularité" /> ></td>

								<td><s:property value="quartier" /></td>
							</tr>
						</s:iterator>

					</tbody>

				</table>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

	<script type="text/javascript" src="js/jQuery/jquery-2.1.1.min.js"></script>