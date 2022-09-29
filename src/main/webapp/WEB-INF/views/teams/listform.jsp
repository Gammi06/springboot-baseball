<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">🏳‍🌈팀 목록 페이지입니다.</h3>
<div class="container">
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
					<td><input id="id" type="hidden" value="${teams.no}" />
					<button onclick="deleteById(${teams.id});" type="button" class="btn btn-danger btn-sm">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	function deleteById(id){
		$.ajax("/teams/" + id, {
			type: "DELETE",
			dataType: "json"
		}).done((res)=>{
			if(res.code == 1){
				alert("팀 삭제 성공");
				location.reload();
			}else{
				alert("팀 삭제 실패");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>