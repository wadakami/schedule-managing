<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
	<div id="flush_error">
		You have encountered some errors.<br />
		<c:forEach var="error" items="${errors}">
			・<c:out value="${error}" />
		</c:forEach>
	</div>
</c:if>
<label for="name">Name</label><br />
<input type="text" name="name" value="${user.name}" />
<br /><br />

<label for="password">Password</label><br />
<input type="password" name="password" />
<br /><br />

<label for="max">Maximum Classes</label><br />
<select name="max">
	<option value="1"<c:if test="${user.max == 1}"> selected</c:if>>1</option>
	<option value="2"<c:if test="${user.max == 2}"> selected</c:if>>2</option>
	<option value="3"<c:if test="${user.max == 3}"> selected</c:if>>3</option>
	<option value="4"<c:if test="${user.max == 4}"> selected</c:if>>4</option>
	<option value="5"<c:if test="${user.max == 5}"> selected</c:if>>5</option>
	<option value="6"<c:if test="${user.max == 6}"> selected</c:if>>6</option>
	<option value="7"<c:if test="${user.max == 7}"> selected</c:if>>7</option>
	<option value="8"<c:if test="${user.max == 8}"> selected</c:if>>8</option>
</select>
<br /><br />

<span style="background: ${user.color}">
<label for="color" id="color_number${user.color}">Color</label><br />
</span>
<input type="color" name="color" list="colorlist" />
<datalist id="colorlist">
	<option value="#00ffff"<c:if test="${user.color == '#00ffff'}"> selected</c:if>>0.aqua</option>
	<option value="#000000"<c:if test="${user.color == '#000000'}"> selected</c:if>>1.black</option>
	<option value="#0000ff"<c:if test="${user.color == '#0000ff'}"> selected</c:if>>2.blue</option>
	<option value="#ff00ff"<c:if test="${user.color == '#ff00ff'}"> selected</c:if>>3.fuchsia</option>
	<option value="#808080"<c:if test="${user.color == '#808080'}"> selected</c:if>>4.gray</option>
	<option value="#008000"<c:if test="${user.color == '#008000'}"> selected</c:if>>5.green</option>
	<option value="#00ff00"<c:if test="${user.color == '#00ff00'}"> selected</c:if>>6.lime</option>
	<option value="#800000"<c:if test="${user.color == '#800000'}"> selected</c:if>>7.maroon</option>
	<option value="#000080"<c:if test="${user.color == '#000080'}"> selected</c:if>>8.navy</option>
	<option value="#808000"<c:if test="${user.color == '#808000'}"> selected</c:if>>9.olive</option>
	<option value="#800080"<c:if test="${user.color == '#800080'}"> selected</c:if>>10.purple</option>
	<option value="#ff0000"<c:if test="${user.color == '#ff0000'}"> selected</c:if>>11.red</option>
	<option value="#c0c0c0"<c:if test="${user.color == '#c0c0c0'}"> selected</c:if>>12.silver</option>
	<option value="#008080"<c:if test="${user.color == '#008080'}"> selected</c:if>>13.teal</option>
	<option value="#ffffff"<c:if test="${user.color == '#ffffff'}"> selected</c:if>>14.white</option>
	<option value="#ffff00"<c:if test="${user.color == '#ffff00'}"> selected</c:if>>15.yellow</option>
</datalist>
<br /><br />


<label for="books">Available Books</label><br />
	Choose your book:&nbsp;
	<br />
	<c:forEach var="book" items="${books}">
		<input type="checkbox" name="book" value="${book}" checked><c:out value="${book}" />,&nbsp;&nbsp;
	</c:forEach><br />

	<c:forEach var="abook" items="${allbooks}">
		<input type="checkbox" name="book" value="${abook}"><c:out value="${abook}" />&nbsp;&nbsp;
	</c:forEach>

<br /><br />


<label for="admin_flag">Privilege</label><br />
<select name="admin_flag">
	<option value="0"<c:if test="${user.admin_flag == 0}"> selected</c:if>>Student</option>
	<option value="1"<c:if test="${user.admin_flag == 1}"> selected</c:if>>Teacher</option>
	<option value="2"<c:if test="${user.admin_flag == 2}"> selected</c:if>>Administrator</option>
</select>
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">Submit</button>