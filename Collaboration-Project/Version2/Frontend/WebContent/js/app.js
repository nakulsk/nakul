var app = angular.module("myApp", [ 'ngRoute', 'ngCookies' ])
app.config(function($routeProvider) {
	console.log('entering configuration')
	$routeProvider.when('/login', {
		controller : 'UserController',
		templateUrl : '_user/login.html'
	}).when('/home', {
		templateUrl : '_home/home.html'
	}).when('/register', {
		controller : 'UserController',
		templateUrl : '_user/register.html'
	}).when('/postJob', {
		controller : 'JobController',
		templateUrl : '_job/createJob.html'
	}).when('/logout', {
		controller : 'UserController',
		templateUrl : '_job/createJob.html'
	}).when('/getAllJobs', {
		controller : 'JobController',
		templateUrl : '_job/jobTitles.html'
	}).when('/uploadPicture', {
		templateUrl : '_user/uploadPicture.html'

	}).when('/addPost', {
		controller : 'BlogController',
		templateUrl : '_blog/newPost.html'
	}).when('/getAllBlogs', {
		controller : 'BlogController',
		templateUrl : '_blog/blogList.html'
	}).when('/getBlogDetail/:id', {
		controller : 'BlogDetailController',
		templateUrl : '_blog/getBlogDetail.html'
	}).when('/friendsList', {
		controller : 'FriendController',
		templateUrl : '_friend/listOfFriends.html'
	}).when('/pendingRequest', {
		controller : 'FriendController',
		templateUrl : '_friend/pendingRequest.html'

	})

	.when('/chat', {
		controller : 'ChatCtrl',
		templateUrl : '_chat/chat.html'
	}).when('/detail', {
		templateUrl : '_job/jobdetail.html'
	})

	.when('/getAllUsers', {
		controller : 'UserController',
		templateUrl : '_user/listOfUsers.html'

	});
	app.run(function($cookieStore, $rootScope, $location, UserService) { // entry
		// point

		if ($rootScope.currentUser == undefined)
			$rootScope.currentUser = $cookieStore.get('currentUser')

		$rootScope.logout = function() {
			console.log('logout function')
			delete $rootScope.currentUser;
			$cookieStore.remove('currentUser')
			UserService.logout().then(function(response) {
				console.log("logged out successfully..");
				$rootScope.message = "Logged out Successfully";
				$location.path('/login')
			}, function(response) {
				console.log(response.status);
			})

		}
	})
})
