<#import "/spring.ftl" as spring />
<#import "../../lib/navigation.ftl" as navigation />
<#assign xhtmlCompliant = true in spring />
<#assign aDateTime = .now>
<#assign aDate = aDateTime?date>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Axis Connect US - Update Service Order</title>

    <!-- Bootstrap Core CSS -->
    <link href="../../vendor/bootstrap_3_3_7/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
					<h1 class="page-header">Edit Service Order (Order Entry)</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<#if order??>
			<form name="serviceOrderForm" id="serviceOrderForm" action="/orders/create" method="POST" role="form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="hidden" name="startProcessInstance" id="startProcessInstance" value="false" />
			<input type="hidden" name="id" id="id" value="${order.id}" />
			<div class="row">
				<div class="col-lg-12">
					
						<div class="form-group">
							<label>Customer Reference (PO)</label> <input
								class="form-control" id="customerRef" name="customerRef"
								type="text" placeholder="Customer Ref" value="<#if order.customerRef??>${order.customerRef}</#if>" />
						</div>
						<div class="form-group">
							<label>Vendor Reference (SO)</label> <input class="form-control"
								id="vendorRef" name="vendorRef" type="text"
								placeholder="Vendor Ref" value="<#if order.vendorRef??>${order.vendorRef}</#if>" />
						</div>
						<div class="form-group">
							<label>Requested Delivery Date</label> <input class="form-control"
								id="deliveryDate" name="deliveryDate" type="date"
								min="${aDate?iso_utc}" value="<#if order.deliveryDate??>${order.deliveryDate?string["yyyy-MM-dd"]}</#if>" />
						</div>
						<div class="form-group">
							<button id="btnSubmit" name="btnSubmit" type="submit"
								class="btn btn-primary">Save</button>
							<button onclick="startProcess();" id="btnReset" name="btnReset" type="button"
								class="btn btn-success">Start Process</button>
						</div>
				</div>
			</div>
			<div class="row">
			<div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Service Order Details
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#materials" data-toggle="tab">Materials</a>
                                </li>
                                <li><a href="#origin" data-toggle="tab">Origin</a>
                                </li>
                                <li><a href="#destination" data-toggle="tab">Destination</a>
                                </li>
                                <li><a href="#comments" data-toggle="tab">Comments</a>
                                </li>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="materials">
                                	<div class="col-lg-12">
                                		<div class="form-group">
											<label>Weight</label> <input
												class="form-control" id="weight" name="weight"
												type="text" placeholder="weight" value="<#if order.weight??>${order.weight}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group">
											<label>Dimensions</label> <input
												class="form-control" id="dimensions" name="dimensions"
												type="text" placeholder="dimensions" value="<#if order.dimensions??>${order.dimensions}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group">
											<label>Instructions</label> <input
												class="form-control" id="instructions" name="instructions"
												type="text" placeholder="instructions" value="<#if order.instructions??>${order.instructions}</#if>" />
										</div><!-- /.form-group -->
                                	</div><!-- /.col-lg-12 -->
                                </div>
                                <div class="tab-pane fade" id="origin">
                                    <div class="col-lg-12">
                                		<div class="form-group">
											<label>Street Address Line 1</label> <input
												class="form-control" id="fromStreet" name="fromStreet"
												type="text" placeholder="Street Address Line 1" value="<#if order.fromStreet??>${order.fromStreet}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group">
											<label>Street Address Line 2</label> <input
												class="form-control" id="fromStreet2" name="fromStreet2"
												type="text" placeholder="Street Address Line 2" value="<#if order.fromStreet2??>${order.fromStreet2}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group">
											<label>City</label> <input
												class="form-control" id="fromCity" name="fromCity"
												type="text" placeholder="City" value="<#if order.fromCity??>${order.fromCity}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group col-md-4">
											<input
												class="form-control" id="fromState" name="fromState"
												type="text" placeholder="state" value="<#if order.fromState??>${order.fromState}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group col-md-4">
											<input
												class="form-control" id="fromZip" name="fromZip"
												type="text" placeholder="zip" value="<#if order.fromZip??>${order.fromZip}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group col-md-4">
											<input
												class="form-control" id="fromCountry" name="fromCountry"
												type="text" placeholder="country" value="<#if order.fromCountry??>${order.fromCountry}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group">
											<label>Map Location Ref</label> <input
												class="form-control" id="fromLocation" name="fromLocation"
												type="text" placeholder="Map Location Reference" value="<#if order.fromLotation??>${order.fromLocation}</#if>" />
										</div><!-- /.form-group -->
                                	</div><!-- /.col-lg-12 -->
                                </div>
                                <div class="tab-pane fade" id="destination">
                                    <div class="col-lg-12">
                                		<div class="form-group">
											<label>Street Address Line 1</label> <input
												class="form-control" id="toStreet" name="toStreet"
												type="text" placeholder="Street Address Line 1" value="<#if order.toStreet??>${order.toStreet}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group">
											<label>Street Address Line 2</label> <input
												class="form-control" id="toStreet2" name="toStreet2"
												type="text" placeholder="Street Address Line 2" value="<#if order.toStreet2??>${order.toStreet2}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group">
											<label>City</label> <input
												class="form-control" id="toCity" name="toCity"
												type="text" placeholder="City" value="<#if order.toCity??>${order.toCity}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group col-md-4">
											<input
												class="form-control" id="toState" name="toState"
												type="text" placeholder="state" value="<#if order.toState??>${order.toState}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group col-md-4">
											<input
												class="form-control" id="toZip" name="toZip"
												type="text" placeholder="zip" value="<#if order.toZip??>${order.toZip}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group col-md-4">
											<input
												class="form-control" id="toCountry" name="toCountry"
												type="text" placeholder="country" value="<#if order.toCountry??>${order.toCountry}</#if>" />
										</div><!-- /.form-group -->
										<div class="form-group">
											<label>Map Location Ref</label> <input
												class="form-control" id="toLocation" name="toLocation"
												type="text" placeholder="Map Location Reference" value="<#if order.toLocation??>${order.toLocation}</#if>" />
										</div><!-- /.form-group -->
                                	</div><!-- /.col-lg-12 -->
                                </div>
                                <div class="tab-pane fade" id="comments">
                                    <div class="chat-panel panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-comments fa-fw"></i> Comments
                            <div class="btn-group pull-right">
                                <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-chevron-down"></i>
                                </button>
                                <ul class="dropdown-menu slidedown">
                                    <li>
                                        <a href="#" onclick="getPartialComments(${order.id}, '${principal}'); return false;">
                                            <i class="fa fa-refresh fa-fw"></i> Refresh
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="chat">
                            	<#list order.comments as comment>
                            	<#if comment.fromUser == principal>
                            	<li id="comment_${comment.id}" class="right clearfix">
                        		<span class="chat-img pull-left">
                                    <img src="http://placehold.it/50/FA6F57/fff?text=Me" alt="User Avatar" class="img-circle" />
                                </span>
                        		<#else>
                        		<li id="comment_${comment.id}" class="left clearfix">
                        		<span class="chat-img pull-left">
                                    <img src="http://placehold.it/50/55C1E7/fff?text=S" alt="User Avatar" class="img-circle" />
                                </span>
                        		</#if>
                                    <div class="chat-body clearfix">
                                        <div class="header">
                                            <strong class="primary-font">${comment.fromUser}</strong>
                                            <small class="pull-right text-muted">
                                                <i class="fa fa-clock-o fa-fw"></i> ${comment.duration} (${comment.created})
                                            </small>
                                        </div>
                                        <p>
                                            ${comment.comment}
                                        </p>
                                    </div>
                                </li>
                            	</#list>
                            </ul>
                        </div>
                        <!-- /.panel-body -->
                        <div class="panel-footer">
                            <div class="input-group">
                                <input id="textComment" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                                <span class="input-group-btn">
                                    <button class="btn btn-warning btn-sm" id="btn-chat" onclick="addComment(${order.id}, '${principal}'); return false;">
                                        Send
                                    </button>
                                </span>
                            </div>
                        </div>
                        <!-- /.panel-footer -->
                    </div>
                    <!-- /.panel .chat-panel -->
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
			</div>
			</form>
			<#else>
			<div class="row">
				<div class="alert alert-warning">
					I was unable to find the order id that you are trying to access, please try again.
					<a href="/orders/" class="alert-link">Orders List</a>.
				</div><!-- /.alert -->
			</div>
			</#if>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../../vendor/bootstrap_3_3_7/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../../dist/js/sb-admin-2.js"></script>
    <script src="../../dist/js/process-instance.js"></script>
    <script src="../../dist/js/comments.js"></script>

</body>

</html>