<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br/>
<h3 style="text-align: center">๐ํด์ถ์ ์ ์ฌ์ ๋ฑ๋ก ํ์ด์ง์๋๋ค.</h3>
<br/>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>์ ์ ์ด๋ฆ</th>
				<th>
					<select id="id" class="form-select">
						<c:forEach var="expulsions" items="${expulsions}">
							<option value="${expulsions.id}">${expulsions.teamsName}-${expulsions.positions}/${expulsions.playersName}</option>
						</c:forEach>
					</select>
				</th>
				<th>ํด์ถ ์ฌ์ </th>
				<th>
					<select id="reasonsId" class="form-select">
						<c:forEach var="reasons" items="${reasons}">
							<option value="${reasons.id}">${reasons.reasons}</option>
						</c:forEach>
					</select>
				</th>
				<th>
					<button id="btnUpdate" type="button" class="btn btn-primary btn-sm">์์ ํ๊ธฐ</button>
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
			data: JSON.stringify(data), // http body์ ๋ค๊ณ ๊ฐ ์์ฒญ ๋ฐ์ดํฐ
			headers: { // http header์ ๋ค๊ณ ๊ฐ ์์ฒญ ๋ฐ์ดํฐ
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res)=>{
			if(res.code == 1){
				alert("ํด์ถ ์ฌ์  ์์  ์ฑ๊ณต");
				location.href="/expulsions";
			}else{
				alert("ํด์ถ ์ฌ์  ์์  ์คํจ");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>