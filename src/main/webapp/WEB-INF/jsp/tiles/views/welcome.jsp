<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="clientTemplate">
	<tiles:putAttribute name="body">
		<div class="content-wrapper">
			<div class="welcome-page">
				<div class="welcome-div">
					<a class="welcome-link" href="/flowers-1.0/create-by-yourself" ><spring:message code="client.create.by.yourself" /></a>
				</div>
				<div class="welcome-div">
					<a class="welcome-link" href="/flowers-1.0/create-by-choosing" ><spring:message code="client.create.by.generator" /></a>
				</div>
                <div class="welcome-div">
                    <a class="welcome-link" href="/flowers-1.0/create-by-quest" ><spring:message code="client.create.by.quest" /></a>
                </div>
			</div>
			<div class="content">
				<div class="login">
					<form method="post" action="<c:url value='/j_spring_security_check' />">
						<div>${message}</div>
						<div id="input-label-login">
							<div id="login-labels">
								<div class="login-label-line">
									<label for="login"><spring:message code="admin.login" /></label>
								</div>
								<div class="login-label-line">
									<label for="password"><spring:message code="admin.password" /></label>
								</div>
							</div>
							<div id="login-input">
								<input class="login-input-line" type="text" name="j_username"
									required>
									 <input class="login-input-line"
									type="password" name="j_password" required>
							</div>
						</div>
						<div id="submit-btn">
							<input class="btn" name="submit" type="submit" value="<spring:message code="admin.btn.login" />">
						</div>
					</form>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>