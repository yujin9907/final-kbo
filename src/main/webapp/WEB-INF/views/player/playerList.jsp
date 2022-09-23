<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container mt-3">
    <h2>선수 목록</h2>
    <p>선수 목록 페이지입니다</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>번호</th>
            <th>팀 이름</th>
            <th>포지션</th>
            <th>선수 이름</th>
            <th>등록일</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="player" items="${players}">
            <tr>
                <td>${player.id}</td>
                <td>${player.teamName}</td>
                <td>${player.position}</td>
                <td>${player.name}</td>
                <td>${player.createDate}</td>
                <td><a href="/player/update/${player.id}"> <i class="fa-solid fa-pen"></i></a></td>
                <td><i class="fa-solid fa-trash" onclick="clickDelete(${player.id})"></i></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>

    $("#update").css("cursor","pointer").click(() => {
        // update();
    });

    $(".fa-trash").css("cursor","pointer");

    function clickDelete(id){
        let ans = confirm("삭제?");
        if (ans){
            deleteStadium(id);
        }
    }
    function deleteStadium(id){
        $.ajax("/player/delete/"+id, {
            type: "DELETE",
            dataType: "json",
        }).done((res) => {
            if (res.code == 1) {
                alert("삭제하였습니다");
                location.reload();
            } else {
                alert("삭제 실패");
            }
        });
    }
</script>
<%@ include file="../layout/footer.jsp" %>





