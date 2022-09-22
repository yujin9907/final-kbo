<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container mt-3">
    <h2>퇴출 선수 목록</h2>
    <div class="container">
        <button id="btnDusan" value="1">두산</button>
        <button id="btnNc" value="2">NC</button>
        <button id="btnLotte" value="3">롯데</button>
    </div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>번호</th>
            <th>팀 이름</th>
            <th>포지션</th>
            <th>선수 이름</th>
            <th>사유</th>
            <th>퇴출일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="player" items="${player}">
            <tr>
                <td>${player.id}</td>
                <td>${player.teamName}</td>
                <td>${player.position}</td>
                <td>${player.name}</td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    $("#btnDusan").click(()=>{
        let teamId=$("#btnDusan").val();
        teamList(teamId);
    });

    $("#btnNc").click(()=>{
        let teamId=$("#btnNc").val();
        teamList(teamId);
    });

    $("#btnLotte").click(()=>{
        let teamId=$("#btnLotte").val();
        teamList(teamId);
    });

    function teamList(teamId){
        $.ajax("/explusion/"+teamId, {
            type: "GET",
            dataType: "json",
        }).done((res) => {
            if (res.code == 1) {
                location.reload();
                // $("#lovecount").load(location.href + ' #lovecount');
            } else {
                alert("실패");
            }
        });
    }

</script>
<%@ include file="../layout/footer.jsp" %>





