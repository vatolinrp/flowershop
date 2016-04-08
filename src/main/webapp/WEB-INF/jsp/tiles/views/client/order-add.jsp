<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="clientTemplate">
	<tiles:putAttribute name="body">
		<div class="body-client">
			<div id="news-add-edit-wrapper">
				<form:form method="post" name="OrderForm" onsubmit="return validateForm('${pageContext.response.locale.language}')"
				 action="/flowers-1.0/save-order" commandName="order" style="float: left;">
					<div id="editNews">
						<div class="input-component">
							<div class="component-name">
								<spring:message code="admin.customer.name" />
							</div>
							<div class="content-component">
								<form:input path="customerName" id="name-input"
									placeholder="Ivanov Ivan Ivanovich" />
							</div>
						</div>
						<div class="input-component">
							<div class="component-name">
								<spring:message code="admin.customer.phone" />
							</div>
							<div class="content-component">
								<form:input path="customerPhone" id="phone-input"
									placeholder="8###########" />
							</div>
						</div>
						<div class="input-component">
							<div class="component-name">
								<spring:message code="admin.order.address" />
							</div>
							<div class="content-component">
								<form:textarea id="address-input" rows="5" cols="50"
									path="address"
									placeholder="Belarus, Minsk, Bogdanovicha street, 20 house, 10 ap" />
							</div>
						</div>
						<div class="input-component">
							<div class="component-name">
								<spring:message code="admin.order.cost" />
							</div>
							<div class="content-component">
								<form:input id="cost-input"	path="cost"	placeholder="cost will be here" readonly="readonly" />
							</div>
						</div>
						<input type="submit" id="save-btn"
							value="<spring:message code="btn.confirm" />">
					</div>
					<form:input type="hidden" path="placement"/>
				</form:form>
				<div id="bouquet-wrapper">
                    ${dynamicBouquet}
                </div>
  <div id="columns" class="result">
  	${possible_flowers}
  </div>
  <input type="hidden" name="mouseTracker" id="mouseTracker">
				
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<script src="<c:url value="/resources/js/choose.js" />"></script>

			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>