'use strict';

angular.
  module('core.userAccount').
  factory('UserAccount', ['$resource',
    function($resource) {
      return $resource('/accounts/:id');
    }
  ]);