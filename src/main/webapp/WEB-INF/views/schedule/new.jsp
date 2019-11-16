<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<h2>Register New Schedule</h2>

			<form id="form_id" method="post" action="<c:url value='/schedule/create' />">
				<c:import url="_form.jsp" />
			</form>

		<p><a href="<c:url value='/schedule/index' />">||Go TO Index||</a></p>
	</c:param>
</c:import>