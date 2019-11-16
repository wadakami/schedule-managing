<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<c:choose>
			<c:when test="${user != null}">
				<h2>id : ${user.id} edit</h2>
				<p>You must not enter any words in blank unless you change the password.</p>
				<form method="post" action="<c:url value='/users/update' />">
					<c:import url="_form.jsp"></c:import>
				</form>

				<p><a href="#" onclick="confirmDestroy();">||Delete this user||</a></p>
				<form method="post" action="<c:url value="/users/destroy" />">
					<input type="hidden" name="_token" value="${_token}">
				</form>
				<script>
					function confirmDestroy() {
						if(confirm("Really would you like to delete?")) {
							document.forms[1].submit();
						}
					}
				</script>
			</c:when>
			<c:otherwise>
				<h2>It could't be found.</h2>
			</c:otherwise>
		</c:choose>

		<p><a href="<c:url value='/users/index' />">||Back to Index||</a></p>
	</c:param>
</c:import>