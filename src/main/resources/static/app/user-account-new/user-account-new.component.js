'use strict';

angular.
  module('userAccountNew').
  component('userAccountNew', {
    templateUrl: 'app/user-account-new/user-account-new.template.html',
    controller: ['UserAccount','$routeParams','$location',
      function UserAccountNewController(UserAccount,$routeParams,$location) {
            var self = this;
            self.account = {};
            self.errorMessage = '';


            self.save = function() {
                UserAccount.save(self.account, function(success){
                    console.log(success);
                }, function(error) {
                    self.errorMessage = error.data.message;
                });
            }

            self.cancel = function() {
                $location.path('/accounts');
            }
      }
    ]
  });