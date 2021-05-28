<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="reg.css" type="text/css" rel="stylesheet">
    <script src="reg.js"></script>
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
                    	<form action="reg" method="post" enctype="multipart/form-data">
	                        <section>
	                            <h1 class="sub-title">반려동물 선택</h1>
	                            <span class="required">*</span>
	                            <section class="pet-selecting-btn">
	                          		<input type="hidden" name="pet" value="강아지">
	                                <span class="select center font">강아지</span>
	                                <span class="center font">고양이</span>
	                            </section>
	                        </section>
	                        <section class="title-area">
	                            <h1 class="sub-title">제목</h1>
	                            <span class="required">*</span>
	                            <input class="input underline font" type="text" name="title" placeholder="제목을 입력해주세요">
	                        </section>
	                        <section class="write-content">
	                            <h1 class="sub-title">글 작성</h1>
	                            <span class="required">*</span>
	                            <div class="img-upload-box">
						            <div class="upload-btn btn-sel center font">이미지 업로드</div> <!--.btn-file의 이벤트를 .btn-sel로 견인하는 방식(트리거)으로 사용-->
						            <input class="btn-file d-none" name="f" type="file"> <!--사용자가 파일에 직접 접근할 수 있게 해야 함-->
						        </div>
	                            <textarea class="input font" name="content" placeholder="내용을 입력해주세요"></textarea>
	                        </section>
	                        <hr class="line">
	                        <section class="button-menu">
	                            <h1 class="d-none">버튼</h1>
	                            <a class="btn center font" href="list">취소하기</a>
	                            <button class="btn font">등록하기</button>
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