<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">🏳‍🌈팀 목록 페이지입니다.</h3>
<div class="container">
	<div class="col text-right">
		<button type="button" class="btn btn-danger btn-sm">삭제</button>
	</div>
	<br />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀</th>
				<th>경기장</th>
				<th>창단일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="teams" items="${teams}">
				<tr>
					<td>${teams.no}</td>
					<td>${teams.teamsName}</td>
					<td>${teams.stadiumsName}</td>
					<td><fmt:formatDate value="${teams.createdAt}"
							pattern="yyyy-MM-dd" /></td>
					<td><input class="form-check-input" type="checkbox"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../layout/footer.jsp"%>