<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<c:if test="${hasError}">
			<div id="flsuh_error">
				You have gotten wrong to enter the name.
			</div>
		</c:if>
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}" />
			</div>
		</c:if>
		<h2>LOGIN</h2>
		<form method="post" action="<c:url value='/login'/>">
			<label for="name">User Name</label><br />
			<input type="text" name="name" value="${name}" />
			<br /><br />

			<label for="password">Password</label><br />
			<input type="password" name="password" />
			<br /><br />

			<input type="hidden" name="_token" value="${_token}" />
			<button type="submit">Login</button>
		</form>
	</c:param>
</c:import>
