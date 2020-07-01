<<<<<<< HEAD
(function () {
    'use strict';

    angular
        .module('app')
        .controller('AccountsController', AccountsController);

    AccountsController.$inject = ['$http', '$location'];

    function AccountsController($http) {
        var vm = this;

        vm.accounts = [];
//        vm.successDeleteMsg = "";
        vm.getAll = getAll;
        vm.deleteById = deleteById;
        vm.editUserAccount = editUserAccount;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/accounts";
            var accountsPromise = $http.get(url);
            accountsPromise.then(function(response){
                vm.accounts = response.data;
            });
        }

        function deleteById(id){
            var url = "/accounts/" + id;
            $http.delete(url).then(function(response){
                vm.successDeleteMsg = response.data;
            });
        }

        function editUserAccount(id) {
            $location.path('editUserAccount/' + userId);
        }
    }
=======
(function () {
    'use strict';

    angular
        .module('app')
        .controller('AccountsController', AccountsController);

    AccountsController.$inject = ['$http', '$location'];

    function AccountsController($http) {
        var vm = this;

        vm.accounts = [];
//        vm.successDeleteMsg = "";
        vm.getAll = getAll;
        vm.deleteById = deleteById;
        vm.editUserAccount = editUserAccount;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/accounts";
            var accountsPromise = $http.get(url);
            accountsPromise.then(function(response){
                vm.accounts = response.data;
            });
        }

        function deleteById(id){
            var url = "/accounts/" + id;
            $http.delete(url).then(function(response){
                vm.successDeleteMsg = response.data;
            });
        }

        function editUserAccount(id) {
            $location.path('editUserAccount/' + userId);
        }
    }
>>>>>>> b74f18ba09c654dfca642dd884af12d791583ada
})();