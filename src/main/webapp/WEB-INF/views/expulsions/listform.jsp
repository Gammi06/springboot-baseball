<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br/>
<h3 style="text-align: center">😥퇴출선수 목록 페이지입니다.</h3>
<br/>
<div class="container">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>번호</th>
                <th>팀 이름</th>
                <th>포지션</th>
                <th>선수이름</th>
                <th>사유</th>
                <th>퇴출일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="expulsions" items="${expulsions}">
                <tr>
                    <td>${expulsions.no}</td>
                    <td>${expulsions.teamsName}</td>
                    <td>${expulsions.positions}</td>
                    <td>${expulsions.playersName}</td>
                    <td>${expulsions.reasons}</td>
                    <td><fmt:formatDate value="${expulsions.createdAt}"
                            pattern="yyyy-MM-dd" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../layout/footer.jsp"%>