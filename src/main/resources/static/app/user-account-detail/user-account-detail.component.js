'use strict';

angular.
  module('userAccountDetail').
  component('userAccountDetail', {
    template:
        '<div class="container-fluid">' +
            '<div class="row">' +
                '<div class="col-md-10">' +
                    '<p> {{$ctrl.account.email}} </p>' +
                    '<p> {{$ctrl.account.dateOfBirth}} </p>' +
                '</div>' +
            '</div>' +
        '</div>',
    controller: ['UserAccount', '$routeParams',
      function UserAccountDetailController(UserAccount, $routeParams) {
            var self = this;
            self.account = UserAccount.get({id: $routeParams.id});
      }
    ]
  });