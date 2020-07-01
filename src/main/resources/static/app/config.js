var app = angular.module('app',['ngRoute']);
app.config(function($routeProvider){
	$routeProvider
	.when('/editUserAccount/:id', {templateUrl:'editUserAccount.html'});
});