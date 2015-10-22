<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="adminTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<div class="order-view">
				<div id="bouquet-wrapper">
					<div id="bouquet">
						"${positions}"
					</div>
				</div>
				<div class="order-info">
					<spring:message code="admin.order.name" />
					${order.customerName}
					<br />
					<spring:message code="admin.order.phone" />
					${order.customerPhone}
					<br />
					<spring:message code="admin.order.address" />
					${order.address}
					<br />
					<spring:message code="admin.order.date" />
					<fmt:formatDate value="${orderTO.creationDate}"	pattern="dd/MM/yyyy" />
					<br />
					<spring:message code="admin.order.price" />
					${order.cost}
					<br />
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>