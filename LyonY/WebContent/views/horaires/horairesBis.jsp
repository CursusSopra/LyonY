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


