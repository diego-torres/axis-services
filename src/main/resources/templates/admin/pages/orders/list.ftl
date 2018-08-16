<#import "/spring.ftl" as spring />
<#import "../../lib/navigation.ftl" as navigation />
<#assign xhtmlCompliant = true in spring />
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Axis Connect US - Service Orders List</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap_3_3_7/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    
    <!-- Data Tables CSS -->
    <link href="../vendor/DataTables/datatables.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <div id="wrapper">

        <@navigation.nav />

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Service Orders</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            	<table id="service_orders_table" class="display">
            		<thead>
            			<th>Detail</th>
            			<th>Edit</th>
            			<th>Hot</th>
            			<th>Axis Ref</th>
            			<th>PO / Customer Ref</th>
            			<th>SO / Vendor Ref</th>
            			<th>Requested Date</th>
            			<th>Shipping Date</th>
            			<th>ETA</th>
            			<th>Delivery</th>
            			<th>Shipper</th>
            			<th>Consignee</th>
            			<th>Comments Log</th>
            			<th>Carrier</th>
            			<th>Service</th>
            			<th>Status</th>
            			<th>H.U.</th>
            			<th>WT</th>
            			<th>Quote#</th>
            			<th>Pickup #</th>
            			<th>PRO #</th>
            			<th>Duration</th>
            		</thead>
            		<tbody>
            			<#list serviceOrders as order>
            				<tr>
            					<td><i class="fa fa-comments fa-fw" /></td>
            					<td><i class="fa fa-pencil fa-fw" /></td>
            					<td><#if order.hot><i class="fa fa-fire fa-fw" /></#if></td>
            					<td>AX${order.id?string["000"]}</td>
            					<td>${order.custRef}</td>
            					<td>${order.vendorRef}</td>
            					<td>${order.requested?date}</td>
            					<td>${order.shipping?date}</td>
            					<td>${order.eta?date}</td>
            					<td>${order.delivery?date}</td>
            					<td>${order.shipper}</td>
            					<td>${order.consignee}</td>
            					<td>${order.comments}</td>
            					<td>${order.carrier}</td>
            					<td>${order.service}</td>
            					<td>${order.status}</td>
            					<td>${order.hu}</td>
            					<td>${order.wt}</td>
            					<td><#if order.quoteId??>${order.quoteId}</#if></td>
            					<td><#if order.pickupId??>${order.pickupId}</#if></td>
            					<td><#if order.proId??>${order.proId}</#if></td>
            					<td>${order.duration}</td>
            				</tr>
            			</#list>
            		</tbody>
            	</table>
            </row>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap_3_3_7/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>
    
    <!-- Data Tables Plugin JavaScript -->
    <script src="../vendor/DataTables/datatables.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    <script src="../dist/js/active-orders-list.js"></script>

</body>

</html>