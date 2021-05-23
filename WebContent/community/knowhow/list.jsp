<%@page import="com.petharu.web.service.JDBCKnowhowService"%>
<%@page import="com.petharu.web.entity.Knowhow"%>
<%@page import="java.util.List"%>
<%@page import="com.petharu.web.service.KnowhowService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String p = request.getParameter("p");
	String p_ = request.getParameter("p_");
	
/* 	System.out.println(p);
	System.out.println(p_); */
	
	// 변수 초기화
	int page_ = 1;
	String pet = "";
	
	// 사용자가 입력한 값으로 대치
	if (p != null && !p.equals("")) {
		page_ = Integer.parseInt(p);
	}			
	if (p_ != null && !p_.equals("")) {
		pet = p_;
	}

	KnowhowService knowhowService = new JDBCKnowhowService();
	List<Knowhow> list = knowhowService.getList(page_, pet);
%>

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
                                <li><a href="../../friends/list.html">이웃집</a></li>
                                <li><a href="../../pet-management/mypet/list.html">내 동물 관리</a></li>
                                <li><a href="../notice/list.html">커뮤니티</a></li>
                            </ul>
                    </nav>
                </div>
                <nav class="member-menu">
                    <h1 class="d-none">회원메뉴</h1>
                    <ul>
                        <li><a href="../../member/profile-edit.html">MyPage</a></li>
                        <li><a href="../../../login.html">LogOut</a></li>
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
                            <li><a class="current-page" href="list.jsp">노하우</a></li>
                        </ul>
                    </nav>
                </aside>
                <main id="main">
                    <section>
                        <section class="pet-selecting-btn">
                        	<h1 class="d-none">반려동물 선택</h1>   
                        	<%             
                        		String dogBg = "";
                    			String dogT = "";
                    			String catBg = "";
                    			String catT = "";
                    			
                    			if(pet != null && !pet.equals("")) {
                    				
	                           		if(pet.equals("강아지")) {
	                           			System.out.println("dog");
	                           			dogBg = "select-bg";
	                        			dogT = "select-t";	                           			
	                           		}
	                           		
	                           		if(pet.equals("고양이")) {
	                           			System.out.println("cat");
	                           			catBg = "select-bg";
	                    				catT = "select-t";			                           			
	                           		}
                    			}
                        	
                           	%>                                             	
                            <a class="<%=dogBg%>" href="list.jsp?p=<%=page_ %>&p_='강아지'"><span class="<%=dogT%> pet-btn-text center font">강아지</span></a>
	                        <a class="<%=catBg%>" href="list.jsp?p=<%=page_ %>&p_='고양이'"><span class="<%=catT%> pet-btn-text center font">고양이</span></a>
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
                            <a href="reg.jsp"><button class="font">노하우 등록하기</button></a>
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
                        <% for(Knowhow k : list) { %>
	                        <div>
	                            <div class="img-area">
	                                <a href="detail.jsp?id=<%=k.getId()%>">
	                                <img class="img-pet" src="../../images/cat-rest1.jpg">
	                                </a>
	                            </div>
	                            <div class="text-area">
	                            	<div class="knowhow-info">
	                            		<ul>
	                            			<li>
	                            				<img src="../../images/view.png">
	                            				<span><%=k.getHit()%></span>
	                            			</li>
	                            			<li>
	                            				<img src="../../images/heart.png">
	                            				<span>3</span>
	                            			</li>
	                            			<li>
	                            				<img src="../../images/comment.png">
	                            				<span>2</span>
	                            			</li>
	                            		</ul>
	                            	</div>
	                                <div class="knowhow-title"><a href="detail.jsp?id=<%=k.getId()%>"><%=k.getTitle()%></a></div>
	                                <section class="flex">
	                                    <div class="img-member"></div>
	                                    <span class="id"><%=k.getMemberId()%></span>
	                                </section>
	                            </div>
	                        </div>	
	                	<% } %>
                    </div>
                    <nav class="pager">
                        <h1 class="d-none">현재 페이지 정보</h1>
                        <a href=""><img class="prev" src="../../images/left-arrow.png" alt=""></a>
                        <ul>
                        	<%for(int i=0; i<5; i++) {%> 
                                	<li><a class="<%=page_ == i+1 ? "text-strong" : "" %>" href="list.jsp?p=<%=i+1 %>&p_=<%=pet %>"><%=i+1 %></a></li> <!--이렇게 해서 사용자가 검색한 결과 내에서 paging 할 수 있게 하기-->
                           	<%} %>
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