<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">📝팀 등록 페이지입니다.</h3>
<br />
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>경기장 이름:</th>
				<th><select id="stadiumId"  class="form-select">
						<c:forEach var="stadiums" items="${stadiums}">
							<option value="${stadiums.id}">${stadiums.stadiumsName}</option>
						</c:forEach>
				</select></th>
				<th>팀 이름:</th>
				<th><input id="teamsName" type="text" class="form-control" placeholder="Enter teamsName"></th>
				<th>
					<button id="btnInsert" type="button" class="btn btn-primary btn-sm">등록</button>
				</th>
			</tr>
		</thead>
	</table>
</div>

<script>
	$("#btnInsert").click(()=>{
		insertTeam();
	});
	
	function insertTeam(){
		let data = {
				stadiumsId: $("#stadiumId").val(),
				teamsName: $("#teamsName").val()
		}
		
		$.ajax("/teams",{
			type: "POST",
			dataType: "json",
			data: JSON.stringify(data), // http body에 들고갈 요청 데이터
			headers: { // http header에 들고갈 요청 데이터
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res)=>{
			if(res.code == 1){
				location.href="/teams";
			} else {
				alert("팀 등록에 실패하였습니다.");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>