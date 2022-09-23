<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form>
        <input id="id" type="hidden" value="${stadium.id}">
        <div class="mb-3 mt-3">
            <input id="name" type="text" class="form-control" placeholder="edit stadium name" value="${stadium.name}">
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
            name: $("#name").val()
        };
        let id = $("#id").val();

        $.ajax("/stadium/update/" + id, {
            type: "put",
            dataType: "json",
            data: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            }
        }).done((res) => {
            if (res.code == 1) {
                location.href="/stadium";
            } else {
                alert("업데이트 실패");
            }
        });
    }
</script>
<%@ include file="../layout/footer.jsp" %>





