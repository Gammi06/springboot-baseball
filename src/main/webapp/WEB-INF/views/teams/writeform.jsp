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
				<th><select class="form-select">
						<c:forEach var="stadiums" items="${stadiums}">
							<option>${stadiums.stadiumsName}</option>
						</c:forEach>
				</select></th>
				<th>팀 이름:</th>
				<th><input class="form-control"></th>
				<th>
					<button type="button" class="btn btn-primary btn-sm">등록</button>
				</th>
			</tr>
		</thead>
	</table>
</div>

<%@ include file="../layout/footer.jsp"%>