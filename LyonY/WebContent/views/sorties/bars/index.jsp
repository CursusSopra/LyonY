<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-md-3 col-sm-3 col-xs-6">
		<div class="dashboard-div-wrapper bk-clr-one">
			<a href="<s:url action='listeDesBars' namespace='' />">
				<i class="fa fa-glass dashboard-div-icon"></i> 
				<h4>Les bars où Lyon'Y a bu</h4>
			</a>
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-6">
		<div class="dashboard-div-wrapper bk-clr-two">
			<i class="fa fa-edit dashboard-div-icon"></i>
			<h4>Simple Text Here</h4>
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-6">
		<div class="dashboard-div-wrapper bk-clr-three">
			<i class="fa fa-cogs dashboard-div-icon"></i>
			<h4>Simple Text Here</h4>
		</div>
	</div>
	<div class="col-md-3 col-sm-3 col-xs-6">
		<div class="dashboard-div-wrapper bk-clr-four">
			<i class="fa fa-bell-o dashboard-div-icon"></i>
			<h4>Simple Text Here</h4>
		</div>
	</div>

</div>