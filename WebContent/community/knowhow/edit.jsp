<%@page import="com.petharu.web.entity.KnowhowView"%>
<%@page import="com.petharu.web.service.JDBCKnowhowService"%>
<%@page import="com.petharu.web.service.KnowhowService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="edit.css" type="text/css" rel="stylesheet">
    <script src="edit.js"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
</head>
<body>
    <div id="root">
        <header id="header">
            <div class="float-content">
                <div class="flex align-center">
                    <a href="" class="logo-title-container">
                        <img src="../../images/logo.png">
                    </a>
                    <nav class="main-menu">   
                            <h1 class="d-none">메인메뉴</h1>
                            <ul>
                                <li><a href="../../myhome/list.html">우리집</a></li>
                                <li><a href="../../friends/list">이웃집</a></li>
                                <li><a href="../../pet-management/mypet/list">내 동물 관리</a></li>
                                <li><a href="../notice/list.html">커뮤니티</a></li>
                            </ul>
                    </nav>
                </div>
                <nav class="member-menu">
                    <h1 class="d-none">회원메뉴</h1>
                    <ul>
                        <li><a href="../../member/profile-edit.html">MyPage</a></li>
                        <li><a href="../../../login">LogOut</a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <div id="body">
            <div class="float-content">
                <aside id="aside">
                    <nav class="aside-menu">
                        <h1 class="d-none">커뮤니티 메뉴</h1>
                        <ul>
                            <li><a href="../notice/list.html">공지사항</a></li>
                            <li><a class="current-page" href="list">노하우</a></li>
                        </ul>
                    </nav>
                </aside>
                <main id="main">
                    <h1 class="title">PetHaru 노하우</h1>
                    <section>
                    	<form action="edit" method="post" enctype="multipart/form-data">
	                        <section>
	                            <h1 class="sub-title">반려동물 선택</h1>
	                            <span class="required">*</span>
	                            <section class="pet-selecting-btn">
	                       			<input type="hidden" name="pet" value="${knowhow.knowhowTypeName == '강아지' ? '강아지' : '고양이'}">
 									<span class="${knowhow.knowhowTypeName == '강아지' ? 'select' : ''} center font">강아지</span>
	                                <span class="${knowhow.knowhowTypeName == '고양이' ? 'select' : ''} center font">고양이</span>
	                            </section>
	                        </section>
	                        <section class="title-area">
	                            <h1 class="sub-title">제목</h1>
	                            <span class="required">*</span>
	                            <input class="input underline font" type="text" name="title" value="${knowhow.title}">
	                        </section>
	                        <section class="write-content">
	                            <h1 class="sub-title">글 작성</h1>
	                            <span class="required">*</span>
	                            <div class="img-upload-box">
		                            <div class="img-upload-btn btn-sel center font">이미지 업로드</div>
		                            <input class="btn-file d-none" name="f" type="file">
	                            </div>
	                            <textarea class="input font" name="content">${knowhow.content}</textarea>
	                        </section>
	                        <hr class="line">
	                        <section class="button-menu">
	                            <h1 class="d-none">버튼</h1>
	                            <a class="btn center font" href="list">취소하기</a>
	                            <input type="hidden" name="id" value="${knowhow.id}">
	                            <button class="btn font">저장하기</button>
	                        </section>
                        </form>
                    </section>
                </main>
            </div>
        </div>

        <footer id="footer"></footer>
    </div>        
</body>
</html>