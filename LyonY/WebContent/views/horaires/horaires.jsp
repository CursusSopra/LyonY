<%@ taglib prefix="s" uri="/struts-tags"%>

<a href="<s:url action='index'/>">Retour à la page d'accueil</a>


<style>
    #slider-range{width:200px;}
</style>
<table id="Horaires" >
	<s:iterator value="{1,2,3}" status="idx">
		<tr>
			<th style="width:100px"> <s:property value = "#idx.count"/> </th>
			<th style="width:250px"><div class="slider" id="slider-range"></div></th>
			<th style="width:100px"> <span id="time"></span> </th>
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


