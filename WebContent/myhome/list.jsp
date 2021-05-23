<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="list.css" type="text/css" rel="stylesheet">
    <script src="list.js"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
</head>
<body>
    <div id="root">
        <header id="header">
            <div class="float-content">
                <div class="flex align-center">
                    <a href="" class="logo-title-container">
                        <img src="../images/logo.png">
                    </a>
                    <nav class="main-menu">   
                            <h1 class="d-none">메인메뉴</h1>
                            <ul>
                                <li><a href="list.html">우리집</a></li>
                                <li><a href="../friends/list.html">이웃집</a></li>
                                <li><a href="../pet-management/mypet/list.html">내 동물 관리</a></li>
                                <li><a href="../community/notice/list.html">커뮤니티</a></li>
                            </ul>
                    </nav>
                </div>
                <nav class="member-menu">
                    <h1 class="d-none">회원메뉴</h1>
                    <ul>
                        <li><a href="../member/profile-edit.html">MyPage</a></li>
                        <li><a href="../../login.html">LogOut</a></li>
                    </ul>
                </nav>
            </div>
        </header>

        <div id="body">
            <div class="float-content">
                <main id="main">
                    <section>
                        <section class="member-info">
                            <h1 class="d-none">회원 정보</h1>
                            <div class="img-member"></div>
                            <span class="id">id1</span>
                            <div class="friend-info">
                                <span class="follower font">팔로워</span> 
                                <span class="follower-num font">20</span>
                                <span class="follow font">팔로우</span> 
                                <span class="follow-num font">10</span>
                            </div>
                        </section>
            
                        <section class="diary-upload-btn">
                            <h1 class="d-none">일기 등록</h1>
                            <a href="upload.html"><button class="font">일기 쓰기</button></a>
                        </section>
                    </section>
                    <div class="diary-list">
                        <h1 class="d-none">동물 일기 목록</h1>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/puppy1.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">뽀삐와 산책한 날</span>
                                <div class="keyword">
                                    <span>#뽀삐</span>
                                    <span>#산책</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/puppy2.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">꽃밭에서 찰칵!</span>
                                <div class="keyword">
                                    <span>#사랑이</span>
                                    <span>#꽃밭산책</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/cat1.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">코코의 새로운 모자 :)</span>
                                <div class="keyword">
                                    <span>#코코</span>
                                    <span>#토끼모자</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/puppy1.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">뽀삐와 산책한 날</span>
                                <div class="keyword">
                                    <span>#뽀삐</span>
                                    <span>#산책</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/puppy2.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">꽃밭에서 찰칵!</span>
                                <div class="keyword">
                                    <span>#사랑이</span>
                                    <span>#꽃밭산책</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/cat1.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">코코의 새로운 모자 :)</span>
                                <div class="keyword">
                                    <span>#코코</span>
                                    <span>#토끼모자</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/puppy1.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">뽀삐와 산책한 날</span>
                                <div class="keyword">
                                    <span>#뽀삐</span>
                                    <span>#산책</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/puppy2.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">꽃밭에서 찰칵!</span>
                                <div class="keyword">
                                    <span>#사랑이</span>
                                    <span>#꽃밭산책</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <img class="img-pet" src="../images/cat1.jpg">
                            </div>
                            <div class="text-area">
                                <span class="diary-content">코코의 새로운 모자 :)</span>
                                <div class="keyword">
                                    <span>#코코</span>
                                    <span>#토끼모자</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>

        <footer id="footer"></footer>
        
        <section class="detail-section d-none">
            <div class="img-area">
                <img class="img-pet" src="../images/puppy1.jpg">
            </div>
            <div>
                <section class="member-info">
                    <h1 class="d-none">회원 정보</h1>
                    <div class="img-member"></div>
                    <span class="id">id1</span>
                </section>
                <section>
                    <h1 class="d-none">일기 내용</h1>
                    <hr>
                    <div class="text-area">
                        <div class="diary-content">뽀삐와 산책한 날<br>오늘따라 더 신난 뽀삐</div>
                        <div class="keyword">
                            <span>#뽀삐</span>
                            <span>#산책</span>
                        </div>
                    </div>
                    <div class="upload-date">2021-04-11</div>
                    <section class="button-menu">
                        <h1 class="d-none">버튼</h1>
                        <button class="btn"><a href="edit.html">수정</a></button>
                        <button class="btn delete-btn">삭제</button>
                    </section>
                    <hr>
                </section>
            </div>
            <div>
	            <a class="modal-close" href=""><img class="close-btn" src="../images/close-button.png" alt=""></a>
	        </div>
        </section>
        
        <div class="delete-section">
            <div class="black-bg d-none"></div>
            <div class="modal d-none">
                <div class="modal-content">
                    게시글을 삭제하시겠습니까?
                </div>
                <section class="modal-button-menu">
                    <h1 class="d-none">모달창 버튼</h1>
                    <button class="modal-btn modal-close">취소</button>
                    <button class="modal-btn">확인</button>
                </section>
                <div>
                    <a class="modal-close" href="#"><img class="close-btn" src="../images/close-button.png" alt=""></a>
                </div>
            </div>
        </div>
    </div>        
</body>
</html>