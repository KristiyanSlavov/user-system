(function () {
    'use strict';

    angular
        .module('app')
        .controller('EditUserAccountsController', EditUserAccountsController);

    EditUserAccountsController.$inject = ['$http', '$location', '$routeParams'];

    function EditUserAccountsController($http, $location, $routeParams) {
        var domainObject = this;

        domainObject.getById = getById;
        domainObject.update = update;
        domainObject.cancel = cancel;

        domainObject.account.id = $routeParams.userId;
        console.log($routeParams.userId);

        initUserAccount();

        function initUserAccount(){
            getById(domainObject.account.id);
        }

        function getById(id){
            var url = "/accounts/" + id;
            var userAccountPromise = $http.get(url);
            userAccountPromise.then(function(response){
                domainObject.account = response.data;
            });
        }

        function update(){
            var updatedUserAccountPromise = $http.put("/accounts/" + domainObject.account.id, domainObject.account);
            updatedUserAccountPromise.then(function(response){
               domainObject.account = response.data;
            });
        }

        function cancel(){
            $location.path('index/');
        }
    }
})();