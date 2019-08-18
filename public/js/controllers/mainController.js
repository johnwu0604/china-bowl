/**
 * Created by JohnWu on 2016-12-27.
 */
angular.module('mainController', [])

    .controller('menu', ['$scope', '$http', 'Menu', function($scope, $http, Menu)  {

        Menu.get().success(function(data) {

            console.log(data);

            $scope.menu = data;

        });

    }]);
