var app = angular.module('surveyApp', [ 'ngResource','ngMessages', 'ngRoute' ]);

app.controller('surveyCtrl', function($scope, $resource) {
	
	$scope.response = '';
	$scope.messages = '';
	
	var restservice = $resource(
			'rest/survey', {}, {
				query :  {
					method : 'GET',
					isArray : true,
				},
				save : {
					method : 'POST',
					isArray : false
				},
			});
	
	$scope.save = function() {
		$scope.response = restservice.save($scope.answers);
		if($scope.response==null){
			$scope.messages = "Fail to submit your answers - Sorry try again";
		}else{
			$scope.messages = "Thank You. You submit your answers with success - We love to know what you think about us ;)";
		}
		
	}
	
	$scope.query = function(){
		$scope.questions = restservice.query();
		if($scope.questions==null){
			$scope.errorMessage = "Fail to load questions - Sorry try again";
		}else{
			var count = Object.keys($scope.questions).length;
			$scope.answers = [];
			for($key=0; $key<=count;$key++){
				$scope.answers.push({userId: 1, questionId: $key});
			}
		}
	}
	
	$scope.query();
	
	
});