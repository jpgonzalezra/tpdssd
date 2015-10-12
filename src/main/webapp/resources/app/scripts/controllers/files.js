'use strict';

clientApp.controller('DriveCtrl', function ($scope, $http, $resource, $routeParams, $location, $dialog) {

    $http.get('/drive/files').
        success(function (data) {
            $scope.files = data;
        });

});