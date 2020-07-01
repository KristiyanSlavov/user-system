'use strict';

angular.
  module('userAccountList').
  component('userAccountList', {
        templateUrl:'app/user-account-list/user-account-list.template.html',
        controller:['UserAccount', '$location',
            function UserAccountListController(UserAccount, $location) {
                var self = this;

                init();

                function init() {
                    getAll();
                }

                function getAll() {
                    self.accounts = UserAccount.query();
                }

                self.editUserAccount = function(id) {
                    $location.path('/accounts/' + id);
                }

                self.createUserAccount = function() {
                    $location.path('/account');
                }

                self.delete = function(account) {
                    account.$delete();
                    getAll();
                }
            }
        ]
  });