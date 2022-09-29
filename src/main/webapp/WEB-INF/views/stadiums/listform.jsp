<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">⚾경기장 목록 페이지입니다.</h3>
<div class="container">
<br/>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>개장일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stadiums" items="${stadiums}">
				<tr>
					<td>${stadiums.no}</td>
					<td>${stadiums.stadiumsName}</td>
					<td><fmt:formatDate value="${stadiums.createdAt}"
							pattern="yyyy-MM-dd" /></td>
					<td><input id="id" type="hidden" value="${stadiums.no}" />
					<button onclick="deleteById(${stadiums.id});" class="btn btn-danger btn-sm">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	function deleteById(id){
		$.ajax("/stadiums/" + id, {
			type: "DELETE",
			dataType: "json"
		}).done((res)=>{
			if(res.code == 1){
				alert("경기장 삭제 성공");
				location.reload();
			}else{
				alert("경기장 삭제 실패");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>