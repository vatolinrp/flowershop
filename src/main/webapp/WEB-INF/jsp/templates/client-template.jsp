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
<script>
					function validateForm(lang) {
					    var x = document.forms["OrderForm"]["customerName"].value;
					    if (x == null || x == "" || ((x.length)<3)) {
					    	if(lang=="en"){
					        	alert("Name must be filled out!");
					    	}
					    	if(lang=="ru"){
						        alert("Введите имя правильно!");
						    	}
					        return false;
					    }
					    x = document.forms["OrderForm"]["customerPhone"].value;
					    if(!x.match(/^\d{11}/)){ 
					    	if(lang=="en"){
					    		alert("Phone must be correctly filled out!");
					    	}
					    	if(lang=="ru"){
					    		alert("ВВедите номер телефона правильно!");
					    	}
					    	return false;
					    }
					    x = document.forms["OrderForm"]["placement"].value;
					    if((x.split("#flower").length)==9){
					    	if(lang=="en"){
					    		alert("Placement should have at least one flower!");
					    	}
					    	if(lang=="ru"){
					    		alert("Расставьте цветы!");
					    	}
					    	return false;
					    }
					    x = document.forms["OrderForm"]["address"].value;
					    if (x == null || x == "" || ((x.length)<5)) {
					        
					        if(lang=="en"){
					        	alert("Address must be filled out!");
					    	}
					    	if(lang=="ru"){
					    		alert("Введите адрес правильно!");
					    	}
					        return false;
					    }
					}
					</script>
<!--[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	<div id="wrapper">
		<tiles:insertAttribute name="header" />
		<div id="admin-content">
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>