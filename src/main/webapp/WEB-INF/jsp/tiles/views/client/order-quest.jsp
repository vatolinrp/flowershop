<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="clientTemplate">
	<tiles:putAttribute name="body">
		<div class="body-client">
			<div id="news-add-edit-wrapper">
                <div ng-app="deductiveMachineApp">
                    <div ng-controller="questionController">
                        <div class="page-header">
                           <h1 ng-show="!model.showQuestion">
                              Lets find best bouquet!
                           </h1>
                           <h1 ng-show="model.showQuestion">
                                working...
                           </h1>
                        </div>
                        <div class="container">
                            <div ng-show="model.showQuestion">
                                <h3 style="color: red;">{{model.question}}</h3>
                                <div ng-repeat="option in model.options">
                                    <label>
                                        <input type="radio" value="{{option}}" ng-model="model.answer" />
                                        {{option}}
                                    </label>
                                </div>
                                <div ng-show="model.showUserInput"><label><input type="radio" value="---" ng-model="model.answer"> other </label></div>
                                <div class="col-md-2">
                                    <button ng-click="okButtonClicked()" class="btn btn-primary center-block">OK</button>
                                </div>
                            </div>
                            <button ng-show="!model.showQuestion" ng-click="startMachine()" class="btn btn-success">lets start!!!</button>
                        </div>
                        <div ng-show="model.showQuestion" class="row col-md-12" style="padding-top: 60px;">

                        </div>
                    </div>
                </div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>