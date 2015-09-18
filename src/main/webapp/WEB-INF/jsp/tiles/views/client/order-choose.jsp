<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="clientTemplate">
	<tiles:putAttribute name="body">
		<div class="body-client">
			<div id="news-add-edit-wrapper">
				<form:form method="post" action="/flower-shop/display-generated"
					commandName="generateVO">
					<div class="set-money">Please enter the amount of money you
						want to spend</div>
					<form:input type="number" path="cost" />
					<div class="set-flowers">Please choose flowers you want to
						have in your bouquet</div>
					<div class="multiselect">
						<div class="selectBox">Please choose flowers</div>
						<div id="checkboxes" style="display: none;">
							<form:checkboxes element="div" items="${flowers}"
								itemValue="flowerId" itemLabel="flowerName" path="FlowerIds" />
						</div>
					</div>
					<script src="<c:url value="/resources/js/checkbox.js" />"></script>
					<input type="submit" value="submit" />
				</form:form>
				<c:forEach var="listValue" items="${placementTOs}">
					<div class="news-component">
						<div id="bouquet-wrapper-ready">
							<div id="bouquet">"${listValue.htmlPlacement}"</div>
						</div>
						<div class="edit-link">
							<spring:url value="/order-view/${listValue.placementId}" var="viewUrl" htmlEscape="true" />
							<a href="${viewUrl}"><spring:message code="link.view" /></a>
						</div>
					</div>
				</c:forEach>
				<div class="pagination"></div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>