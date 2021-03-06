<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tiles:insertDefinition name="clientTemplate">
	<tiles:putAttribute name="body">
		<div class="body-client">
			<spring:message code="client.error" />
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>