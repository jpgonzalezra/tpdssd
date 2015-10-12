'use strict';

clientApp.controller('DriveCtrl', function ($scope, $http, $resource, $routeParams, $location, $dialog) {

    $scope.files = function () {
        $http.get('/drive/files', $scope.files).success(function () {
            $location.path('/drive/files');
        });
    };

});