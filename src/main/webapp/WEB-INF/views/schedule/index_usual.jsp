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
			&nbsp;<button type="submit">Go to the day&gt;&gt;</button>
		</h2>
		<br /><br />
		<input type="hidden" name="name" value="${name}" />
		<input type="hidden" name="login_user" value="${login_user}" />

<c:choose>
	<c:when test="${holiday == 9}">
			<h2>Today is holiday!!</h2>
	</c:when>
	<c:otherwise>

	<c:set var="exist" value="0" />
	<table>
		<tbody>
			<tr>
				<th>Time</th>
				<th>
					<a href="<c:url value='/schedule/edit?t=${name}&d=${date}' />">
					<c:out value="${name}" /></a><br />
				</th>
			</tr>
			<tr>
				<td>
					1st<br />
					08:30 - 09:20
				</td>
				<c:choose>
					<c:when test="${login_id == 0}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 1}">
								<td>
									<c:out value="${schedule.teacher}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
					<c:when test="${login_id == 1}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 1}">
								<td>
									<c:out value="${schedule.student}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
				</c:choose>
				<c:set var="exist" value="0" />
			</tr>
			<tr>
				<td>
					2nd<br />
					09:30 - 10:20
				</td>
				<c:choose>
					<c:when test="${login_id == 0}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 2}">
								<td>
									<c:out value="${schedule.teacher}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
					<c:when test="${login_id == 1}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 2}">
								<td>
									<c:out value="${schedule.student}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
				</c:choose>
				<c:set var="exist" value="0" />
			</tr>
			<tr>
				<td>
					3rd<br />
					10:30 - 11:20
				</td>
				<c:choose>
					<c:when test="${login_id == 0}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 3}">
								<td>
									<c:out value="${schedule.teacher}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
					<c:when test="${login_id == 1}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 3}">
								<td>
									<c:out value="${schedule.student}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
				</c:choose>
				<c:set var="exist" value="0" />
			</tr>
			<tr>
				<td>
					4th<br />
					11:30 - 12:20
				</td>
				<c:choose>
					<c:when test="${login_id == 0}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 4}">
								<td>
									<c:out value="${schedule.teacher}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
					<c:when test="${login_id == 1}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 4}">
								<td>
									<c:out value="${schedule.student}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
				</c:choose>
				<c:set var="exist" value="0" />
			</tr>
			<tr>
				<td>
					5th<br />
					13:30 - 14:20
				</td>
				<c:choose>
					<c:when test="${login_id == 0}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 5}">
								<td>
									<c:out value="${schedule.teacher}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
					<c:when test="${login_id == 1}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 5}">
								<td>
									<c:out value="${schedule.student}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
				</c:choose>
				<c:set var="exist" value="0" />
			</tr>
			<tr>
				<td>
					6th<br />
					14:30 - 15:20
				</td>
				<c:choose>
					<c:when test="${login_id == 0}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 6}">
								<td>
									<c:out value="${schedule.teacher}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
					<c:when test="${login_id == 1}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 6}">
								<td>
									<c:out value="${schedule.student}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
				</c:choose>
				<c:set var="exist" value="0" />
			</tr>
			<tr>
				<td>
					7th<br />
					15:30 - 16:20
				</td>
				<c:choose>
					<c:when test="${login_id == 0}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 7}">
								<td>
									<c:out value="${schedule.teacher}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
					<c:when test="${login_id == 1}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 7}">
								<td>
									<c:out value="${schedule.student}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
				</c:choose>
				<c:set var="exist" value="0" />
			</tr>
			<tr>
				<td>
					8th<br />
					16:30 - 17:20
				</td>
				<c:choose>
					<c:when test="${login_id == 0}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 8}">
								<td>
									<c:out value="${schedule.teacher}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
					<c:when test="${login_id == 1}">
						<c:forEach var="schedule" items="${schedules}">
							<c:if test="${schedule.time == 8}">
								<td>
									<c:out value="${schedule.student}" /><br />
									<c:out value="${schedule.book}" />
									<c:set var="exist" value="1" />
								</td>
							</c:if>
						</c:forEach>
						<c:if test="${exist == 0}">
							<td>
								<br />
							</td>
						</c:if>
					</c:when>
				</c:choose>
				<c:set var="exist" value="0" />
			</tr>
		</tbody>
	</table>
</c:otherwise>
</c:choose>

	</c:param>
</c:import>
</form>