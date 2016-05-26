var app = angular.module('deductiveMachineApp', []);
app.controller('questionController', function($scope) {
		var model = {
			showQuestion: false,
			showUserInput: false,
			question: 'Question',
			options: ['1', '2', '3'],
			answer: '1'
		};		
		var callbackForMachine;
		$scope.model = model;
		
		$scope.askQuestion = function(question, values, withUserValue, callback) {
			model.showQuestion = true;
			model.question = question;
			model.options = values;
			model.answer = model.options[0];
			model.showUserInput = withUserValue;
			if(model.showUserInput) {
				model.userInputValue = undefined;
			}
			callbackForMachine = callback;
		};
		
		$scope.okButtonClicked = function() {
			callbackForMachine(model.answer);
			var result = machine.nextIteration();
			if(result === '' || result === '---') {
				alert('Cannot suggest.');
				model.showQuestion = false;
			} else if(result) {
				window.location.href = '/flowers-1.0/order-chosen/' + result;
				model.showQuestion = false;
			}
		}
		
		var machine = new DeductiveOutputMachine($scope.askQuestion);
		
		$scope.startMachine = function() {
			machine.startMachine();
			$scope.targetStack = machine.getTargetStack();
			$scope.contextStack = machine.getContextStack();
		}
	});
	
app.filter('valuesFilter', function() {
	return function(value) {
		return (value === '---') ? 'does not matter/can not find' : value;
	};
});