<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">π³βπν λͺ©λ‘ νμ΄μ§μλλ€.</h3>
<div class="container">
<br />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>λ²νΈ</th>
				<th>ν</th>
				<th>κ²½κΈ°μ₯</th>
				<th>μ°½λ¨μΌ</th>
				<th>μ­μ </th>
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
					<button onclick="deleteById(${teams.id});" type="button" class="btn btn-danger btn-sm">μ­μ </button></td>
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
				alert("ν μ­μ  μ±κ³΅");
				location.reload();
			}else{
				alert("ν μ­μ  μ€ν¨");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>