 var app = angular.module("employeeCrudApp", []); 
  app.controller("myCtrl", function($scope,$http) {
	  $scope.action="Add";
	  $http.get("employee/all")
	    .then(function(response) {
	        $scope.employees = response.data;
	    });
	  
	  $scope.editEmp = function(emp){
		  $scope.emp = emp;
		  $scope.action="Update";
	  }
	  $scope.persistEmp = function(emp){
		  $http.post("employee",emp)
		    .then(function(response) {
		        $scope.action="Add";
		        $scope.emp="";
		        
		        $http.get("employee/all")
			    .then(function(response) {
			        $scope.employees = response.data;
			    });
		    });
	  }
  });
  
  