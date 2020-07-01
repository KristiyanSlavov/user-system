'use strict';

angular.
  module('userAccountNew').
  component('userAccountNew', {
    templateUrl: 'app/user-account-new/user-account-new.template.html',
    controller: ['UserAccount','$routeParams','$location',
      function UserAccountNewController(UserAccount,$routeParams,$location) {
            var self = this;
            self.account = {};

            self.save = function() {
                UserAccount.save(self.account).$promise.then(function(response) {
                       console.log(response);
                });
            }

            self.cancel = function() {
                $location.path('/accounts');
            }
      }
    ]
  });