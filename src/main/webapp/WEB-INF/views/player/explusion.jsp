<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>
<div class="container mt-3">
    <h2>퇴출 선수 목록</h2>

        <div class="container">
            <c:forEach var="team" items="${team}">
            <button onclick="viewteam(${team.id})" value="">${team.name}</button>
            </c:forEach>
        </div>


    <table id="divReloadLayer" class="table table-bordered">
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
        <tbody id="team_list">


        </tbody>
    </table>
</div>

<script>
    function viewteam(id){
        $.ajax({
            type: "GET",
            url: "/explusion/"+id,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(res){
            $("#team_list").empty();
            $("#team_list").append(makeTeamItem(res.data));
        }).fail(function(error){
            console.log(error);
            alert("실패");
        });
    }

    function makeTeamItem(x){
        let item = `<tr>`;
        for(let data of x){
            item += `<td>`+data.id+`</td>`;
            item += `<td>`+data.teamName+`</td>`;
            item += `<td>`+data.position+`</td>`;
            item += `<td>`+data.name+`</td>`;
            item += `<td>`+data.reason+`</td>`;
            item += `<td>`+data.explusionCreateDate+`</td>`;
            item += `</tr>`;
        }
        return item;
    }


</script>
<%@ include file="../layout/footer.jsp" %>





