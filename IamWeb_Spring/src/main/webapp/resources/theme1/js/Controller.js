(function(){

 angular
.module('crud')
 
.controller('crudCtrl' ,function($scope,$http){

	
	
	$scope.search="";
	
  $scope.user={
		  
		  id:"",
		  fullname:"",
		  
          username:"",
         email:""
  
  };
  
  
  $scope.Delete=function(user){
	  
	  
	  $http.post('Delete',user).success(function(response){
		  //alert(response.status);
		  alert("Data deleted");
		  getall();
	  })
  }
  
$scope.update=function(user){
	  
	  
	  $http.post('Upd',user).success(function(response){
		  //alert(response.status);
		  alert("Data updates");
		  getall();
	  })
  }
  
  
  
  $scope.submitform=function(){
	 

	 
	
		$http.post('save',$scope.user)
		
		 
		.success(function(response){
			
			//alert(response.status);
			alert("Data has been Saved");
			getall();
		})
		
	
  }
  
  
  
  getall();
  
  function getall(){
	  $http.post('list')
	    .then(function(response) {
	        $scope.userdata = response.data;
	    });  
  }
  
  
  
  $scope.update=function(id){
	  $scope.user.id=$scope.userdata.data[id].id;
	  $scope.user.fullname=$scope.userdata.data[id].fullname;
	  $scope.user.email=$scope.userdata.data[id].email;
	  $scope.user.username=$scope.userdata.data[id].username;
	  
  }
  
  $scope.new=function(){
	  $scope.user={
			  fullname:"",
	          username:"",
	         email:""
	  
	  };
	  
  }
  


});

})();
