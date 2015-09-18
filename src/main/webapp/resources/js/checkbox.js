    $(".multiselect .selectBox").click(function() {
    	if ($("#checkboxes").css('display') == "block") {
    		$('#checkboxes').css('display', 'none');
    	} else {
    		$('#checkboxes').css('display', 'block');
    	}
    });
    $(document).click(function(event) {
    	if ($(event.target).closest(".multiselect").length)
    		return;
    	$("#checkboxes").hide();
    	event.stopPropagation();
    });