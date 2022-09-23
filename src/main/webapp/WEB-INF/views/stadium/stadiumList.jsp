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
                <td><a href="/stadium/update/${stadium.id}"><i class="fa-solid fa-pen"></i></a></td>
                <td><i onclick="clickDelete(${stadium.id})" class="fa-solid fa-trash">
            </i></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>

    $("#update").css("cursor","pointer").click(() => {
        update();
    });

    $(".fa-trash").css("cursor","pointer");

    function clickDelete(id){
        let ans = confirm("삭제?");
        if (ans){
            deleteStadium(id);
        }
    }

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
                alert("성공");
                location.href="/stadium";
            } else {
                alert("업데이트 실패");
            }
        });
    }

    function deleteStadium(id){
        $.ajax("/stadium/delete/"+id, {
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

