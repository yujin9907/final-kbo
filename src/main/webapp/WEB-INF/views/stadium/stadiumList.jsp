<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container mt-3">
    <h2>경기장 목록</h2>
    <p>경기장 목록 페이지입니다</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>개장일</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="stadium" items="${stadium}">
        <tr>
            <td>${stadium.id}</td>
            <td>${stadium.name}</td>
            <td>${stadium.createDate}</td>
            <td><i class="fa-solid fa-pen"></i></td>
            <td><i class="fa-solid fa-trash"></i></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="../layout/footer.jsp" %>

