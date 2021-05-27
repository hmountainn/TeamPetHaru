<%@page import="com.petharu.web.entity.Schedule"%>
<%@page import="com.petharu.web.service.JDBCScheduleService"%>
<%@page import="com.petharu.web.service.ScheduleService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="calendar.css" type="text/css" rel="stylesheet">
    <script src="calendar.js"></script>
    <script src="add.js"></script>
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
                                <li><a>우리집</a></li>
                                <li><a>이웃집</a></li>
                                <li><a>내 동물관리</a></li>
                                <li><a>커뮤니티</a></li>
                            </ul>
                    </nav>
                </div>
                <nav class="member-menu">
                    <h1 class="d-none">회원메뉴</h1>
                    <ul>
                        <li><a href="">MyPage</a></li>
                        <li><a href="">LogOut</a></li>
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
                            <li><a href="../mypet/list.html">동물 관리</a></li>
                            <li><a href="../weight-record/form.html">체중 관리</a></li>
                            <li><a class="current-page" href="calendar.html">일정 관리</a></li>                       
                        </ul>
                    </nav>
                </aside>
                <main id="main">
                    <section id="content-wrap">
                        <table class="calendar">
                            <thead>
                                <tr class="btn-wrap">
                                  <td colspan="2">
                                    <label class="prev-month">
                                        &#60;
                                    </label>
                                  </td>
                                  <td class="current-year-month" colspan="3"> </td>
                                  <td>
                                    <label class="next-month">
                                        &#62;
                                    </label>
                                  </td>
                                  <td>
                                    <div>
                                        <input class="btn-add" type="button" value="일정 추가">
                                    </div>
                                  </td>
                                </tr>
                                <tr class="day-wrap">
                                    <td class = "sun">Sun</td>
                                    <td>Mon</td>
                                    <td>Tue</td>
                                    <td>Wed</td>
                                    <td>Thu</td>
                                    <td>Fri</td>
                                    <td class= "sat">Sat</td>
                                </tr>
                              </thead>
                        </table>
                        <div class="overlay"></div>
                        <div class="popup-wrapper">
                            <div class="add-schedule">
                                <a href="calendar.html" class="close-btn">
                                <img src="../../images/icon-close-btn.png" alt="">
                                    
                                </a>
                                <div class="add-schedule-form">
    
                                    <h1 class="d-none">일정추가</h1>                                   
                                    <form action="edit" method="post">
                                        <div class="schedule-input-container title-container">
                                            <label class="schedule-lable title-lable d-none" for="">제목</label>
                                            <input class="title-input" type="text" placeholder="제목" name="title" value="${schedule.title}">
                                        </div>
                                        <div class="schedule-input-container date-time-container">
                                            <label class="schedule-lable  date-time-lable btn" for="" >일시</label>
                                           
                                            <input type = "datetime-local" name = "datetime" value="${schedule.dateTime}">

                                        </div>
                                        <div class="schedule-input-container content-container">
                                            <label class="schedule-lable content-lable btn" for="">내용</label>
                                            <textarea class="content-input"cols="40" rows="7" placeholder="내용" name="content">${schedule.content}</textarea>
                                        </div>
                                        
                                        
                                        <div class="hashtag-container">
                                            
                                            <input class="hashtag hashtag1" id="hashtag1" type="radio" name="scheduleType" value="진료">
  											<label for="hashtag1">#진료</label>
  											<input class="hashtag hashtag2" id="hashtag2"type="radio" name="scheduleType" value="접종">
  											<label for="hashtag2">#예방접종</label>
  											<input class="hashtag hashtag3" id="hashtag3" type="radio" name="scheduleType" value="미용">
  											<label for="hashtag3">#미용</label>
  											<input class="hashtag hashtag4" id="hashtag4" type="radio" name="scheduleType" value="기타">
  											<label for="hashtag4">#기타</label>
                                             
                                        </div>
                                        <input type="hidden" name="id" value="${schedule.id}">
                                        
                                        <div class="submit">
    
                                            <input class="submit-btn" type="submit" value="등록">
                                        </div>
                                    </form>
                                </div>
                                
                            </div>
                        </div>
                        
                        
                        <div class="schedule-detail d-none">
                                    
                        </div>
                    </section>
                    
                </main>
            </div>
        </div>

        <footer id="footer">footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer</footer>


    </div>

     <script>
     	
        var today = new Date(); //오늘 날짜
        var year = today.getFullYear(); //올해
        var month = today.getMonth(); //이번달
        console.log(year);
        console.log(month);
        YM = year+"."+(month+1);
        var calendar = document.querySelector(".calendar");
        var currentYM = calendar.querySelector(".current-year-month");
        currentYM.innerHTML = YM;

        firstDate = new Date(year,month,1,0,0,0,0).getDate();//이번달의 첫째날 항상1아닌지..;
        console.log(firstDate);
        lastDate = new Date(year,month+1,0,0,0,0,0).getDate();//이번달의 마지막날
        console.log(lastDate);
        firstDay = new Date(year,month,1,0,0,0,0).getDay();//이번달의 첫째날의 요일
        console.log(firstDay);

    </script>
    
</body>
</html>