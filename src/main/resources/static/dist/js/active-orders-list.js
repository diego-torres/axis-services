$(document).ready(function() {
	$('#service_orders_table').DataTable({
		responsive : true,
		dom: 'Bfrtip',
		buttons: ['excel', 'pdf']
	});
	// TODO: Enable buttons
});

function editServiceOrder(id) {
	window.location.href = '/orders/details/' + id;
	return false;
}