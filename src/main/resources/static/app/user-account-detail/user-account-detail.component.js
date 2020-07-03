'use strict';

angular.
  module('userAccountDetail').
  component('userAccountDetail', {
    templateUrl: 'app/user-account-detail/user-account-detail.template.html',
    controller: ['UserAccount', '$routeParams', '$location','$filter',
      function UserAccountDetailController(UserAccount, $routeParams, $location, $filter) {
            var self = this;
            self.errorMessage = '';
            self.account = UserAccount.get({id: $routeParams.id});

            self.update = function() {
                UserAccount.update(self.account, function(success) {
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