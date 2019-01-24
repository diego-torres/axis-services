/**
 * 
 */
$(function() {
	// For select 2
	$('.select2').select2();

	// TODO: Submit click event
	$('#btnSubmit').click(function() {
		if(validateForm()) {
			// TODO: AJAX submit
			console.debug('form is valid');
		}
	});
	// TODO: Cancel click event
	$('#btnCancel').click(function() {
		console.debug('cancel click working');
	});
});

function validateForm() {
	var validForm = true;
	if($('#customer').val()==='') {
		$('#customer').addClass('is-invalid');
		showToast('Early validation', 'Customer is required');
		validForm = false;
	}
	
	// TODO: Validate requested date
	if($('#requestedDate').val()) {
		var d = new Date(Date.parse($('#requestedDate').val() + ' 23:00'));
		var tomorrow = new Date();
		tomorrow.setDate(tomorrow.getDate() + 1);
		if(d < tomorrow) {
			$('#requestedDate').addClass('is-invalid');
			showToast('Early validation', 'Requested date should at least be tomorrow');
			validForm = false;
		}
	}
	
	
	if($('#service').val() === '--Select requested service--') {
		$('#serviceFg').addClass('has-error');
		showToast('Early validation', 'Please select a service type, if you are unaware of the requested service type, please select OTHER > NOT SURE');
		validForm = false;
	}
	
	return validForm;
}

function resetValidationStyles() {
	$.toast().reset('all');
	$('#customer').removeClass('is-invalid');
	$('#requestedDate').removeClass('is-invalid');
	$('#serviceFg').removeClass('has-error');
}

function showToast(heading, text){
	//This is for the Notification top right
    $.toast({
            heading: heading
            , text: text
            , position: 'top-right'
            , icon: 'error'
            , hideAfter: 5000
            , stack: 6
        });
}