<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="clientTemplate">
	<tiles:putAttribute name="body">
		<div class="body-client">
			<div id="news-add-edit-wrapper">
				<form:form method="post" action="/flower-shop/result-creation" commandName="orderTO">
					<div id="editNews">
						<div class="cost"><spring:message code="client.order.price" /> ${orderTO.cost}</div>
						<div id="bouquet-wrapper-ready">
							<div id="bouquet">
								"${positions}"
							</div>
						</div>
						<form:hidden path="customerName" value="${orderTO.customerName}"/>
						<form:hidden path="customerPhone" value="${orderTO.customerPhone}"/>
						<form:hidden path="cost" value="${orderTO.cost}"/>
						<form:hidden path="placement" value="${orderTO.placement}"/>
						<form:hidden path="address" value="${orderTO.address}"/>
						<input type="submit" id="create-btn"
							value="<spring:message code="admin.btn.create" />">
					</div>
				</form:form>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>