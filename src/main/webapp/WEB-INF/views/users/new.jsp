<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<h2>New User Register</h2>

		<form method="post" action="<c:url value='/users/create' />">
			<c:import url="_form.jsp" />
		</form>

		<p><a href="<c:url value='/users/index' />">||Back to Index||</a></p>
	</c:param>
</c:import>