/**
 * 
 */
$(function() {
	$('#activeSor').DataTable(
			{
				dom : 'Bfrtip',
				buttons : [
						{
							extend : 'excel',
							exportOptions : {
								columns : [ 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
										14, 15, 16, 17, 18, 19 ]
							}
						},
						{
							extend : 'pdfHtml5',
							orientation : 'landscape',
							exportOptions : {
								columns : [ 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
										14, 15, 16, 17, 18, 19 ]
							}
						} ]
			});
	$('.buttons-excel').addClass('btn btn-primary mr-1');
	$('.buttons-pdf').addClass('btn btn-primary mr-1');
});