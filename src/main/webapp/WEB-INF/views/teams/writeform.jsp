<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">๐ํ ๋ฑ๋ก ํ์ด์ง์๋๋ค.</h3>
<br />
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>๊ฒฝ๊ธฐ์ฅ ์ด๋ฆ:</th>
				<th><select id="stadiumId"  class="form-select">
						<c:forEach var="stadiums" items="${stadiums}">
							<option value="${stadiums.id}">${stadiums.stadiumsName}</option>
						</c:forEach>
				</select></th>
				<th>ํ ์ด๋ฆ:</th>
				<th><input id="teamsName" type="text" class="form-control" placeholder="Enter teamsName"></th>
				<th>
					<button id="btnInsert" type="button" class="btn btn-primary btn-sm">๋ฑ๋ก</button>
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
			data: JSON.stringify(data), // http body์ ๋ค๊ณ ๊ฐ ์์ฒญ ๋ฐ์ดํฐ
			headers: { // http header์ ๋ค๊ณ ๊ฐ ์์ฒญ ๋ฐ์ดํฐ
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res)=>{
			if(res.code == 1){
				location.href="/teams";
			} else {
				alert("ํ ๋ฑ๋ก์ ์คํจํ์์ต๋๋ค.");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>