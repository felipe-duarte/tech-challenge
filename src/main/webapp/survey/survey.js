'use strict'

angular.module('freeContract.survey', ['ngResource', 'ngRoute'])

.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/survey/:userId/:emailHash', {
		templateUrl: 'survey/survey.html',
		controller: 'SurveyCtrl'
	});
}])

.controller('SurveyCtrl', ['$scope', '$resource', '$routeParams', function($scope, $resource, $routeParams){
	$scope.alertModal = {title: '', body: ''};
	$scope.messages = '';
	$scope.answers = [];
	$scope.userId = $routeParams.userId;
	$scope.emailHash = $routeParams.emailHash;
	
	let restservice = $resource(
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
		restservice.save($scope.answers).$promise.then(function(data){
			
			$scope.alertModal = { title: 'Success', body: 'Thank You. Submitted answers with success - We love to know what you think about us ;)'};
			$('#alertModal').modal();
			$scope.answers = [];
			
		}, function(reason){
			
			$scope.alertModal = { title: 'Error', body: 'Fail to submit your answers - Sorry try again'};
			$('#alertModal').modal();
			
		});
		
	}
	
	$scope.query = function(){
		restservice.query().$promise.then(function(questions) {
			$scope.questions = questions;
			for (let i = 0; i < questions.length; i++) { 
				let question = questions[i];
				$scope.answers.push({userId: $scope.userId, questionId: question.id, emailHash: $scope.emailHash, content: ''});
			}
			
		}, function(reason){

			$scope.alertModal = { title: 'Error', body: 'Failed to load questions - Sorry try again later'};
			$('#alertModal').modal();
			
		});
		
	}
	
	$scope.query();
	
}]);