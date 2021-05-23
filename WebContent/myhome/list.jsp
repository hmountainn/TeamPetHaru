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
                            <h1 class="d-none">ë©ì¸ë©ë´</h1>
                            <ul>
                                <li><a href="list.html">ì°ë¦¬ì§</a></li>
                                <li><a href="../friends/list.html">ì´ìì§</a></li>
                                <li><a href="../pet-management/mypet/list.html">ë´ ëë¬¼ ê´ë¦¬</a></li>
                                <li><a href="../community/notice/list.html">ì»¤ë®¤ëí°</a></li>
                            </ul>
                    </nav>
                </div>
                <nav class="member-menu">
                    <h1 class="d-none">íìë©ë´</h1>
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
                            <h1 class="d-none">íì ì ë³´</h1>
                            <div class="img-member"></div>
                            <span class="id">id1</span>
                            <div class="friend-info">
                                <span class="follower font">íë¡ì</span> 
                                <button class="follower-num font">20</button>
                                <span class="follow font">íë¡ì°</span> 
                                <button class="follow-num font">10</button>
                            </div>
                        </section>
            
                        <section class="diary-upload-btn">
                            <h1 class="d-none">ì¼ê¸° ë±ë¡</h1>
                            <a href="upload.html"><button class="font">ì¼ê¸° ì°ê¸°</button></a>
                        </section>
                    </section>
                    <div class="diary-list">
                        <h1 class="d-none">ëë¬¼ ì¼ê¸° ëª©ë¡</h1>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/puppy1.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ë½ìì ì°ì±í ë </a></div>
                                <div class="keyword">
                                    <span>#ë½ì</span>
                                    <span>#ì°ì±</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/puppy2.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ê½ë°­ìì ì°°ì¹µ!</a><br>
                                </div>
                                <div class="keyword">
                                    <span>#ì¬ëì´</span>
                                    <span>#ê½ë°­ì°ì±</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/cat1.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ì½ì½ì ìë¡ì´ ëª¨ì :)</a></div>
                                <div class="keyword">
                                    <span>#ì½ì½</span>
                                    <span>#í ë¼ëª¨ì</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/puppy1.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ë½ìì ì°ì±í ë </a></div>
                                <div class="keyword">
                                    <span>#ë½ì</span>
                                    <span>#ì°ì±</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/puppy2.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ê½ë°­ìì ì°°ì¹µ!</a><br>
                                </div>
                                <div class="keyword">
                                    <span>#ì¬ëì´</span>
                                    <span>#ê½ë°­ì°ì±</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/cat1.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ì½ì½ì ìë¡ì´ ëª¨ì :)</a></div>
                                <div class="keyword">
                                    <span>#ì½ì½</span>
                                    <span>#í ë¼ëª¨ì</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/puppy1.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ë½ìì ì°ì±í ë </a></div>
                                <div class="keyword">
                                    <span>#ë½ì</span>
                                    <span>#ì°ì±</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/puppy2.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ê½ë°­ìì ì°°ì¹µ!</a><br>
                                </div>
                                <div class="keyword">
                                    <span>#ì¬ëì´</span>
                                    <span>#ê½ë°­ì°ì±</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="img-area">
                                <a href="detail.html">
                                <img class="img-pet" src="../images/cat1.jpg">
                                </a>
                            </div>
                            <div class="text-area">
                                <div class="diary-content"><a href="detail.html">ì½ì½ì ìë¡ì´ ëª¨ì :)</a></div>
                                <div class="keyword">
                                    <span>#ì½ì½</span>
                                    <span>#í ë¼ëª¨ì</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>

        <footer id="footer"></footer>
    </div>        
</body>
</html>