<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title><spring:message code="admin.page.order" /></title>
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/checkbox.js" />"></script>
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/paginate.js" />"></script>
<script src="<c:url value="/resources/js/custom.js" />"></script>
<!--[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	<div id="wrapper">
		<tiles:insertAttribute name="header" />
		<div class="admin-content">
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>