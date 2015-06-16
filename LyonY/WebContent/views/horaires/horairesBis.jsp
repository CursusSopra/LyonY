<%@ taglib prefix="s" uri="/struts-tags"%>


<style>
#slider {
	width: 200px;
}

.ui-slider .ui-slider-handle { //for horizontal 
	width:200px;
	margin-left: -15px;
}
</style>

<table id="Horaires">
	<s:iterator value="{1,2,3,4,5,6,7}" status="idx">
		<tr>
			<td style="width: 100px" align="center"><s:property
					value="#idx.count" /></td>
			<td style="width: 250px"><div id="slider-range${idx.count}"></div></td>
			<td style="width: 200px" align="center"><span
				id="time${idx.count}" data-rang="<s:property value = "#idx.count"/>"></span>
			</td>
		</tr>
	</s:iterator>
</table>

<input type="submit" name="scheduleSubmit" value="Submit"
	id="scheduleSubmit" class="ui-button ui-state-default ui-corner-all" />

<table id="Schedule">
	<thead>
		<tr>
			<th>Start Time</th>
			<th>End Time</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

