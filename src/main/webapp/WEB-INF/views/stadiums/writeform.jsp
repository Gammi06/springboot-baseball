<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">📝경기장 등록 페이지입니다.</h3>
<br />
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>경기장 이름:</th>
				<th><input id="stadiumsName" type="text" class="form-control" placeholder="Enter stadiumsName"></th>
				<th><button id="btnInsert" type="button" class="btn btn-primary btn-sm">등록</button></th>
			</tr>
		</thead>
	</table>
</div>

<script>
	$("#btnInsert").click(()=>{
		insertStadium();
	});
	
	function insertStadium(){
		let data = {
				stadiumsName: $("#stadiumsName").val()
		}
		
		$.ajax("/stadiums",{
			type: "POST",
			dataType: "json",
			data: JSON.stringify(data), // http body에 들고갈 요청 데이터
			headers: { // http header에 들고갈 요청 데이터
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res)=>{
			if(res.code == 1){
				location.href="/stadiums";
			} else {
				alert("경기장 등록에 실패하였습니다.");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>