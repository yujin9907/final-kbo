<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <h1>팀 등록</h1>
    <form>
        <input id="name" type="text" placeholder="Enter stadium">
        <button id="btnInsert">등록</button>
    </form>
</div>

<script>
    $("#btnInsert").click(()=>{
        insert();
    });

    function insert() {
        let data = {
            name: $("#name").val()
        };

        $.ajax("/stadium", {
            type: "POST",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        }).done((res) => {
            if (res.code == 1) {
                alert("됨");
                location.href = "/stadium";
            } else {
                alert("실패");
            }
        });
    }
</script>

<%@ include file="../layout/footer.jsp" %>