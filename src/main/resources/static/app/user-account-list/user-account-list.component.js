'use strict';

angular.
  module('userAccountList').
  component('userAccountList', {
        templateUrl:'app/user-account-list/user-account-list.template.html',
        controller:['UserAccount', '$location',
            function UserAccountListController(UserAccount, $location) {
                var self = this;
                self.errorMessage = '';

                init();

                function init() {
                    getAll();
                }

                function getAll() {
//                    self.accounts = UserAccount.query();
                      UserAccount.query({}, function(success) {
                          self.accounts = success;
                      }, function(error) {
                          self.errorMessage = error.data.httpError;
                      });
                }

                self.editUserAccount = function(id) {
                    $location.path('/accounts/' + id);
                }

                self.createUserAccount = function() {
                    $location.path('/account');
                }

                self.delete = function(id) {
                    UserAccount.delete({id: id}, function(success) {
                        console.log(success);
                        getAll();
                    }, function(error) {
                        console.log(error);
                    });
                }
            }
        ]
  });