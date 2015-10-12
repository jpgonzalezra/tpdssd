'use strict';

// Declare app level module which depends on filters, and services
var clientApp = angular.module('clientApp',
		[ 'ngResource', 'ui.utils', 'ui.date', 'ui.bootstrap' ]).config(
		function($routeProvider, $dialogProvider) {
			$routeProvider.when('/drive/files', {
				templateUrl: 'resources/app/views/files.html',
				controller: 'DriveCtrl'
			});

			$dialogProvider.options({
				backdropFade : true,
				dialogFade : true
			});
		});
