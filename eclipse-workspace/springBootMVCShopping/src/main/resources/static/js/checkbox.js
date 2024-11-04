/**
 * 
 */
$(function(){
	$("#checkBoxes").click(function(){
		if($("#checkBoxes").prop("checked")){
			$("input:checkbox[name=nums]").prop("checked", true);
		}
		else{
			$("input:checkbox[name=nums]").prop("checked", false);
		}
		prodChk();
	});
	
	$("input:checkbox[name=nums]").click(function(){
		var tot = $("input:checkbox[name=nums]").length;
		var cnt = $("input:checkbox[name=nums]:checked").length;
		if(tot == cnt){
			$("#checkBoxes").prop("checked", true);
		}
		else{
			$("#checkBoxes").prop("checked", false);
		}
		prodChk();
	})
});