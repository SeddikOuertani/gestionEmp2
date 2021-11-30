const tooltips = document.querySelectorAll(".tt");
tooltips.forEach((tooltip)=>{
	new bootstrap.Tooltip(tooltip);
});