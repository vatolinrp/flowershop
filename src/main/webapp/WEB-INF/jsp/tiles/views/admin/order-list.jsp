<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="adminTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<form:form method="post" action="order-list" commandName="deleteOrderTO">
				<div class="list-options">
					<div id="submit-btn">
                    	<input class="btn" name="submit" type="submit" value="<spring:message code="admin.btn.delete" />">
                    </div>
					<div class="pagination"></div>
				</div>
				<div class="list-of-posts">
					<c:forEach var="listValue" items="${deleteOrderTO.orderTOList}"	varStatus="status">
						<div class="order-component">
							<div class="title-component">
								<div class="title">${listValue.customerName}</div>
								<div class="author">
									(
									<spring:message code="admin.customer.phone" />
									${listValue.customerPhone} )
								</div>
								<div class="date">
									<fmt:formatDate value="${listValue.creationDate}"
										pattern="dd/MM/yyyy" />
								</div>
							</div>
							<div class="order-content">
								${listValue.address}
							</div>
							<div class="order-footer">
								<div class="checkbox">
									<form:checkbox path="orderTOList[${status.index}].check" value="delete" />
								</div>
								<form:hidden path="orderTOList[${status.index}].orderId" value="${listValue.orderId}" />
								<div class="edit-link">
									<spring:url value="/order-view/${listValue.orderId}"
										var="viewUrl" htmlEscape="true" />
									<a href="${viewUrl}"><spring:message code="link.view" /></a>
								</div>
								<div class="comments">
									<spring:message code="admin.order.cost" />
									(${listValue.cost})
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

			</form:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>