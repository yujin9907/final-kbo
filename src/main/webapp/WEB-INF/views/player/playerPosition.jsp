<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container mt-3">
    <h2>선수 목록</h2>
    <p>선수 목록 페이지입니다</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>포지션</th>
            <th>두산</th>
            <th>NC</th>
            <th>롯데</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="position" items="${position}">
            <tr>
                <td>${position.position}</td>
                <td>${position.dusan}</td>
                <td>${position.NC}</td>
                <td>${position.lotte}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="../layout/footer.jsp" %>





