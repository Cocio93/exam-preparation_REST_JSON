var app = angular.module('personModule', []);

app.controller('myCtrl',['$scope', 'PersonFactory', function($scope, PersonFactory) {
   $scope.fname = false;
   $scope.lname = false;
   $scope.street = false;
   $scope.city = false;
   $scope.isSearched = false;
   $scope.amount = 0;
   
   $scope.persons;
   
   $scope.getPersons = function() {
     if ($scope.amount <= 0) {
         return;
     }
     var params = [];
     if ($scope.fname) {
         params.push("fname");
     }
     if ($scope.lname) {
         params.push("lname");
     }
     if ($scope.street) {
         params.push("street");
     }
     if ($scope.city) {
         params.push("city");
     }     
     PersonFactory.getPersons($scope.amount, params.toString())
             .success(function(data) {
                 $scope.persons = data;
                 $scope.isSearched = true;
     });
   };
   
}]);

app.factory('PersonFactory', function ($http) {
    var baseUrl = '/exam-preparation_REST_JSON/api/addresses';
    return {
        getPersons: function (amount, params) {
            return $http({
                url: baseUrl + '/' + amount + '/' + params,
                method: 'get'
            });
        }
    };
});