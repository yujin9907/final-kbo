<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Blog</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    <!-- 폰트 어썸 -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/boards">FINAL-KBO</a>
        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/stadium">경기장 목록</a></li>
                <li class="nav-item"><a class="nav-link" href="/stadium/insertForm">경기장 등록</a></li>

                <li class="nav-item"><a class="nav-link" href="/team">팀 목록</a></li>
                <li class="nav-item"><a class="nav-link" href=/teamInsertForm>팀 등록</a></li>

                <li class="nav-item"><a class="nav-link" href="/player">선수 목록</a></li>
                <li class="nav-item"><a class="nav-link" href="/playerInserform">선수 등록</a></li>

                <li class="nav-item"><a class="nav-link" href="/position">팀 별 포지션 목록</a></li>
                <li class="nav-item"><a class="nav-link" href="/explusion/1">퇴출 선수 목록</a></li>
                <li class="nav-item"><a class="nav-link" href="/explusionForm">퇴출 사유 등록</a></li>
            </ul>
        </div>
    </div>
</nav>