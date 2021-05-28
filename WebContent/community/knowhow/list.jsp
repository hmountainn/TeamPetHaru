<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="list.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="list.js"></script>
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
                    <section>
                        <section class="pet-selecting-btn">
                        	<h1 class="d-none">반려동물 선택</h1>                                          	
                            <a class="${param.p_== (empty param.p) && '강아지'?'select-bg':''}" href="list?p=${param.p}&p_='강아지'"><span class="${param.p_== (empty param.p) && '강아지'?'select-t':''} pet-btn-text center font">강아지</span></a>
	                        <a class="${param.p_== (empty param.p) && '고양이'?'select-bg':''}" href="list?p=${param.p}&p_='고양이'"><span class="${param.p_== (empty param.p) && '강아지'?'select-t':''} pet-btn-text center font">고양이</span></a>
                        </section>
         <!--                <section class="category-btn">
                        	<select>
                        	    <option>카테고리 선택</option>
                        		<option>건강</option>
	                      		<option>교육/훈련</option>
	                      		<option>급여</option>
	                      		<option>생활</option>
	                      		<option>놀이</option>
	                      		<option>의료</option>
                        	</select>
                        </section> -->
                        <section class="knowhow-upload-btn">
                            <h1 class="d-none">노하우 게시글 등록</h1>
                            <a href="reg"><button class="font">노하우 등록하기</button></a>
                        </section>
                    </section>
                    <div class="knowhow-list">
                        <h1 class="d-none">노하우 게시글 목록</h1>
                        <!-- 
                        1. Knowhow 클래스 생성 
                        2. KnowhowService 인터페이스 생성 
                        	- 필요한 함수 목록 정의
                        3. KnowhowService 인터페이스를 JDBCKnowhowService에서 구현
                        	- DB와 연동시켜 데이터 가져오기 
                        4. list.jsp
                        	- JDBCKnowhowService를 통해 데이터를 얻어와 화면에 출력하는 로직 짜기
                        -->
                        
                        <c:forEach var="k" items="${list}">
                        	<div>
	                            <div class="img-area">
	                                <a href="detail?id=${k.id}">
	                                <img class="img-pet" src="../../images/cat-rest1.jpg">
	                                </a>
	                            </div>
	                            <div class="text-area">
	                            	<div class="knowhow-info">
	                            		<ul>
	                            			<li>
	                            				<img src="../../images/view.png">
	                            				<span>${k.hit}</span>
	                            			</li>
	                            			<li>
	                            				<img src="../../images/heart.png">
	                            				<span>${k.likeCount}</span>
	                            			</li>
	                            			<li>
	                            				<img src="../../images/comment.png">
	                            				<span>${k.commentCount }</span>
	                            			</li>
	                            		</ul>
	                            	</div>
	                                <div class="knowhow-title"><a href="detail?id=${k.id}">${k.title}</a></div>
	                                <section class="flex">
	                                    <img class="img-member" src="../../images/user.png">
	                                    <span class="id">${k.userId}</span>
	                                </section>
	                            </div>
	                        </div>	
                        </c:forEach>
                    </div>
                
                    <c:if test="${fn:length(list) == 0 }">
                    	<p class="non-page">존재하지 않는 페이지입니다</p>
                    </c:if>
                    
                    <nav class="pager">
                        <h1 class="d-none">현재 페이지 정보</h1>
                        <a href=""><img class="prev" src="../../images/left-arrow.png" alt=""></a>
                        <ul>
                        	<c:forEach var="i" begin="0" end="4" step="1">
                                	<li><a class="${((empty param.p) && i+1 == 1) || param.p == i+1 ? "text-strong" : ""}" href="list?p=${i+1 }&p_=${param.p_}">${i+1}</a></li> <!--이렇게 해서 사용자가 검색한 결과 내에서 paging 할 수 있게 하기-->                        	
                 			</c:forEach>
                        </ul>
                        <a href=""><img class="next" src="../../images/right-arrow.png" alt=""></a>
                    </nav>
                </main>
            </div>
        </div>

        <footer id="footer"></footer>
    </div>        
</body>
</html>