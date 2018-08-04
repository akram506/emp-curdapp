
  $(function() {
	  var checkedForDeleteIds = [];
	  
	  getAllEmployeeDetails();
  });
  
  function getAllEmployeeDetails(){
	  $.ajax(
			   {
			      type:'GET',
			      url:'./employee/all',
			      success: function(data){
			    	  var html = '<table>';
			    	  html+="<tr><th>Employee Id </th>";
			    	  html+="<tr><th>Employee Name </th>";
			    	  html+="<tr><th>Employee Salary </th>";
			    	  html+="<tr><th>Employee Dept </th>";
			    	  html+="<tr><th>Employee email </th> </tr>";
			    	  $.each(data, function(i, val) {
			    		  console.log(data);
			    		    html += '<tr><td> <input type="checkbox" id="rowId" value='+val.id+'></td>';
			    		    html += '<td>' + val.id + '</td>';
			    		    html += '<td>' + val.name + '</td>';
			    		    html += '<td>' + val.sal + '</td>';
			    		    html += '<td>' + val.dept + '</td>';
			    		    html += '<td>' + val.email + '</td>';
			    		    html += '<td><input type="button" id="editEmpDetailsId" name="Edit Employee Details"  onclick="editaEmployeeDetails('+val.id+');"></td></tr>';
			    		})
			    		html += '</table>';
					$("#employeeListDivId").append(html); 
			    	  
			      }
			   }
			);
  }
  
  /*
  
  $("#editEmpDetailsId").click(function() {
	    var $row = $(this).closest("tr");    
	    var $tds = $row.find("td");
	    
	    $.each($tds, function() {
	        console.log($(this).text());
	    });
	    
	});
  
  function editaEmployeeDetails(empId){
	  
	  $("#upadteEmpDetailsDivId").dialog({
		  title :"Update Employee Details",
		  autoOpen:true,
		  modal:true,
		  height:'auto',
		  position:['top',40],
		  resizable:false,
		  close:function(){this.remove();}}).load('employee',{empId:empId});
	  }
	  $.ajax({
			      type:'PUT',
			      url:'employee',
			      success: function(data){
  });
  */

  $("input:checkbox[name=type]:checked").each(function(){
	  checkedForDeleteIds.push($(this).val());
	});
  function deleteEmployeeDetails(){
	  $.ajax({
	      type:'Delete',
	      url:'employee',
	      data: checkedForDeleteIds,
	      success: function(data){
	    	  checkedForDeleteIds=[];
	    	  $("#employeeListDivId").html("");
	    	  getAllEmployeeDetails();
	    	  alert("Employee details Deleted Sucessfully");
	      }
    });
	  
  }
  
  
  function addEmployeeDetails(){
	  $.ajax({
	      type:'POST',
	      url:'employee',
	      success: function(data){
	    	  checkedForDeleteIds=[];
	    	  $("#employeeListDivId").html("");
	    	  getAllEmployeeDetails();
	    	  alert("Employee details Deleted Sucessfully");
	      }
    });  
  }