<%@ taglib prefix="s" uri="/struts-tags"%>


<style>
#slider {
	width: 200px;
}

.ui-slider .ui-slider-handle { //for horizontal width:200px;
	margin-left: -15px;
}
</style>

<form method="post" id="idFormCreationHoraire">

<!--  Affichage des sliders par jour -->
	<table id="Horaires">
		<s:iterator value="jours" status="idx">
			<tr>
				<td style="width: 100px" align="center"><s:property /></td>
				<td style="width: 250px"><div id="slider-range${idx.count}"></div></td>
				<td style="width: 200px" align="center"><span id="time"
					data-rang="<s:property value = "#idx.count"/>"></span></td>
			</tr>
		</s:iterator>
	</table>
<!-- Bouton submit -->
	<input type="submit" name="scheduleSubmit" value="Submit"
		id="scheduleSubmit" class="ui-button ui-state-default ui-corner-all" />
	<input type="hidden" id="idTimeString" name="timeString"/>
</form>



