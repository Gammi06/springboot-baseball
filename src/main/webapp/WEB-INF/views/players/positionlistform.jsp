<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<h3 style="text-align: center">đââī¸íŦė§ėëŗ íë´ ė ė ëĒŠëĄ íė´ė§ėëë¤.</h3>
<br />
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>íŦė§ė</th>
				<th>í ė´ëĻ</th>
				<th>íŦė§ė</th>
				<th>ė ė ė´ëĻ</th>
				<th>ė°Ŋë¨ėŧ</th>
				<th>ė­ė </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="players" items="${players}">
				<tr>
					<td>${players.no}</td>
					<td>${players.teamsName}</td>
					<td>${players.positions}</td>
					<td>${players.playersName}</td>
					<td><fmt:formatDate value="${players.createdAt}"
							pattern="yyyy-MM-dd" /></td>
					<td><input class="form-check-input" type="checkbox"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../layout/footer.jsp"%>