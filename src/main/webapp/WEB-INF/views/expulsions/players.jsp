<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<h2>퇴출선수 목록 페이지 입니다.</h2>
<br>
<div class="d-flex">
<button type="button" class="btn btn-light">팀이름</button>
</div>

<table class="table table-striped">
	<thead>
		<tr>
			<th>번호</th>
			<th>팀 이름</th>
			<th>포지션</th>
			<th>선수이름</th>
			<th>사유</th>
			<th>퇴출일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="expulsions" items="${expulsions}">
			<tr>
				<td>${expulsions.id}</td>
				<td>${expulsions.playersName}</td>
				<td>${expulsions.teamsName}</td>
				<td>${expulsions.positions}</td>
				<td>${expulsions.reasons}</td>
				<td>${expulsions.createdAt}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	
</script>

<%@ include file="../layout/footer.jsp"%>