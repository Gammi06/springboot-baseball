<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">🏃‍♀️선수 목록 페이지입니다.</h3>
<br />
<div class="container">
	<div class="col text-right">
		<button type="button" class="btn btn-danger btn-sm">삭제</button>
	</div>
	<br />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀 이름</th>
				<th>포지션</th>
				<th>선수 이름</th>
				<th>창단일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="players" items="${players}">
				<tr>
					<td>${players.no}</td>
					<td>${players.teamsName}</td>
					<td>${players.positions}</td>
					<td>${players.playersName}</td>
					<td><fmt:formatDate value="${players.createdAt}"
							pattern="yyyy-MM-dd" /></td>
					<td><input class="form-check-input" type="checkbox"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../layout/footer.jsp"%>