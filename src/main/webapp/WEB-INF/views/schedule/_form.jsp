<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
	<div id="flush_error">
		You have some errors.<br />
		<c:forEach var="error" items="${errors}">
			・<c:out value="${error}" /><br />
		</c:forEach>
	</div>
</c:if>

<label for="date">DATE</label><br />
<input type="date" name="date" id="date" value="<fmt:formatDate value='${date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="teacher">Teacher</label><br />
		<select name="main_user" id="main_user">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${teacher == user.name}">selected</c:if>>
				<c:out value="${user.name}" /></option></c:if>
			</c:forEach>
		</select>
		<br /><br />
		<input type="hidden" name="main" id="main" value="teacher" />
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Student</label><br />
		<select name="main_user" id="main_student">
		<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${student == user.name}">selected</c:if>>
				<c:out value="${user.name}" /></option></c:if>
			</c:forEach>
		</select>
		<br /><br />
		<input type="hidden" name="main" id="main" value="student" />
	</c:when>
</c:choose>


<label for="time">1st: 08:30 - 09:20</label>
&nbsp;&nbsp;

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="student">Student</label>
		<select name="user_1" id="user_1">
			<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${user_1 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Teacher</label>
		<select name="user_1" id="user_1">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${user_1 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
</c:choose>

<label for="book">Book</label>
	<select name="book_1" id="book_1">
		<option value="">--Choose Book--</option>
			<c:forEach var="book" items="${books_01}">
				<option value="${book}"<c:if test="${book_1 == book}">selected</c:if>>
					<c:out value="${book}" />
				</option>
			</c:forEach>
	</select>
<br /><br />


<label for="time">2nd: 09:30 - 10:20</label>
&nbsp;&nbsp;

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="student">Student</label>
		<select name="user_2" id="user_2">
			<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${user_2 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Teacher</label>
		<select name="user_2" id="user_2">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${user_2 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
</c:choose>

<label for="book">Book</label>
	<select name="book_2" id="book_2">
		<option value="">--Choose Book--</option>
			<c:forEach var="book" items="${books_02}">
				<option value="${book}"<c:if test="${book_2 == book}">selected</c:if>>
					<c:out value="${book}" />
				</option>
			</c:forEach>
	</select>
<br /><br />


<label for="time">3rd: 10:30 - 11:20</label>
&nbsp;&nbsp;

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="student">Student</label>
		<select name="user_3" id="user_3">
			<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${user_3 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Teacher</label>
		<select name="user_3" id="user_3">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${user_3 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
</c:choose>


<label for="book">Book</label>
	<select name="book_3" id="book_3">
		<option value="">--Choose Book--</option>
			<c:forEach var="book" items="${books_03}">
				<option value="${book}"<c:if test="${book_3 == book}">selected</c:if>>
					<c:out value="${book}" />
				</option>
			</c:forEach>
	</select>
<br /><br />


<label for="time">4th: 11:30 - 12:20</label>
&nbsp;&nbsp;

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="student">Student</label>
		<select name="user_4" id="user_4">
			<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${user_4 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Teacher</label>
		<select name="user_4" id="user_4">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${user_4 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
</c:choose>

<label for="book">Book</label>
	<select name="book_4" id="book_4">
		<option value="">--Choose Book--</option>
			<c:forEach var="book" items="${books_04}">
				<option value="${book}"<c:if test="${book_4 == book}">selected</c:if>>
					<c:out value="${book}" />
				</option>
			</c:forEach>
	</select>
<br /><br />


<label for="time">5th: 13:30 - 14:20</label>
&nbsp;&nbsp;

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="student">Student</label>
		<select name="user_5" id="user_5">
			<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${user_5 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Teacher</label>
		<select name="user_5" id="user_5">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${user_5 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
</c:choose>

<label for="book">Book</label>
	<select name="book_5" id="book_5">
		<option value="">--Choose Book--</option>
			<c:forEach var="book" items="${books_05}">
				<option value="${book}"<c:if test="${book_5 == book}">selected</c:if>>
					<c:out value="${book}" />
				</option>
			</c:forEach>
	</select>
<br /><br />


<label for="time">6th: 14:30 - 15:20</label>
&nbsp;&nbsp;

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="student">Student</label>
		<select name="user_6" id="user_6">
			<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${user_6 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Teacher</label>
		<select name="user_6" id="user_6">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${user_6 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
</c:choose>

<label for="book">Book</label>
	<select name="book_6" id="book_6">
		<option value="">--Choose Book--</option>
			<c:forEach var="book" items="${books_06}">
				<option value="${book}"<c:if test="${book_6 == book}">selected</c:if>>
					<c:out value="${book}" />
				</option>
			</c:forEach>
	</select>
<br /><br />


<label for="time">7th: 15:30 - 16:20</label>
&nbsp;&nbsp;

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="student">Student</label>
		<select name="user_7" id="user_7">
			<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${user_7 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Teacher</label>
		<select name="user_7" id="user_7">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${user_7 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
</c:choose>

<label for="book">Book</label>
	<select name="book_7" id="book_7">
		<option value="">--Choose Book--</option>
			<c:forEach var="book" items="${books_07}">
				<option value="${book}"<c:if test="${book_7 == book}">selected</c:if>>
					<c:out value="${book}" />
				</option>
			</c:forEach>
	</select>
<br /><br />


<label for="time">8th: 16:30 - 17:20</label>
&nbsp;&nbsp;

<c:choose>
	<c:when test="${main == 'teacher'}">
		<label for="student">Student</label>
		<select name="user_8" id="user_8">
			<option value="">--Choose Student--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 0}"><option value="${user.name}"<c:if test="${user_8 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
	<c:when test="${main == 'student'}">
		<label for="student">Teacher</label>
		<select name="user_8" id="user_8">
			<option value="">--Choose Teacher--</option>
			<c:forEach var="user" items="${users}">
				<c:if test="${user.admin_flag == 1}"><option value="${user.name}"<c:if test="${user_8 == user.name}">selected</c:if>>
					<c:out value="${user.name}" />
				</option></c:if>
			</c:forEach>
		</select>
		&nbsp;&nbsp;
	</c:when>
</c:choose>

<label for="book">Book</label>
	<select name="book_8" id="book_8">
		<option value="">--Choose Book--</option>
			<c:forEach var="book" items="${books_08}">
				<option value="${book}"<c:if test="${book_8 == book}">selected</c:if>>
					<c:out value="${book}" />
				</option>
			</c:forEach>
	</select>
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button type="submit" id="submit">Submit</button>



