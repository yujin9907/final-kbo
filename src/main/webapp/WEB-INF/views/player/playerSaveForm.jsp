<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <h1>선수 등록</h1>
    <form>
        <select id="team">
            <c:forEach var="player" items="${players}">
                <option value="${player.teamId}">${player.teamName}</option>
            </c:forEach>
        </select>
        <input id="name" type="text" placeholder="Enter name">
        <input id="position" type="text" placeholder="Enter position">
        <button id="btnInsert">등록</button>
    </form>
</div>

<script>
    $("#btnInsert").click(()=>{
        insert();
    });

    function insert(){
        let data = {
            name: $("#name").val(),
            teamId : $("#team").val(),
            position : $("#position").val()
        };

        console.log(data.position);
        console.log(data.name);
        $.ajax("/player", {
            type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        }).done((res) => {
            if (res.code == 1) {
                location.href = "/player";
            }
        });
    }
</script>

<%@ include file="../layout/footer.jsp" %>