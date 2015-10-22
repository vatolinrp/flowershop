<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="clientTemplate">
	<tiles:putAttribute name="body">
		<div class="body-client">
			<div id="news-add-edit-wrapper">
				<form:form method="post" action="/confirmed" commandName="fOrder">
					<div id="editNews">
						<div class="order-info">
							<spring:message code="admin.order.name" />
							${fOrder.customerName}
							<br />
							<spring:message code="admin.order.phone" />
							${fOrder.customerPhone}
							<br />
							<spring:message code="admin.order.address" />
							${fOrder.address}
							<br />
							<spring:message code="admin.order.price" />
							${fOrder.cost} <br />
						</div>
						<div id="bouquet-wrapper-ready">
							<div id="bouquet">
								"${positions}"
							</div>
						</div>

						<form:hidden path="customerName" value="${fOrder.customerName}"/>
						<form:hidden path="customerPhone" value="${fOrder.customerPhone}"/>
						<form:hidden path="cost" value="${fOrder.cost}"/>
						<form:hidden path="placement" value="${fOrder.placement}"/>
						<form:hidden path="address" value="${fOrder.address}"/>
						<input type="submit" id="create-btn"
							value="<spring:message code="btn.confirm" />">
					</div>
				</form:form>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>