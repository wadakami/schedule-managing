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
			<h2>This is holiday!!</h2>
	</c:when>
	<c:otherwise>
	<table>
		<tbody>
			<tr>
				<th>Time</th>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${schedule.teacher != teacher}">
						<th class="teaher_name">
							<a href="<c:url value='/schedule/edit?t=${schedule.teacher}&d=${schedule.date}' />"><c:out value="${schedule.teacher}" /></a>
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
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${teacher1 == null}">
						<c:set var="teacher1" value="${schedule.teacher}" />
						<c:set var="exist1" value="0" />
					</c:if>
					<c:choose>
						<c:when test="${schedule.time == 1}">
							<td style="color: ${schedule.user.color}">
								<c:out value="${schedule.student}" /><br />
								<c:out value="${schedule.book}" />
								<c:set var="exist1" value="1" />
							</td>
						</c:when>
					</c:choose>
				</c:forEach>
			</tr>
			<tr>
				<td>
					2nd<br />
					09:30 - 10:20
				</td>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${teacher2 == null}">
						<c:set var="teacher2" value="${schedule.teacher}" />
						<c:set var="exist2" value="0" />
					</c:if>
					<c:choose>
						<c:when test="${schedule.teacher != teacher2}">
								<c:if test="${exist2 == 0}">
									<td></td>
								</c:if>
							<c:set var="exist2" value="0" />
						</c:when>
						<c:when test="${schedule.time == 2}">
							<td style="color: ${schedule.user.color}">
								<c:out value="${schedule.student}" /><br />
								<c:out value="${schedule.book}" />
								<c:set var="exist2" value="1" />
							</td>
						</c:when>
					</c:choose>
				<c:set var="teacher2" value="${schedule.teacher}" />
				</c:forEach>
			</tr>
			<tr>
				<td>
					3rd<br />
					10:30 - 11:20
				</td>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${teacher3 == null}">
						<c:set var="teacher3" value="${schedule.teacher}" />
						<c:set var="exist3" value="0" />
					</c:if>
					<c:choose>
						<c:when test="${schedule.teacher != teacher3}">
								<c:if test="${exist3 == 0}">
									<td></td>
								</c:if>
							<c:set var="exist3" value="0" />
						</c:when>
						<c:when test="${schedule.time == 3}">
							<td style="color: ${schedule.user.color}">
								<c:out value="${schedule.student}" /><br />
								<c:out value="${schedule.book}" />
								<c:set var="exist3" value="1" />
							</td>
						</c:when>
					</c:choose>
				<c:set var="teacher3" value="${schedule.teacher}" />
				</c:forEach>
			</tr>
			<tr>
				<td>
					4th<br />
					11:30 - 12:20
				</td>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${teacher4 == null}">
						<c:set var="teacher4" value="${schedule.teacher}" />
						<c:set var="exist4" value="0" />
					</c:if>
					<c:choose>
						<c:when test="${schedule.teacher != teacher4}">
								<c:if test="${exist4 == 0}">
									<td></td>
								</c:if>
							<c:set var="exist4" value="0" />
						</c:when>
						<c:when test="${schedule.time == 4}">
							<td style="color: ${schedule.user.color}">
								<c:out value="${schedule.student}" /><br />
								<c:out value="${schedule.book}" />
								<c:set var="exist4" value="1" />
							</td>
						</c:when>
					</c:choose>
				<c:set var="teacher4" value="${schedule.teacher}" />
				</c:forEach>
			</tr>
			<tr>
				<td>
					5th<br />
					13:30 - 14:20
				</td>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${teacher5 == null}">
						<c:set var="teacher5" value="${schedule.teacher}" />
						<c:set var="exist5" value="0" />
					</c:if>
					<c:choose>
						<c:when test="${schedule.teacher != teacher5}">
								<c:if test="${exist5 == 0}">
									<td></td>
								</c:if>
							<c:set var="exist5" value="0" />
						</c:when>
						<c:when test="${schedule.time == 5}">
							<td style="color: ${schedule.user.color}">
								<c:out value="${schedule.student}" /><br />
								<c:out value="${schedule.book}" />
								<c:set var="exist5" value="1" />
							</td>
						</c:when>
					</c:choose>
				<c:set var="teacher5" value="${schedule.teacher}" />
				</c:forEach>
			</tr>
			<tr>
				<td>
					6th<br />
					14:30 - 15:20
				</td>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${teacher6 == null}">
						<c:set var="teacher6" value="${schedule.teacher}" />
						<c:set var="exist6" value="0" />
					</c:if>
					<c:choose>
						<c:when test="${schedule.teacher != teacher6}">
								<c:if test="${exist6 == 0}">
									<td></td>
								</c:if>
							<c:set var="exist6" value="0" />
						</c:when>
						<c:when test="${schedule.time == 6}">
							<td style="color: ${schedule.user.color}">
								<c:out value="${schedule.student}" /><br />
								<c:out value="${schedule.book}" />
								<c:set var="exist6" value="1" />
							</td>
						</c:when>
					</c:choose>
				<c:set var="teacher6" value="${schedule.teacher}" />
				</c:forEach>
			</tr>
			<tr>
				<td>
					7th<br />
					15:30 - 16:20
				</td>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${teacher7 == null}">
						<c:set var="teacher7" value="${schedule.teacher}" />
						<c:set var="exist7" value="0" />
					</c:if>
					<c:choose>
						<c:when test="${schedule.teacher != teacher7}">
								<c:if test="${exist7 == 0}">
									<td></td>
								</c:if>
							<c:set var="exist7" value="0" />
						</c:when>
						<c:when test="${schedule.time == 7}">
							<td style="color: ${schedule.user.color}">
								<c:out value="${schedule.student}" /><br />
								<c:out value="${schedule.book}" />
								<c:set var="exist7" value="1" />
							</td>
						</c:when>
					</c:choose>
				<c:set var="teacher7" value="${schedule.teacher}" />
				</c:forEach>
			</tr>
			<tr>
				<td>
					8th<br />
					16:30 - 17:20
				</td>
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${teacher8 == null}">
						<c:set var="teacher8" value="${schedule.teacher}" />
						<c:set var="exist8" value="0" />
					</c:if>
					<c:choose>
						<c:when test="${schedule.teacher != teacher8}">
								<c:if test="${exist8 == 0}">
									<td></td>
								</c:if>
							<c:set var="exist8" value="0" />
						</c:when>
						<c:when test="${schedule.time == 8}">
							<td style="color: ${schedule.user.color}">
								<c:out value="${schedule.student}" /><br />
								<c:out value="${schedule.book}" />
								<c:set var="exist8" value="1" />
							</td>
						</c:when>
					</c:choose>
				<c:set var="teacher8" value="${schedule.teacher}" />
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

	<p><a href="<c:url value='/schedule/new?main=teacher' />">Register Schedule:teacher side</a></p>
	<br />
	<p><a href="<c:url value='/schedule/new?main=student' />">Register Schedule:student side</a></p>

	</c:param>
</c:import>
</form>