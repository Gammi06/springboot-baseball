<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layouts/header.jsp"%>
<br/>
<h3 style="text-align: center">경기장 목록 페이지입니다.</h3>
<br/>
<div class="container">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>번호</th>
                <th>팀</th>
                <th>경기장</th>
                <th>창단일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="teams" items="${teamsList}">
                <tr>
                    <td>${teams.id}</td>
                    <td>${teams.teamsName}</td>
                    <td>${teams.stadiumsName}</td>
                    <td><fmt:formatDate value="${teams.createdAt}"
                            pattern="yyyy-MM-dd" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../layouts/footer.jsp"%>