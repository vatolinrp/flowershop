<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="menu-wrapper">
	<div id="menu-list">
		<div class="menu-element">
			<spring:url value="/order-list" var="orderlistUrl" htmlEscape="true" />
			<a href="${orderlistUrl}">
			    <spring:message code="admin.order.list" />
			</a>
		</div>
		<div class="menu-element">
			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<a href="${logoutUrl}">
			    <spring:message code="admin.logout" />
			</a>
		</div>
	</div>
</div>