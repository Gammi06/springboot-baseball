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
					<select class="form-select">
						<c:forEach var="expulsions" items="${expulsions}">
							<option>${expulsions.playersName}</option>
						</c:forEach>
					</select>
				</th>
				<th>퇴출 사유</th>
				<th>
					<select class="form-select">
						<c:forEach var="reasons" items="${reasons}">
							<option>${reasons.reasons}</option>
						</c:forEach>
					</select>
				</th>
				<th>
					<button type="button" class="btn btn-primary btn-sm">수정하기</button>
				</th>
			</tr>
		</thead>
	</table>
</div>

<script>
</script>

<%@ include file="../layout/footer.jsp"%>