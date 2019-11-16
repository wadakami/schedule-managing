<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form method="post" action="<c:url value='/schedule/copy' />">
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:if test="${errors != null}">
			<div id="flush_error">
				You have some errors.<br />
				<c:forEach var="error" items="${errors}">
					・<c:out value="${error}" /><br />
				</c:forEach>
			</div>
		</c:if>

		<h2>Original Schedule of&nbsp;
			<c:out value="${date}" />
		</h2>
		<br /><br />

		<p>Start
			<input type="date" name="date_1" value="<fmt:formatDate value='${date_1}' pattern='yyyy-MM-dd' />" />
		</p>
		&nbsp;&nbsp;&nbsp;
		<p>until then
			<input type="date" name="date_2" value="<fmt:formatDate value='${date_2}' pattern='yyyy-MM-dd' />" />
		</p>
		<br /><br />
		<input type="hidden" name="date" value="${date}">



		<button type="submit">Duplicate&gt;&gt;</button>


		<p><a href="<c:url value='/schedule/index' />">||Go TO Index||</a></p>

	</c:param>
</c:import>
</form>