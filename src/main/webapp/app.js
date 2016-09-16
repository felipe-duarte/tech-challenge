'use strict'

angular.module('freeContract', [
  'ngRoute',
  'freeContract.subscribe',
  'freeContract.survey'
])

.config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {

	$locationProvider.hashPrefix('!');

	$routeProvider.otherwise({redirectTo: '/subscribe'});
}])

.directive('validateEmail', function() {
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