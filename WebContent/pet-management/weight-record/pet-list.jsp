<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="pet-list-style.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div id="root">
        <header id="header">
            <div class="float-content">
                <div class="flex align-center">
                    <a href="" class="logo-title-container">
                        <img src="../../images/logo.png" alt="">
                    </a>
                    <nav class="main-menu">   
                            <h1 class="d-none">메인메뉴</h1>
                            <ul>
                                <li><a href="../../myhome/list.html">우리집</a></li>
                                <li><a href="../../friends/list">이웃집</a></li>
                                <li><a href="../mypet/list">내 동물관리</a></li>
                                <li><a href="../../community/notice/list.html">커뮤니티</a></li>
                            </ul>
                    </nav>
                </div>
                <nav class="member-menu">
                    <h1 class="d-none">회원메뉴</h1>
                    <ul>
                        <li><a href="../../mypage/profile/profile-edit.html">MyPage</a></li>
                        <li><a href="../../login.html">LogOut</a></li>
                    </ul>
                </nav>
            </div>
        
            
        </header>

        <div id="body">
            <div class="float-content">
                <aside id="aside">
                    <nav class="aside-menu">
                        <h1 class="d-none">동물관리메뉴</h1>
                        <ul>
                            <li><a href="../mypet/list">동물 관리</a></li>
                            <li><a class="current-page" href="pet-list">체중 관리</a></li>
                            <li><a href="../schedule/calendar.html">일정 관리</a></li>                  
                        </ul>
                    </nav>
                </aside>
                <main id="main">
                    <div class="pet-list-box">
                        <div class="subject">
                            <h1>반려동물 선택</h1>
                        </div>
                        
	                       <div class="pet-list">
	                       <c:forEach var="n" items="${list}">
	                       		<div class="pet">
	                               <a href="table?petid=${n.id}"><img class="img" src="../../images/pet1.png"></a>
	                               ${n.name}
	                           	</div>
	                       </c:forEach>
	                       </div>
                       
                        
                    </div>

                </main>
            </div>
        </div>

        <!-- <footer id="footer">footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer</footer> -->


    </div>
    
</body>
</html>