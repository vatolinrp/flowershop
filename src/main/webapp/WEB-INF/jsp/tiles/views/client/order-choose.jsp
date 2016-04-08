<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="clientTemplate">
	<tiles:putAttribute name="body">
		<div class="body-client">











			<div id="news-add-edit-wrapper">
				<form:form method="post" action="/flowers-1.0/display-history" commandName="choiceVO" style="overflow:hidden;">
					<div class="set-phone"><spring:message code="history.label" /></div>
					<form:input type="number" path="phoneNumber" />
					<input id="save-btn" type="submit" value="<spring:message code="history.btn" />" />
				</form:form>
				<form:form method="post" action="/flowers-1.0/display-celebration/VALENTINES_DAY" commandName="choiceVO">
                  <input id="save-btn" type="submit" value="<spring:message code="v.day.btn" />" />
                </form:form>
                <form:form method="post" action="/flowers-1.0/display-celebration/WOMENS_DAY" commandName="choiceVO">
                  <input id="save-btn" type="submit" value="<spring:message code="w.day.btn" />" />
                </form:form>
                <form:form method="post" action="/flowers-1.0/display-celebration/MOTHERS_DAY" commandName="choiceVO">
                  <input id="save-btn" type="submit" value="<spring:message code="m.day.btn" />" />
                </form:form>
				<c:forEach var="listValue" items="${choiceVO.placementVOList}">
					<div class="news-component">
						<div id="bouquet-wrapper-ready">
							<div id="bouquet">"${listValue.htmlPlacement}"</div>
						</div>
						<div class="edit-link">
						    <div class="price-item">"${listValue.cost}"</div>
						</div>
						<div class="edit-link">
							<spring:url value="/order-chosen/${listValue.placementId}" var="viewUrl" htmlEscape="true" />
							<a href="${viewUrl}"><spring:message code="link.view" /></a>
						</div>
					</div>
				</c:forEach>
				<div class="pagination"></div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>