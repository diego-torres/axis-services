function startProcessInstance() {
	if (validate()) {
		document.forms["serviceOrderForm"]["startProcessInstance"].value = true;
		document.forms["serviceOrderForm"].submit();
	}
}
function validate() {
	if (!hasOrigin())
		alert("You must provide an origin");
	if (!hasDestination())
		alert("You must provide a destination");
	if (hasOrigin() && hasDestination())
		return true;
	else
		return false;
}

function hasOrigin() {
	var fromStreetAddress = document.forms["serviceOrderForm"]["fromStreet"].value;
	if (fromStreetAddress.length > 2) {
		return true;
	}
	var fromStreetAddress2 = document.forms["serviceOrderForm"]["fromStreet2"].value;
	if (fromStreetAddress.length > 2)
		return true;

	var mapLocation = document.forms["serviceOrderForm"]["fromLocation"].value;
	if (mapLocation.length > 2)
		return true;

	return false;
}

function hasDestination() {
	var fromStreetAddress = document.forms["serviceOrderForm"]["toStreet"].value;
	if (fromStreetAddress.length > 2) {
		return true;
	}
	var fromStreetAddress2 = document.forms["serviceOrderForm"]["toStreet2"].value;
	if (fromStreetAddress.length > 2)
		return true;

	var mapLocation = document.forms["serviceOrderForm"]["toLocation"].value;
	if (mapLocation.length > 2)
		return true;

	return false;
}