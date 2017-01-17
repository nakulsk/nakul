app.controller('JobController', function($scope, $location, JobService) {
	$scope.job = {
		jobTitle : '',
		jobDescription : '',
		skillsRequired : '',
		salary : '',
		location : ''
	}
	$scope.saveJob = function() {
		console.log('entering save job in job controller')
		JobService.saveJob($scope.job).then(function(response) {
			console.log("successfully inserted job details");
			alert("Posted job successfully");
			$location.path('/home');
		}, function(response) {
			console.log("failure " + response.status);
			console.log(response.data.message)
			$location.path('/postJob')
		})
	}

	function getAllJobs() {
		console.log("entering all get jobs")
		JobService.getAllJobs().then(function(response) {
			console.log(response.status);
			$scope.jobs = response.data;
		}, function(response) {
			console.log(response.status)
		})

	}
	getAllJobs();
	$scope.getJobDetail=function(jobId){
		JobService.getJobDetail(jobId)
	.then(function(response){
		$scope.jobDetail=response.data; // single Job object
		console.log(response.status)
		
	},function(response){
		console.log(response.status)
	})
	}
})