<%@ taglib prefix="s" uri="/struts-tags"%>


<style>
.tooltip {
	display: block;
	position: absolute;
	border: 1px solid #D9D9D9;
	font: 400 12px/12px Arial;
	border-radius: 3px;
	background: #fff;
	top: -43px;
	padding: 5px;
	left: -9px;
	text-align: center;
	width: 50px;
}
</style>

<form method="post" id="idFormCreationHoraire" action="<s:url action='creationHoraire'/>">

<!--  Affichage des sliders par jour -->
	<table id="Horaires">
		<s:iterator value="jours" status="idx">
			<tr>
				<td style="width: 100px" align="center"><s:property /></td>
				<td style="width: 250px"><div id="slider-range${idx.count}"></div></td>
				<td style="width: 200px" align="center"><span id="time"
					data-rang="<s:property value = "#idx.count"/>">10:00 - 19:00</span></td>
			</tr>
		</s:iterator>
	</table>
<!-- Bouton submit -->
	<input type="submit" name="scheduleSubmit" value="Submit"
		id="scheduleSubmit" class="ui-button ui-state-default ui-corner-all" />
	<input type="hidden" id="idTimeString" name="timeString"/>
	<input type="hidden" id="idIdSortie" name="idSortie" value="${idSortie}"/>
</form>



