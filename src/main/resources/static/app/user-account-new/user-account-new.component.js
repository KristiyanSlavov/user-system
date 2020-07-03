'use strict';

angular.
  module('userAccountNew').
  component('userAccountNew', {
    templateUrl: 'app/user-account-new/user-account-new.template.html',
    controller: ['UserAccount','$routeParams','$location','$filter',
      function UserAccountNewController(UserAccount,$routeParams,$location,$filter) {
            var self = this;
            self.account = {};
            self.errorMessage = '';


            self.create = function() {
                UserAccount.save(self.account, function(success){
                    self.cancel();
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