<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="adminTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<div id="menu-wrapper">
				<div class="menu-element">
					<spring:url value="/order-list" var="orderlistUrl"
						htmlEscape="true" />
					<a href="${orderlistUrl}"><spring:message
							code="admin.order.list" /></a>
				</div>
				<div class="menu-element">
					<c:url value="/j_spring_security_logout" var="logoutUrl" />
					<a href="${logoutUrl}"><spring:message code="admin.logout" /></a>
				</div>
			</div>
			<div class="order-view">
				<div id="bouquet-wrapper" style="margin-left:130px;">
					<div id="bouquet">"${positions}"</div>
				</div>
				<div class="order-info">
					<spring:message code="admin.order.name" />
					${orderTO.customerName} <br />
					<spring:message code="admin.order.phone" />
					${orderTO.customerPhone} <br />
					<spring:message code="admin.order.address" />${orderTO.address}
					<br />
					<spring:message code="admin.order.date" />
					<fmt:formatDate value="${orderTO.creationDate}"
						pattern="dd/MM/yyyy" />
					<br />
					<spring:message code="admin.order.price" />
					${orderTO.cost} <br />
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>