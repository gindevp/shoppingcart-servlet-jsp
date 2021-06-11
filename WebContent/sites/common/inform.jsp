<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${not empty message }">
	<div class="alert alert-success col">${message }</div>
</c:if>
<c:if test="${not empty error }">
	<div class="alert alert-danger col">${error }</div>
</c:if>