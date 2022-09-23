<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form>
        <input id="id" type="hidden" value="${team.id}">
        <select id="stadium">
            <c:forEach var="stadium" items="${stadium}">
                <option value="${stadium.id}">${stadium.name}</option>
            </c:forEach>
            <option></option>
        </select>
        <div class="mb-3 mt-3">
            <input id="name" type="text" class="form-control" placeholder="edit team name" value="${team.name}">
        </div>
        <button id="btnUpdate" type="button" class="btn btn-primary">수정완료</button>
    </form>
</div>
<script>

    $("#btnUpdate").click(()=>{
        update();
    });

    function update(){
        let data = {
            stadiumId : $("#stadium").val(),
            name: $("#name").val()
        };
        let id = $("#id").val();

        $.ajax("/team/update/" + id, {
            type: "put",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        }).done((res) => {
            if (res.code == 1) {
                location.href="/team";
            } else {
                alert("업데이트 실패");
            }
        });
    }
</script>
<%@ include file="../layout/footer.jsp" %>





