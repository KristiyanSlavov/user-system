'use strict';

angular.
  module('userAccountApp').
  config(['$routeProvider',
    function config($routeProvider) {
      $routeProvider.
        when('/accounts', {
          template: '<user-account-list></user-account-list>'
        }).
        when('/accounts/:id', {
          template: '<user-account-detail></user-account-detail>'
        }).
        otherwise('/accounts');
    }
  ]);