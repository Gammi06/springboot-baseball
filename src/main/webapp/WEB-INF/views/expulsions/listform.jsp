<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br/>
<h3 style="text-align: center">π₯ν΄μΆμ μ λͺ©λ‘ νμ΄μ§μλλ€.</h3>
<br/>
<div class="container">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>λ²νΈ</th>
                <th>ν μ΄λ¦</th>
                <th>ν¬μ§μ</th>
                <th>μ μμ΄λ¦</th>
                <th>μ¬μ </th>
                <th>ν΄μΆμΌ</th>
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