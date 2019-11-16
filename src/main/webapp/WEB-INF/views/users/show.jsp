<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:choose>
			<c:when test="${user != null}">
				<h2>id : ${user.id} user information</h2>

				<table>
					<tbody>
						<tr>
							<th>Name</th>
							<td><c:out value="${user.name}" /></td>
						</tr>
						<tr>
							<th>Maximum Classes</th>
							<td><c:out value="${user.max}" /></td>
						</tr>
						<tr id="color_number${user.color}">
							<th>Color</th>
							<td style="background: ${user.color}">
								<c:if test="${user.color == '#00ffff'}">0.aqua</c:if>
								<c:if test="${user.color == '#000000'}">1.black</c:if>
								<c:if test="${user.color == '#0000ff'}">2.blue</c:if>
								<c:if test="${user.color == '#ff00ff'}">3.fuchsia</c:if>
								<c:if test="${user.color == '#808080'}">4.gray</c:if>
								<c:if test="${user.color == '#008000'}">5.green</c:if>
								<c:if test="${user.color == '#00ff00'}">6.lime</c:if>
								<c:if test="${user.color == '#800000'}">7.maroon</c:if>
								<c:if test="${user.color == '#000080'}">8.navy</c:if>
								<c:if test="${user.color == '#808000'}">9.olive</c:if>
								<c:if test="${user.color == '#800080'}">10.purple</c:if>
								<c:if test="${user.color == '#ff0000'}">11.red</c:if>
								<c:if test="${user.color == '#c0c0c0'}">12.silver</c:if>
								<c:if test="${user.color == '#008080'}">13.teal</c:if>
								<c:if test="${user.color == '#ffffff'}">14.white</c:if>
								<c:if test="${user.color == '#ffff00'}">15.yellow</c:if>
							</td>
						</tr>
						<tr>
							<th>Available Books</th>
							<td>
								<c:forEach var="book" items="${books}">
									<c:out value="${book}" />,&nbsp;&nbsp;
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>Privilege</th>
							<td>
							<c:choose>
								<c:when test="${user.admin_flag == 0}">Student</c:when>
								<c:when test="${user.admin_flag == 1}">Teacher</c:when>
								<c:when test="${user.admin_flag == 2}">Administrator</c:when>
							</c:choose>
							</td>
						</tr>
					</tbody>
				</table>

				<p><a href="<c:url value='/users/edit?id=${user.id}' />">||Edit this user||</a></p>
			</c:when>
			<c:otherwise>
				<h2>It could't be found.</h2>
			</c:otherwise>
		</c:choose>

		<p><a href="<c:url value='/users/index' />">||Back to Index||</a></p>
	</c:param>
</c:import>