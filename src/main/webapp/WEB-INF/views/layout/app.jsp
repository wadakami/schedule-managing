<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>Schedule Manager</title>
        <link rel="stylesheet" href="<c:url value='/css/b_reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/b_style.css' />">
		<script type="text/javascript" src="<c:url value='/js/jquery-3.3.1.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery.json-2.4.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/ajax.js' />" charset="utf-8"></script>
    </head>
    <body>
		<div id="wrapper">
			<div id="header">
				<div id="header_menu">
					<h1><a href="<c:url value="/top" />">Schedule Manager</a></h1>&nbsp;&nbsp;&nbsp;
					<c:if test="${sessionScope.login_user != null}">
						<c:if test="${sessionScope.login_user.admin_flag == 2}">
							<a href="<c:url value='/users/index' />">ManageUsers</a>&nbsp;
							<a href="<c:url value='/schedule/index?id=${sessionScope.login_user.admin_flag}' />">ManageSchedule</a>&nbsp;
						</c:if>
						<c:if test="${sessionScope.login_user.admin_flag != 2}">
							<a href="<c:url value='/schedule/index?id=${sessionScope.login_user.admin_flag}&name=${sessionScope.login_user.name}' />">ShowMySchedule</a>&nbsp;
						</c:if>
					</c:if>
				</div>
				<c:if test="${sessionScope.login_user != null}">
					<div id="user_name">
						User:&nbsp;<c:out value="${sessionScope.login_user.name}" />&nbsp;&nbsp;&nbsp;
						<a href="<c:url value='/logout' />">Logout</a>
					</div>
				</c:if>
			</div>
			<div id="content">
				${param.content}
			</div>
			<div id="footer">
				by PALETTE,Inc
			</div>
		</div>
    </body>
</html>