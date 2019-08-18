/**
 * Created by JohnWu on 2016-12-27.
 */
angular.module('menuService', []).factory('Menu', ['$http',function($http) {
    return {
        get : function() {
            return $http.get('/api/menu');
        }
    }
}]);
