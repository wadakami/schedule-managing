<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}" />
			</div>
		</c:if>
		<h2>All Users</h2>

		<table id="user_list">
			<tbody>
				<tr>
					<th id="th_id">ID</th>
					<th id="th_name">Name</th>
					<th id="th_privilege">Privilege</th>
					<th id="th_operation">Operation</th>
				</tr>
				<c:forEach var="user" items="${users}" varStatus="status">
					<tr>
						<td style="background: ${user.color}"><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td>
							<c:choose>
								<c:when test="${user.admin_flag == 0}">
									Student
								</c:when>
								<c:when test="${user.admin_flag == 1}">
									Teacher
								</c:when>
								<c:when test="${user.admin_flag == 2}">
									Administrator
								</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${user.delete_flag == 1}">
									(Deleted)
								</c:when>
								<c:otherwise>
									<a href="<c:url value='/users/show?id=${user.id}'/>">Detail</a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="pagenation">
			(${users_count} Users)<br />
			<c:forEach var="i" begin="1" end="${((users_count - 1) / 15) + 1}" step="1">
				<c:choose>
					<c:when test="${i == page}">
						<c:out value="${i}" />&nbsp;
					</c:when>
					<c:otherwise>
						<a href="<c:url value='/users/index?page=${i}' />"></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		<p><a href="<c:url value='/users/new' />">Register NewUser</a></p>
	</c:param>
</c:import>