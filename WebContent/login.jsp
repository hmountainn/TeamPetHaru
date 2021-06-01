<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="login.css" type="text/css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
</head>
<body>
    <div id="root">
        <header id="header">
            <div class="float-content">
                <div class="flex align-center">

                    <div class="logo-title-container">
                        <img src="../images/logo.png" alt="">
                    </div>
                    <div class="title">LOGIN</div>
                </div>
            </div>
        </header>
        
        <!-- <nav id="nav">
            <ul>
                <li>nav1</li>
                <li>nav2</li>
            </ul>
        </nav> -->

        <div id="body">
            <div class="float-content">
                <aside id="aside">
                    <div class="aside-container">
                        <div class="image-container">
                            <img src="/images/bg-login.png" alt="">
                        </div>
                        <h1 class="copyright">반려동물과의 추억을 기록하세요.</h1>
                    </div>
                </aside>
                <main id="main">
                    <div class="login-main">
                        <section class="login-form">
                            <h1 class="d-none">로그인폼</h1>
                            <form action="login" method="post">
                                <fieldset>
                                    <legend class="d-none"> 로그인 필드</legend>
                                        <div class="id-input">
                                            <label>아이디</label>
                                            <input type="text" name="uid">
                                        </div>
                                        <div class="password-input">
                                            <label>비밀번호</label>
                                            <input type="password" name="password">
                                        </div>
                                        <div class="check-menu">
                                            <div>
                                                <input type="checkbox" name="" id="">
                                                <span>
                                                    아이디 저장
                                                </span>
                                            </div>
                                            <div>
                                                <input type="checkbox" name="" id="">
                                                <span>
                                                    관리자 로그인
                                                </span>
                                            </div>
                                        </div>
                                </fieldset>
                        <input class="login-btn font" type="submit" value="로그인"></button>  
                        <div class="btn-signUp">
                        	<a href="member/signup.html">회원가입</a> 
                        </div>  
                            </form>
                        </section>   
                            
                        <!-- <section class="login-menu">
                                <ul>
                                    <li><a class="btn-findId" href="findId.html">아이디찾기</a></li>
                                    <li><a class="btn-findPwd" href="findPassword.html">비밀번호찾기</a></li>
                                    <li><a class="btn-signUp" href="signup.html">회원가입</a></li>
                                </ul>
                        </section> -->
                    </div>
                </main>
            </div>
        </div>

        <!-- <footer id="footer"></footer> -->


    </div>
    
</body>
</html>