var app = angular.module('signup', [ 'ngResource','ngMessages' ]);

app.controller('Ctrl', function($scope, $resource) {
	$scope.response = '';
	$scope.result = '';
	$scope.error = '';
	
	var restservice = $resource(
			'rest/signup', {}, {
				save : {
					method : 'POST',
					isArray : false
				},
			});
	
	$scope.signup = function() {
		if($scope.email!=null){
			$scope.response = restservice.save({
				email : $scope.email
			});
			if($scope.response==null){
				$scope.error = "Fail to register - Sorry try again";
			}else{
				$scope.result = "Registration Success - We are on the way to get in touch ;)";
			}
		}else{
			$scope.error = "Fail to register - An Valid e-mail is required";
		}
	}
});

/** Directive to validate email field **/
app.directive('validateEmail', function() {
	  var EMAIL_REGEXP = /^[_a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,5})$/;

	  return {
	    require: 'ngModel',
	    restrict: '',
	    link: function(scope, elm, attrs, ctrl) {
	      if (ctrl && ctrl.$validators.email) {
	        ctrl.$validators.email = function(modelValue) {
	          return ctrl.$isEmpty(modelValue) || EMAIL_REGEXP.test(modelValue);
	        };
	      }
	    }
	  };
});