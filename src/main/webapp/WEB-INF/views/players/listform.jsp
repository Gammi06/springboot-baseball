<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">🏃‍♀️선수 목록 페이지입니다.</h3>
<br />
<div class="container">
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
					<td><input id="id" type="hidden" value="${players.no}" />
					<button onclick="deleteById(${players.id});" type="button" class="btn btn-danger btn-sm">삭제</button>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	function deleteById(id){
		$.ajax("/players/" + id, {
			type: "DELETE",
			dataType: "json"
		}).done((res)=>{
			if(res.code == 1){
				location.reload();
			}else{
				alert("선수 삭제에 실패하셨습니다.");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>