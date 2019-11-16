<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form method="post" action="<c:url value='/schedule/show' />">
<c:import url="../layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}" />
			</div>
		</c:if>

		<h2>Schedule of
			<input type="date" name="date" value="<fmt:formatDate value='${date}' pattern='yyyy-MM-dd' />" />
			&nbsp;<button type="submit" name="action" value="check">Go to the day&gt;&gt;</button>
		</h2>
		<br /><br />
<c:choose>
	<c:when test="${holiday == 9}">
			<h2>Today is holiday!!</h2>
	</c:when>
	<c:otherwise>

	<table>
		<tbody>
			<tr>
				<th>Time</th>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${schedule.teacher != teacher}">
						<th class="teaher_name">
							<a href="<c:url value='/schedule/edit?t=${schedule.teacher}&d=${schedule.date}&main=teacher' />"><c:out value="${schedule.teacher}" /></a>
						</th>
					</c:if>
					<c:set var="teacher" value="${schedule.teacher}" />
				</c:forEach>
			</tr>
			<tr>
				<td>
					1st<br />
					08:30 - 09:20
				</td>
				<c:forEach var="schedule" items="${time_1}">
					<c:choose>
						<c:when test="${schedule != null}">
							<td style="color: ${schedule.user.color}">
								<a href="<c:url value='/schedule/edit?t=${schedule.student}&d=${schedule.date}&main=student' />">
								<c:out value="${schedule.student}" /></a><br />
								<c:out value="${schedule.book}" />
							</td>
						</c:when>
						<c:otherwise>
							<td><br /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td>
					2nd<br />
					09:30 - 10:20
				</td>
				<c:forEach var="schedule" items="${time_2}">
					<c:choose>
						<c:when test="${schedule != null}">
							<td style="color: ${schedule.user.color}">
								<a href="<c:url value='/schedule/edit?t=${schedule.student}&d=${schedule.date}&main=student' />">
								<c:out value="${schedule.student}" /></a><br />
								<c:out value="${schedule.book}" />
							</td>
						</c:when>
						<c:otherwise>
							<td><br /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td>
					3rd<br />
					10:30 - 11:20
				</td>
				<c:forEach var="schedule" items="${time_3}">
					<c:choose>
						<c:when test="${schedule != null}">
							<td style="color: ${schedule.user.color}">
								<a href="<c:url value='/schedule/edit?t=${schedule.student}&d=${schedule.date}&main=student' />">
								<c:out value="${schedule.student}" /></a><br />
								<c:out value="${schedule.book}" />
							</td>
						</c:when>
						<c:otherwise>
							<td><br /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td>
					4th<br />
					11:30 - 12:20
				</td>
				<c:forEach var="schedule" items="${time_4}">
					<c:choose>
						<c:when test="${schedule != null}">
							<td style="color: ${schedule.user.color}">
								<a href="<c:url value='/schedule/edit?t=${schedule.student}&d=${schedule.date}&main=student' />">
								<c:out value="${schedule.student}" /></a><br />
								<c:out value="${schedule.book}" />
							</td>
						</c:when>
						<c:otherwise>
							<td><br /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td>
					5th<br />
					13:30 - 14:20
				</td>
				<c:forEach var="schedule" items="${time_5}">
					<c:choose>
						<c:when test="${schedule != null}">
							<td style="color: ${schedule.user.color}">
								<a href="<c:url value='/schedule/edit?t=${schedule.student}&d=${schedule.date}&main=student' />">
								<c:out value="${schedule.student}" /></a><br />
								<c:out value="${schedule.book}" />
							</td>
						</c:when>
						<c:otherwise>
							<td><br /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td>
					6th<br />
					14:30 - 15:20
				</td>
				<c:forEach var="schedule" items="${time_6}">
					<c:choose>
						<c:when test="${schedule != null}">
							<td style="color: ${schedule.user.color}">
								<a href="<c:url value='/schedule/edit?t=${schedule.student}&d=${schedule.date}&main=student' />">
								<c:out value="${schedule.student}" /></a><br />
								<c:out value="${schedule.book}" />
							</td>
						</c:when>
						<c:otherwise>
							<td><br /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td>
					7th<br />
					15:30 - 16:20
				</td>
				<c:forEach var="schedule" items="${time_7}">
					<c:choose>
						<c:when test="${schedule != null}">
							<td style="color: ${schedule.user.color}">
								<a href="<c:url value='/schedule/edit?t=${schedule.student}&d=${schedule.date}&main=student' />">
								<c:out value="${schedule.student}" /></a><br />
								<c:out value="${schedule.book}" />
							</td>
						</c:when>
						<c:otherwise>
							<td><br /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td>
					8th<br />
					16:30 - 17:20
				</td>
				<c:forEach var="schedule" items="${time_8}">
					<c:choose>
						<c:when test="${schedule != null}">
							<td style="color: ${schedule.user.color}">
								<a href="<c:url value='/schedule/edit?t=${schedule.student}&d=${schedule.date}&main=student' />">
								<c:out value="${schedule.student}" /></a><br />
								<c:out value="${schedule.book}" />
							</td>
						</c:when>
						<c:otherwise>
							<td><br /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	</c:otherwise>
</c:choose>

	<br />
	<c:if test="${login_id == 2}">
		&nbsp;<button type="submit" name="action" value="copy">Copy this day&gt;&gt;</button>
	</c:if>

	<p><a href="<c:url value='/schedule/new?main=teacher&d=${date}' />">Register Schedule:teacher side</a></p>

	<p><a href="<c:url value='/schedule/new?main=student&d=${date}' />">Register Schedule:student side</a></p>

	</c:param>
</c:import>
</form>