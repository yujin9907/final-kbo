<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <h1>퇴출 선수 등록</h1>
    <form>
        <select id="id">
            <c:forEach var="player" items="${player}">
                <option value="${player.id}">${player.name}</option>
            </c:forEach>
        </select>
        퇴출사유
        <input id="reason" type="text" placeholder="Enter reason">
        <button id="btnInsert">등록</button>
    </form>
    <h1>목록</h1>
    <c:forEach var="reason" items="${reasons}">
    <ul>
        <li>플레이어 아이디 : ${reason.playerId}</li>
        <li>퇴출 이유 : ${reason.reason}</li>
    </ul>
    </c:forEach>
</div>

<script>
    $("#btnInsert").click(()=>{
        insert();
    });

    function insert(){
        let data = {
            id: $("#id").val(),
            reason : $("#reason").val()
        };

        $.ajax("/exclusion", {
            type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        }).done((res) => {
            if (res.code == 1) {
                location.href = "/";
            }
        });
    }
</script>

<%@ include file="../layout/footer.jsp" %>