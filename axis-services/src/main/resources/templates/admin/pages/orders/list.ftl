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
    <@head.nav pageTitle="Axis BPS - SOR Active List" />
    <!-- page CSS -->
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
                                <li class="breadcrumb-item active">List</li>
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
                        	<div class="card-body">
                        		<h4 class="card-title">Service Order Request - Active</h4>
                            	<h6 class="card-subtitle">List of active SOR.</h6>
                            	<div class="table-responsive m-t-40">
                            		<table id="activeSor" class="display nowrap table table-hover table-striped table-bordered" cellspacing="0" width="100%">
                            			<thead>
                                            <tr>
                                            	<th><i class="fas fa-paperclip"></i></th>
                                            	<th><i class="far fa-comment"></i></th>
                                            	<th><i class="fas fa-bug"></i></th>
                                            	<th><i class="fas fa-hand-holding-usd"></i></th>
                                                <th>Id</th>
                                                <th>SOR</th>
                                                <th>Customer</th>
                                                <th>Description</th>
                                                <th>Shipper</th>
                                                <th>Consignee</th>
                                                <th>Customer Ref</th>
                                                <th>Vendor Ref</th>
                                                <th>Requested Date</th>
                                                <th>Shipping Date</th>
                                                <th>Task Date</th>
                                                <th>Service</th>
                                                <th>Class</th>
                                                <th>H.U.</th>
                                                <th>Weight</th>
                                                <th>Dimensions</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<#list serviceOrderRequests as sor>
                                        	<tr>
                                        		<th><i class="fas fa-paperclip"></i></th>
                                        		<th><i style="color:blue;" class="far fa-comment"></i></th>
                                        		<th><#if sor.validation?? && sor.validation.errorsCount gt 0><i style="color:red;" class="fas fa-bug"></i></#if></th>
                                        		<th><#if sor.requiresCustomerApproval?? && sor.requiresCustomerApproval><i style="color:green;" class="fas fa-hand-holding-usd"></i></#if></th>
                                        		<th>${sor.processInstanceId}</th>
                                                <th>${sor.id}</th>
                                                <th>${sor.customer}</th>
                                                <th>${sor.description}</th>
                                                <th><#if sor.shipper??>${sor.shipper}</#if></th>
                                                <th><#if sor.consignee??>${sor.consignee}</#if></th>
                                                <th><#if sor.customerRef??>${sor.customerRef}</#if></th>
                                                <th><#if sor.vendorRef??>${sor.vendorRef}</#if></th>
                                                <th><#if sor.requestedDate??>${sor.requestedDate?date?iso_utc}</#if></th>
                                                <th><#if sor.requestedShippingDate??>${sor.requestedShippingDate?date?iso_utc}</#if></th>
                                                <th><#if sor.taskDate??>${sor.taskDate?date?iso_utc}</#if></th>
                                                <th><#if sor.service??>${sor.service}</#if></th>
                                                <th><#if sor.classNumber??>${sor.classNumber}</#if></th>
                                                <th><#if sor.hu??>${sor.hu}</#if></th>
                                                <th><#if sor.weightLbs??>${sor.weightLbs}</#if></th>
                                                <th><#if sor.dimensions??>${sor.dimensions}</#if></th>
                                            </tr>
                                        	</#list>
                                        </tbody>
									</table>
								</div>
								<!-- /table-responsive -->
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
    <!-- This is data table -->
    <script src="/assets/node_modules/datatables/datatables.min.js"></script>
    <!-- start - This is for export functionality only -->
    <script src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js"></script>
    <!-- end - This is for export functionality only -->
	<script src="/js/orders/list.js" type="text/javascript"></script>
</body>

</html>