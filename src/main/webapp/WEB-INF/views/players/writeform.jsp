<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">📝선수 등록 페이지입니다.</h3>
<br />
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th><select id="teamsId" class="form-select">
						<c:forEach var="teams" items="${teams}">
							<option value="${teams.id}">${teams.teamsName}</option>
						</c:forEach>
				</select></th>
				<th><select id="positionsId" class="form-select">
						<c:forEach var="positions" items="${positions}">
							<option value="${positions.id}">${positions.positions}</option>
						</c:forEach>
				</select></th>
				<th>팀 이름:</th>
				<th><input id="playersName" type="text" class="form-control" placeholder="Enter playersName"></th>
				<th>
					<button id="btnInsert" type="button" class="btn btn-primary btn-sm">등록</button>
				</th>
			</tr>
		</thead>
	</table>
</div>

<script>
	$("#btnInsert").click(()=>{
		insertPlayer();
	});
	
	function insertPlayer(){
		let data = {
				playersName: $("#playersName").val(),
				teamsId: $("#teamsId").val(),
				positionsId: $("#positionsId").val()
		}
		
		$.ajax("/players",{
			type: "POST",
			dataType: "json",
			data: JSON.stringify(data), // http body에 들고갈 요청 데이터
			headers: { // http header에 들고갈 요청 데이터
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res)=>{
			if(res.code == 1){
				location.href="/players";
			} else {
				alert("선수 등록에 실패하였습니다.");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>