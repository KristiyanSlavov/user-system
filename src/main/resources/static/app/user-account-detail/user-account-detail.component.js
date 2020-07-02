'use strict';

angular.
  module('userAccountDetail').
  component('userAccountDetail', {
    templateUrl: 'app/user-account-detail/user-account-detail.template.html',
    controller: ['UserAccount', '$routeParams', '$location',
      function UserAccountDetailController(UserAccount, $routeParams, $location) {
            var self = this;
            self.account = UserAccount.get({id: $routeParams.id});

            self.update = function() {
                UserAccount.update(self.account).$promise.then(function(response) {
                    console.log(response);
                });

                console.log(self.account);
            }

            self.cancel = function() {
                $location.path('/accounts');
            }
      }
    ]
  });