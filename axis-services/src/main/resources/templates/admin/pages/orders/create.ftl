<#import "/spring.ftl" as spring />
<#import "../../lib/head.ftl" as head />
<#import "../../lib/preloader.ftl" as preloader />
<#import "../../lib/topbar.ftl" as topbar />
<#import "../../lib/leftbar.ftl" as leftbar />
<#import "../../lib/rightbar.ftl" as rightbar />
<#import "../../lib/footer.ftl" as footer />
<#import "../../lib/jquery_scripts.ftl" as jscripts />
<#assign xhtmlCompliant = true in spring />
<#assign aDateTime = .now>
<#assign aDate = aDateTime?date>
<!DOCTYPE html>
<html lang="en">

<head>
    <@head.nav pageTitle="Axis BPS - Order Entry" />
    <!-- page CSS -->
    <link href="/css/orders/create.css" rel="stylesheet" type="text/css" />
    <link href="/assets/node_modules/bootstrap-datepicker/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css" />
    <link href="/assets/node_modules/select2/dist/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="/assets/node_modules/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
    <!--Toaster Popup message CSS -->
	<link href="/assets/node_modules/toast-master/css/jquery.toast.css" rel="stylesheet">
</head>

<body class="skin-blue fixed-layout">
    <@preloader.nav />
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <@topbar.nav />
        <@leftbar.nav />
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h4 class="text-themecolor">Create SOR (Service Order Request)</h4>
                    </div>
                    <div class="col-md-7 align-self-center text-right">
                        <div class="d-flex justify-content-end align-items-center">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="javascript:void(0)">Orders</a></li>
                                <li class="breadcrumb-item active">Create</li>
                            </ol>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- row -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                        	<div class="card-header bg-info">
                                <h4 class="mb-0 text-white">Service Order Request - New</h4>
                            </div>
                            <div class="card-body">
                            	<form name="serviceOrderForm" id="serviceOrderForm" action="/orders/create" method="POST" class="mt-4">
                            		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            		<div class="form-body">
                            			<h3 class="card-title">Service Entities</h3>
                                        <hr>
                                        <div class="row p-t-20">
	                            			<div class="col-md-12 ">
	                            				<div class="form-group">
			                                        <label for="customer">Customer</label>
			                                        <input name="customer" required type="text" class="form-control" id="customer" aria-describedby="customerHelp" placeholder="Enter customer name" />
			                                        <small id="customerHelp" class="form-text text-muted">Use customer name or code by catalog.</small>
			                                    </div>
			                                    <!-- /form-group (customer) -->
											</div>
											<!-- /column (customer) -->
										</div>
										<!-- /row (customer) -->
										<div class="row">
	                            			<div class="col-md-12 ">
	                            				<div class="form-group">
			                                        <label for="shipper">Shipper</label>
			                                        <input name="shipper" type="text" class="form-control" id="shipper" aria-describedby="shipperHelp" placeholder="Enter shipper name" />
			                                        <small id="shipperHelp" class="form-text text-muted">Use shipper company name or code by catalog.</small>
			                                    </div>
			                                    <!-- /form-group (shipper) -->
											</div>
											<!-- /column (shipper) -->
										</div>
										<!-- /row (shipper) -->
										<div class="row">
                            				<div class="col-md-12 ">
                            					<div class="form-group">
		                                        	<label for="consignee">Consignee</label>
		                                        	<input name="consignee" type="text" class="form-control" id="consignee" aria-describedby="consigneeHelp" placeholder="Enter consignee name" />
		                                        	<small id="consigneeHelp" class="form-text text-muted">Use consignee company name or code by catalog.</small>
		                                    	</div>
		                                    	<!-- /form-group (consignee) -->
											</div>
											<!-- /column (consignee) -->
										</div>
										<!-- /row (consignee) -->
										<div class="row">
                            				<div class="col-md-12 ">
                            					<div class="form-group">
		                                        	<label for="carrier">Carrier</label>
		                                        	<input name="carrier" type="text" class="form-control" id="carrier" aria-describedby="carrierHelp" placeholder="Enter carrier name" />
		                                        	<small id="carrierHelp" class="form-text text-muted">Use carrier company name or code by catalog.</small>
		                                    	</div>
		                                    	<!-- /form-group (carrier) -->
											</div>
											<!-- /column (carrier) -->
										</div>
										<!-- /row (carrier) -->
										<h3 class="box-title m-t-40">Reference Numbers</h3>
                                        <hr>
                                        <div class="row">
                                        	<div class="col-md-6 ">
                                        		<div class="form-group">
			                                        <label for="customerRef">Customer Ref</label>
			                                        <input name="customerRef" type="text" class="form-control" id="customerRef" aria-describedby="customerRefHelp" placeholder="Enter customer reference" />
			                                        <small id="customerRefHelp" class="form-text text-muted">Use purchase order number or other customer reference to this requirement.</small>
			                                    </div>
			                                    <!-- /form-group (customer ref) -->
                                        	</div>
                                        	<!-- /column (customer ref) -->
                                        	<div class="col-md-6 ">
                                        		<div class="form-group">
			                                        <label for="vendorRef">Vendor Ref</label>
			                                        <input name="vendorRef" type="text" class="form-control" id="vendorRef" aria-describedby="vendorRefHelp" placeholder="Enter vendor reference" />
			                                        <small id="vendorRefHelp" class="form-text text-muted">Use sales order number or other vendor reference to this requirement.</small>
			                                    </div>
			                                    <!-- /form-group (vendor ref) -->
                                        	</div>
                                        	<!-- /column (vendor ref) -->
                                        </div>
                                        <!-- /row (customer and vendor reference) -->
                                        <h3 class="box-title m-t-40">Service Details</h3>
                                        <hr>
                                        <div class="row">
                                        	<div class="col-md-12">
                            					<div class="form-group">
			                                        <label for="description">Description</label>
			                                        <input name="description" required type="text" class="form-control" id="description" aria-describedby="descriptionHelp" placeholder="Enter service order description" />
			                                        <small id="descriptionHelp" class="form-text text-muted">Service order description.</small>
			                                    </div>
		                                    	<!-- /form-group (description) -->
											</div>
											<!-- /column (description) -->
                                        </div>
                                        <!-- /row (service order request - description) -->
                                        <div class="row">
                                        	<div class="col-md-4">
                                        		<div class="form-group">
			                                        <label for="requestedDate">Requested Date</label>
			                                        <input name="requestedDate" type="date" class="form-control" id="requestedDate" aria-describedby="requestedDateHelp" />
			                                        <small id="requestedDateHelp" class="form-text text-muted">Date when the requested service should be delivered.</small>
			                                    </div>
			                                    <!-- /form-group (requestedDate) -->
                                        	</div>
                                        	<!-- /column (requestedDate) -->
                                        	<div class="col-md-5">
                                        		<div class="form-group" id="serviceFg">
                                        			<label>Service</label>
                                                    <select name="service" class="select2 form-control custom-select" style="width:95%; height:36px;" aria-describedby="serviceHelp" id="service">
                                                        <option>--Select requested service--</option>
                                                        <optgroup label="LAND FREIGHT">
                                                        	<option>PKG GROUND</option>
                                                        	<option>PKG 3RD DAY</option>
                                                        	<option>PKG 2ND DAY</option>
                                                        	<option>PKG NEXT DAY</option>
                                                        	<option>LTL REGULAR</option>
                                                        	<option>LTL GUARANTEED</option>
                                                        	<option>FTL REGULAR</option>
                                                        	<option>FTL TEAM</option>
                                                        	<option>STR REGULAR</option>
                                                        	<option>STR TEAM</option>
                                                        </optgroup>
                                                        <optgroup label="AIR FREIGHT">
                                                        	<option>ECN</option>
                                                        	<option>EXP</option>
                                                        	<option>CHT</option>
                                                        </optgroup>
                                                        <optgroup label="OCEAN FREIGHT">
                                                        	<option>LCL</option>
                                                        	<option>FCL 20FT</option>
                                                        	<option>FCL 40FT</option>
                                                        	<option>FCL 45FT</option>
                                                        </optgroup>
                                                        <optgroup label="OTHER SERVICES">
                                                        	<option>CUSTOMS BROKERAGE</option>
                                                        	<option>BORDER CROSSING</option>
                                                        	<option>BUSINESS MANAGEMENT</option>
                                                        	<option>NOT SURE</option>
                                                        </optgroup>
                                                    </select>			                                        
			                                        <small id="serviceHelp" class="form-text text-muted">Requested service type, please select one.</small>
			                                    </div>
			                                    <!-- /form-group (service) -->
                                        	</div>
                                        	<!-- /column (service) -->
                                        	<div class="col-md-3">
                            					<div class="form-group">
			                                        <label for="classNumber">Class</label>
			                                        <input name="classNumber" type="number" value="0" min="0" max="99999" required class="form-control" id="classNumber" aria-describedby="classNumberHelp" placeholder="Class" />
			                                        <small id="classNumberHelp" class="form-text text-muted">Service Class.</small>
			                                    </div>
		                                    	<!-- /form-group (class) -->
											</div>
											<!-- /column (class) -->
                                        </div>
                                        <!-- /row (date, service type and class) -->
                                        <div class="row">
                                        	<div class="col-md-4">
                                        		<div class="form-group">
                                        			<label for="hu">H.U.</label>
                                        			<input name="hu" type="number" value="0" min="0" max="999999" required class="form-control" id="hu" aria-description="huHelp" />
                                        			<small id="huHelp" class="form-text text-muted">H.U. Number</small>
                                        		</div>
                                        		<!-- /form-group (H.U.) -->
                                        	</div>
                                        	<!-- /column (H.U.) -->
                                        	<div class="col-md-4">
                                        		<div class="form-group">
                                        			<label for="weight">WT (Lbs)</label>
                                        			<input name="weight" type="number" value="0" min="0" max="99999999" required class="form-control" id="weight" aria-description="weightHelp" />
                                        			<small id="weightHelp" class="form-text text-muted">Weight (Pounds)</small>
                                        		</div>
                                        		<!-- /form-group (Weight) -->
                                        	</div>
                                        	<!-- /column (Weight) -->
                                        	<div class="col-md-4">
                                        		<div class="form-group">
                                        			<label for="dimensions">LxWxH</label>
                                        			<input name="dimensions" type="text" class="form-control" id="dimensions" pattern="\d{1,4}x\d{1,4}x\d{1,4}" aria-description="dimensionsHelp" title="Dimensions should match the format for LxWxH, e.g. 10x20x34" />
                                        			<small id="dimensionsHelp" class="form-text text-muted">LxWxH</small>
                                        		</div>
                                        		<!-- /form-group (Dimensions) -->
                                        	</div>
                                        	<!-- /column (Dimensions) -->
                                        </div><!-- /row (H.U., Weight and Dimensions) -->
                                        <div class="row">
                                        	<div class="col-md-12">
                            					<div class="custom-control custom-checkbox mr-sm-2 mb-3">
                            						<input type="checkbox" class="custom-control-input" id="cbRequiresCustomerApproval" value="true" />
			                                        <label class="custom-control-label" for="cbRequiresCustomerApproval">The quote requires customer approval</label>
			                                        <input type="hidden" name="requiresCustomerApproval" id="requiresCustomerApproval" />
			                                    </div>
		                                    	<!-- /custom-control (requiresCustomerApproval) -->
											</div>
											<!-- /column (requiresCustomerApproval) -->
                                        </div>
                                        <!-- /row (service order request - customer approval) -->
                            		</div>
                            		<!-- /form-body -->
                            		<div class="form-actions">
		                                <button type="submit" id="btnSubmit" class="btn btn-success"> <i class="fa fa-check"></i> Save</button>
		                            </div>
		                            <!-- /form-actions -->
                            	</form>
                            </div>
                            <!-- /card-body -->
                        </div>
                        <!-- /card -->
                    </div>
                    <!-- /column-12 -->
                </div>
                <!-- row -->
                
                <@rightbar.nav />
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
        <@footer.nav />
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
   <@jscripts.nav />
    <!-- ============================================================== -->
    <!-- This page plugins -->
    <!-- ============================================================== -->
    <script src="../assets/node_modules/select2/dist/js/select2.full.min.js" type="text/javascript"></script>
    <script src="../assets/node_modules/bootstrap-select/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="/js/orders/create.js" type="text/javascript"></script>
	<!-- Popup message jquery -->
    <script src="/assets/node_modules/toast-master/js/jquery.toast.js"></script>
</body>

</html>