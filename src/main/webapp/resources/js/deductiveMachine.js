function DeductiveOutputMachine(askQuestion) {
	var self = this;
	var resultTarget = 'bouquet_id';
	var targetsStack = {
		features: [resultTarget],
		rulesIds: []
	};
	var contextStack = {};
	var isAlgorithmOver = false;
	var discardPile = {};
	var ruleId;
	
	this.getTargetStack = function() {
		return targetsStack;
	}
	
	this.getContextStack = function() {
		return contextStack;
	}
	
	function getTargetFeature() {
		if(targetsStack.features.length !== 0) {
			return targetsStack.features[targetsStack.features.length - 1];
		}
	}
	
	function getTargetRule() {
		if(targetsStack.rulesIds.length !== 0) {
			return targetsStack.rulesIds[targetsStack.rulesIds.length - 1];
		}
	}
	
	function analyzeRuleValue(rule) {
		function countRuleMeaning(rule) {
			var answer = true;
			for(condition in rule.conditions) {
				if(contextStack[condition] === undefined) {
					answer = undefined;
				} else if(contextStack[condition] !== rule.conditions[condition]) {
					return false;
				}
			}
			return answer;
		}
		
		var ruleMeaning = countRuleMeaning(rule);
		if(ruleMeaning === true) {
			for(key in rule.answer) {
				contextStack[key] = rule.answer[key];
			}
			targetsStack.features.pop();
			ruleId = targetsStack.rulesIds.pop();
			if(targetsStack.features.length === 0) {
				isAlgorithmOver = true;
			}
		} else if(ruleMeaning === false) {
			discardPile[rule.id] = true;
			ruleId = undefined;
		} else {
			for(key in rule.conditions) {
				if(!contextStack[key]) {
					targetsStack.features.push(key);
					targetsStack.rulesIds.push(rule.id);
					ruleId = undefined;
					return;
				}
			}
		}
	}
	
	function receiveValueFromUser() {
		function getOptionsForCondition(target) {
			var options = [];
			knowledgeBase.forEach(function(rule) {
				for(key in rule.conditions) {
					if(key === target) {
						if(options.indexOf(rule.conditions[key]) === -1) {
							options.push(rule.conditions[key]);
						}
					}
				}
			});
			return options;
		}
		
		var target = getTargetFeature();
		askQuestion(russianNames[target], getOptionsForCondition(target), !fullValuesSet[target], function(answer) {
			var key = targetsStack.features.pop();
			contextStack[key] = answer;
			ruleId = targetsStack.rulesIds.pop();
		});
	}
	
	this.startMachine = function() {
		resultTarget = 'bouquet_id';
		targetsStack = {
			features: [resultTarget],
			rulesIds: []
		};
		contextStack = {};
		isAlgorithmOver = false;
		discardPile = {};
		ruleId;	
		self.nextIteration();
	}
	
	this.nextIteration = function() {
		function next() {
			function findRule(ruleId) {
				var count = 0;
				var target = getTargetFeature();
				for(data of knowledgeBase) {
					if(ruleId && data.id === ruleId) {
						return data;
					} else {
						if(data.answer[target]) {
							if(!discardPile[data.id]) {
								ruleId = data.id;
								return data;
							} else {
								++count;
							}
						}
					}
				}
				if(count !== 0) {
					return -1;
				}
			}
			
			var rule = findRule(ruleId);
			if(rule === -1) {
				contextStack[targetsStack.features.pop()] = '---';
				ruleId = targetsStack.rulesIds.pop();
				if(targetsStack.features.length === 0) {
					isAlgorithmOver = true;
				}
				return true;
			} else {			
				if(rule) {
					analyzeRuleValue(rule);
					return true;
				} else {
					receiveValueFromUser();
					return false;
				}
			}
		}
		
		var isNeedMore = true;
		while(isNeedMore) {
			if(!isAlgorithmOver) {
				isNeedMore = next();
			} else {
				var result = contextStack[resultTarget];
				if(!result) result = '';
				return result;
			}
		}
	};
}