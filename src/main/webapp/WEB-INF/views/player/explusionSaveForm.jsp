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
</div>

<script>
    $("#btnInsert").click(()=>{
        insert();
    });

    function insert(){
        let data = {
            playerId: $("#id").val(),
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