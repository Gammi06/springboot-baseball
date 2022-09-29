<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br/>
<h3 style="text-align: center">📝퇴출선수 사유등록 페이지입니다.</h3>
<br/>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>선수 이름</th>
				<th>
					<select id="id" class="form-select">
						<c:forEach var="expulsions" items="${expulsions}">
							<option value="${expulsions.id}">${expulsions.teamsName}-${expulsions.positions}/${expulsions.playersName}</option>
						</c:forEach>
					</select>
				</th>
				<th>퇴출 사유</th>
				<th>
					<select id="reasonsId" class="form-select">
						<c:forEach var="reasons" items="${reasons}">
							<option value="${reasons.id}">${reasons.reasons}</option>
						</c:forEach>
					</select>
				</th>
				<th>
					<button id="btnUpdate" type="button" class="btn btn-primary btn-sm">수정하기</button>
				</th>
			</tr>
		</thead>
	</table>
</div>

<script>
	$("#btnUpdate").click(()=>{
		updateExpulsions();
	});
	
	function test(){
		
	}
	
	function updateExpulsions(){
		let data = {
				reasonsId: $("#reasonsId").val()
		}
		let id = $("#id").val();
		
		$.ajax("/expulsions/update/" + id, {
			type: "PUT",
			dataType: "json",
			data: JSON.stringify(data), // http body에 들고갈 요청 데이터
			headers: { // http header에 들고갈 요청 데이터
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res)=>{
			if(res.code == 1){
				alert("퇴출 사유 수정을 성공했습니다.");
				location.href="/expulsions";
			}else{
				alert("퇴출 사유 수정을 실패하였습니다.");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>