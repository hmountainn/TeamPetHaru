<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="stats-style.css" type="text/css" rel="stylesheet">
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
                                <li><a href="../../friends/list.html">이웃집</a></li>
                                <li><a href="../mypet/list.html">내 동물관리</a></li>
                                <li><a href="../../community/knowhow/list.html">커뮤니티</a></li>
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
                            <li><a href="../mypet/list.html">동물 관리</a></li>
                            <li><a class="current-page" href="form.html">체중 관리</a></li>
                            <li><a href="../schedule/calendar.html">일정 관리</a></li>                       
                        </ul>
                    </nav>
                </aside>
                <main id="main">
                    <div class="record">
                        
                        <table class="record-table">
    
                            <h1 class="record-title">체중 통계</h1>
                            <thead>
                                <tr>
                                    <td>기간 말일</td>
                                    <td>주 평균</td>
                                    <td>전주대비</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>2021-01-02</td>
                                    <td>4.93 KG</td>
                                    <td class="down">▼0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-01-09</td>
                                    <td>5.02 KG</td>
                                    <td class="up">▲0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-01-16</td>
                                    <td>5.08 KG</td>
                                    <td class="up">▲0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-01-23</td>
                                    <td>5.03 KG</td>
                                    <td class="down">▼0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-01-30</td>
                                    <td>4.97 KG</td>
                                    <td class="down">▼0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-02-06</td>
                                    <td>4.94 KG</td>
                                    <td class="down">▼0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-02-13</td>
                                    <td>4.98 KG</td>
                                    <td class="up">▲0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-02-20</td>
                                    <td>5.00 KG</td>
                                    <td class="up">▲0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-02-27</td>
                                    <td>4.99 KG</td>
                                    <td class="down">▼0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-03-06</td>
                                    <td>5.10 KG</td>
                                    <td class="up">▲0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-03-13</td>
                                    <td>5.15 KG</td>
                                    <td class="up">▲0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-03-20</td>
                                    <td>5.12 KG</td>
                                    <td class="down">▼0.30 KG</td>
                                </tr>
                                <tr>
                                    <td>2021-03-27</td>
                                    <td>5.09 KG</td>
                                    <td class="down">▼0.30 KG</td>
                                </tr>
    
                            </tbody>
                        </table>
                    </div>
                </main>
            </div>
        </div>

        <footer id="footer">footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer footer</footer>


    </div>
    
</body>
</html>