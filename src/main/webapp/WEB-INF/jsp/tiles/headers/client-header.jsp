<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="header">
	<div id="logo">
		<a class="header-link" href="/flowers-1.0/">
			<spring:message code="client.title" />
		</a>
	</div>
	<div id="lang">
		<a class="header-link" href="?lang=en" >
			<spring:message code="admin.lang.en" />
		</a>
		<a class="header-link" href="?lang=ru" >
			<spring:message code="admin.lang.ru" />
		</a>
	</div>
</div>