<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="header">
	<div id="logo">
		<a class="header-link" href="j_spring_security_logout" >
			<spring:message code="admin.title" />
		</a>
	</div>
	<div id="lang">
		<a class="header-link" href="?lang=en">
			<spring:message code="admin.lang.en" />
		</a>
		<a class="header-link" href="?lang=ru">
			<spring:message code="admin.lang.ru" />
		</a>
	</div>
</div>