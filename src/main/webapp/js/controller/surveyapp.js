var app = angular.module('surveyApp', [ 'ngResource','ngMessages', 'ngRoute' ]);

app.controller('surveyCtrl', function($scope, $location, $resource) {
	
	$scope.response = '';
	$scope.messages = '';

	var paramsUrl = $location.$$url.split("/");// Hack to get URL Params from the URL SurveyLink 
	
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
				$scope.answers.push({userId: paramsUrl[1], questionId: $key, emailHash: paramsUrl[2]});
			}
		}
	}
	
	$scope.query();
	
	
});