'use strict';

angular.
  module('userAccountList').
  component('userAccountList', {
        template:
        '<div class="container-fluid">' +
            '<div class="row">' +
                '<div class="col-md-2">' +

                '<p>' +
                  'Search: <input ng-model="$ctrl.query" />' +
                 '</p>' +

                   '<p>' +
                       'Sort by: <select ng-model="$ctrl.orderProp">' +
                        '<option value="name">Alphabetical</option>' +
                         '<option value="age">Id</option>' +
                         '</select>'+
                   '</p>' +

                '</div>' +
                '<div class="col-md-10">' +
                    '<table class="table">' +
                      '<thead>' +
                        '<tr>' +
                            '<th>First Name</th>' +
                            '<th>Last Name</th>' +
                            '<th>Email</th>' +
                            '<th>Date of birth</th>' +
                            '<th style="width: 90px"></th>' +
                        '</tr>' +
                        '</thead>' +
                        '<tbody>' +
                        '<tr ng-repeat="account in $ctrl.accounts | filter:$ctrl.query">' +
                            '<td>{{account.firstName}}</td>' +
                            '<td>{{account.lastName}}</td>' +
                            '<td>{{account.email}}</td>' +
                            '<td>{{account.dateOfBirth}}</td>' +
                            '<td>' +
                                '<a class="btn btn-small btn-primary" ng-click="vm.update(account.id)">Edit</a>' +
                            '</td>' +
                            '<td>'+
                                '<button class="btn btn-danger" ng-click="vm.deleteById(account.id)">Delete</button>' +
                            '</td>' +
                        '</tr>' +
                        '</tbody>' +
                    '</table>',
        controller:['UserAccount',
            function UserAccountListController(UserAccount) {
                this.accounts = UserAccount.query();
            }
        ]
  });