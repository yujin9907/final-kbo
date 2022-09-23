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
            url: "/expulsion/"+id,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(res){
            console.log(res.data.player);
            $("#team_list").empty();
            renderTeamList(res.data.player);
        }).fail(function(error){
            console.log(error);
            alert("실패");
        });
    }

    function renderTeamList(teams){
        for(let team of teams){
            // $("#team_list").append(makeTeamItem(team));
            console.log(team);
        }
    }
    function makeTeamItem(team){
        <%--let item = `<tr>`;--%>
        <%--item += `<td>${team.teamName}</td>`;--%>
        <%--item += `<td>${team.position}</td>`;--%>
        <%--item += `<td>${team.name}</td>`;--%>
        <%--item += `<td></td>`;--%>
        <%--item += `<td></td>`;--%>
        <%--item += `</tr>`;--%>
        <%--return item;--%>
    }


</script>
<%@ include file="../layout/footer.jsp" %>





