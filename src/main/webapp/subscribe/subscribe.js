'use strict'

angular.module('freeContract.subscribe', ['ngMessages', 'ngResource'])

.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/subscribe', {
		templateUrl: 'subscribe/subscribe.html',
		controller: 'SubscribeCtrl'
	});
}])

.controller('SubscribeCtrl', ['$scope', '$resource', function($scope, $resource){
	$scope.alertModal = {title: '', body: ''};
	$scope.messages = '';
	
	let restservice = $resource(
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
				
			}).$promise.then(function(data){
				
				$scope.alertModal = {title: 'Success', body: 'Thank you - Registration Success - We are on the way to get in touch ;)'};
				$('#alertModal').modal();
				userForm.$setUntouched();
				
			},function(reason){
				
				$scope.alertModal = {title: 'Error', body: 'Fail to register - Sorry try again later'};
				$('#alertModal').modal();
				
			});
		}else{
			
			$scope.alertModal = {title: 'Error', body: 'Fail to register - An Valid e-mail is required'};
			$('#alertModal').modal();
			
		}
	}
}]);
