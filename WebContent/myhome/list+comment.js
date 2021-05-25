window.addEventListener("load", function() {
	let section = document.querySelector("#main");
	let body = document.querySelector("#body")
	let memberInfo = section.querySelector(".member-info");
	let diarySection = section.querySelector(".diary-list");
	let detailSection = document.querySelector(".detail-section");
	let imgArea = detailSection.getElementsByClassName(".img-area");
	let contentArea = detailSection.getElementsByClassName(".content-area");
	let pager = section.querySelector(".pager");
	let pageNum = pager.querySelector("ul a")
	let background = document.querySelector(".black-bg");
	let header = document.querySelector("#header");
    let modal = document.querySelector(".modal");
	let closeBtn = document.querySelector(".close-btn");
	let closeBtn2;
	let diaryId;
	let deleteBtn;
	
	// 일기 목록 출력
	showList(`../../api/diary/list`);
	
	pager.onclick = function(e) {	
		e.preventDefault();
			
		if(e.target.tagName != "A")
			return;

		let page = e.target.innerText;
		showList(`../../api/diary/list?page=${page}`);
		
		pageNum.classList.remove("text-strong");
		e.target.classList.add("text-strong");
		pageNum = e.target;
	}
	
	// 일기 목록 출력
	function showList(url) {
		let request = new XMLHttpRequest();
		
		request.onload = function() {
			let list = JSON.parse(request.responseText);
			
			if(list.length > 0) {
				memberInfo.innerHTML = "";
				diarySection.innerHTML = "";
				
				// 멤버 정보 보여주기
				let memberContent = 
				   `<div class="img-member"></div>
	                <span class="id">${list[0].memberId}</span>
	                <div class="friend-info">
	                    <span class="follower font">팔로워</span> 
	                    <span class="follower-num font">20</span>
	                    <span class="follow font">팔로우</span> 
	                    <span class="follow-num font">10</span>
	                </div>`;
	
				memberInfo.insertAdjacentHTML("beforeend", memberContent);
				
				// 일기 목록 보여주기
				for(let i=0; i<list.length; i++) {
					let diaryList = 
					    `<div>
							<input type="hidden" name="id" value="${list[i].id}">
	                        <div class="img-area">
	                            <img class="img-pet" src="../images/cat-rest.jpg">
	                        </div>
	                        <div class="text-area">
	                            <span class="diary-content">${list[i].content}</span>
	                            <div class="keyword">
	                                <span>${list[i].keyword}</span>
	                            </div>
	                        </div>
	                    </div>`;
					
					diarySection.insertAdjacentHTML("beforeend", diaryList);
				}
			} else {
				let empty = `<p>존재하지 않는 페이지입니다<p>`
				diaryList.innerHTML = empty;
			}
		}
		
		request.open("GET", url, true);
		request.send(null);
	}
	
	// 일기 클릭 시 일기 세부내용 보여주기
	diarySection.onclick = function(e) {
		if(!e.target.classList.contains("img-pet") && !e.target.classList.contains("diary-content") 
			&& !e.target.classList.contains("close-btn"))
            return;

		background.classList.remove("d-none");
		detailSection.classList.remove("d-none");
		
		// 일기 id 얻어오기 
		diaryId = e.target.parentNode.parentNode.firstElementChild.value;
		showDetail(`../../diary/detail?id=${diaryId}`, commentFnctn); // ~~ 함수에 인자 추가
		
	}


	// 일기 세부내용 출력 ~~ 함수에 인자 추가
	function showDetail(url, commentFnctn) {
		let request = new XMLHttpRequest();
		
		request.onload = function() {
			let diary = JSON.parse(request.responseText);
			console.log(diary);
						
				// 일기 세부내용 보여주기
				let diaryContent = 
					`<div class="img-area">
		                <img class="img-pet" src="../images/cat-rest.jpg">
		            </div>
		            <div class="content-area">
		                <section class="member-info">
		                    <h1 class="d-none">회원 정보</h1>
		                    <div class="img-member"></div>
		                    <span class="id">My Diary<!--${diary.memberId}--!></span>
		                </section>
		                <section>
		                    <h1 class="d-none">일기 내용</h1>
		                    <hr>
		                    <div class="text-area">
		                        <div class="diary-content">${diary.content}</div>
		                        <div class="keyword">
		                            <span>${diary.keyword}</span>
		                        </div>
		                    </div>
		                    <div class="upload-date">${diary.regDate}</div>
		                    <section class="button-menu">
		                        <h1 class="d-none">버튼</h1>
		                        <button class="btn"><a href="edit.html">수정</a></button>
		                        <button class="btn delete-btn">삭제</button>
		                    </section>
		                    <hr>
		                </section>


						<!-- ~~ 댓글창 시작 -->

						<section id="diary-comment-sctn">
	                        <h1 class="d-none">일기 댓글창</h1>
	                        
							<section class="diary-comment-write">
	                            <h1 class="d-none">일기 댓글 작성</h1>
	                            <form method="post">
	                               <input type="hidden" name="diary-id" value="${diary.id}">
	                               <input type="hidden" name="comment-member-id" value="1">
	                               <textarea name="comment-content" id="diary-comment-writing" cols="50" rows="3" placeholder="댓글을 작성해주세요."></textarea>
	                               <button class="submit-btn button-2" type="submit">등록</button>
	                            </form>
	                        </section>

						<!-- ~~ 댓글창 끝 -->
		            </div>`;
				
				detailSection.insertAdjacentHTML("afterbegin", diaryContent);
						
						
				// ~~ 댓글장 추가 함수
				commentLoad(`/api/myhome/comment/list?diary-id=${diaryId}`);
				commentFnctn(diaryId);
			
		}
		
		request.open("GET", url, true);
		request.send(null);
	}
	
	// 일기 세부내용 창 닫기	
	closeBtn.onclick = function(e) {

		console.log("test");
		background.classList.add("d-none");
		detailSection.classList.add("d-none");
		
		// 창 닫을 때 일기 세부내용 엘리먼트 지우기
		detailSection.removeChild(detailSection.firstChild);
		detailSection.removeChild(detailSection.firstChild.nextSibling); 
	}
	
	// 일기 삭제하기
	deleteBtn = document.getElementsByClassName(".delete-btn");
    deleteBtn.onclick = function() {
        background.classList.remove("d-none");
        modal.classList.remove("d-none");
		detailSection.style.zIndex = 0;
		background.style.opacity = 0.8;
    };

    modal.onclick = function(e) {
        e.preventDefault();

        if(!e.target.classList.contains("modal-close") && !e.target.classList.contains("close-btn"))
            return;

		header.style.zIndex = 0;
		background.style.opacity = 0.7;
		background.style.zIndex = 999;
		detailSection.style.zIndex = 1000;
        modal.classList.add("d-none");
    }




	//~~ 댓글창 추가 함수 시작
	function commentLoad(url) {
		var section = document.querySelector("#diary-comment-sctn"); //댓글 전체창
		var memberId = section.querySelector(".diary-comment-write input[name=comment-member-id]").value;
	
		var request = new XMLHttpRequest();
		request.onload = function() {
			var commentList = JSON.parse(request.responseText);
	
			if (commentList.length > 0) {
				
				for (var i = 0; i<commentList.length; i++) {
					
					if(`${commentList[i].memberId}` == memberId) {
						var diaryComment = `<section class="diary-comment">
			                                    <h1 class="d-none">일기 개별댓글</h1>
												<input type="hidden" name="comment-id" value="${commentList[i].id}">
			                                    <section class="comment-info">
			                                        <h1 class="d-none">댓글 작성자 프로필</h1>
			                                        <img src="../images/user.png" alt="profile">
			                                        <span class="comment-writer-id">${commentList[i].userId}</span>
			                                        <span class="comment-regdate">${commentList[i].regdate}</span>
			                                    </section>
			                                    <section class="comment-content">
			                                        <h1 class="d-none">댓글 내용</h1>
			                                        <span>${commentList[i].content}</span>
			                                    </section>
			                                    <div class="comment-button">
			                                        <span class="reply-btn">답댓글</span>
													<span class="update-btn">수정</span>
		                                        	<span class="del-btn">삭제</span>
			                                        <span class="post-cmt-btn d-none">등록</span>
			                                        <span class="cancle-cmt-btn d-none">취소</span>
			                                    </div>
			                                </section>`
			
						section.insertAdjacentHTML("beforeend", diaryComment);
						
					} else {
						var diaryComment = `<section class="diary-comment">
			                                    <h1 class="d-none">일기 개별댓글</h1>
												<input type="hidden" name="comment-id" value="${commentList[i].id}">
			                                    <section class="comment-info">
			                                        <h1 class="d-none">댓글 작성자 프로필</h1>
			                                        <img src="../images/user.png" alt="profile">
			                                        <span class="comment-writer-id">${commentList[i].userId}</span>
			                                        <span class="comment-regdate">${commentList[i].regdate}</span>
			                                    </section>
			                                    <section class="comment-content">
			                                        <h1 class="d-none">댓글 내용</h1>
			                                        <span>${commentList[i].content}</span>
			                                    </section>
			                                    <div class="comment-button">
			                                        <span class="reply-btn">답댓글</span>
			                                        <span class="post-cmt-btn d-none">등록</span>
			                                        <span class="cancle-cmt-btn d-none">취소</span>
			                                    </div>
			                                </section>`
			
						section.insertAdjacentHTML("beforeend", diaryComment);
					}
					
				}
			}
		};
		
		request.open("GET", url);
		request.send(null);
	};
	
		
	function commentFnctn(diaryId) {
		var section = document.querySelector("#diary-comment-sctn"); //댓글 전체창
		var newCommentBtn = section.querySelector(".submit-btn");
		var memberId = section.querySelector(".diary-comment-write input[name=comment-member-id]").value;
		
		newCommentBtn.onclick = function() {
			var content = section.querySelector(".diary-comment-write textarea").value;
			if (!content) {
				alert("내용을 입력해주세요.");
				return false;
			} else {
				var request = new XMLHttpRequest();
				request.onload = function() {
					location.href = "./list.html";
				}
				request.open("POST", `/myhome/comment/create?diary-id=${diaryId}`);
				request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				request.send(`comment-content=${content}&comment-member-id=${memberId}`);
			}
		}
		
		section.onclick = function(e) {
			//삭제
			if (e.target.classList.contains("del-btn")) {
	            if(confirm("정말로 삭제하시겠습니까?")) {
					var commentId = e.target.parentElement.parentElement.querySelector("input[name=comment-id]").value;
					var request = new XMLHttpRequest();
					request.onload = function() {
						location.reload();
					};
					request.open("GET", `/myhome/comment/delete?comment-id=${commentId}`);
					request.send(null);
				} else
					e.preventDefault();
	        }
	
			//수정
			else if (e.target.classList.contains("update-btn")) {
				var commentId = e.target.parentElement.parentElement.querySelector("input[name=comment-id]").value;
				var writerBtns = e.target.parentElement;
	            var contentSection = writerBtns.previousElementSibling; //댓글내용.comment-content
	            var currentContent = contentSection.querySelector("span");
	            var currentTxt = currentContent.innerText;
	            var input = document.createElement("input", "text");
	
	            input.value = currentTxt;
	            input.style.width = "250px";
	            input.style.fontSize = "16px";
	            contentSection.replaceChild(input, currentContent);
	
	            var btnList = writerBtns.children;
	            for(var i=0; i<btnList.length; i++) {
	                btnList[i].classList.toggle("d-none");
	            };
				
				//수정 후 등록
				var postBtn = writerBtns.querySelector(".post-cmt-btn");
	            postBtn.onclick = function() {
					var updateContent = contentSection.querySelector("input").value;
					if (!updateContent) {
						alert("내용을 입력해주세요.");
						return false;
					} else {
						var request = new XMLHttpRequest();
						request.onload = function() {
							location.reload();
						}
						request.open("POST", `/myhome/comment/update?comment-id=${commentId}`);
						request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
						request.send(`comment-content=${updateContent}`);					
					}
				}
				
				//수정 취소
				var cancleBtn = writerBtns.querySelector(".cancle-cmt-btn");
	            cancleBtn.onclick = function() {
	                var btnList = writerBtns.children;
	                for(var i=0; i<btnList.length; i++) {
	                    btnList[i].classList.toggle("d-none");
	                }
	                var input = contentSection.querySelector("input");
	                contentSection.removeChild(input);
	                contentSection.append(currentContent);
	            };
			}
			
			//답댓글
			else if (e.target.classList.contains("reply-btn")) {
				var input = document.createElement("input", "text");
	            input.style.width = "250px";
	            input.style.fontSize = "16px";
	            input.style.marginBottom = "10px";
	
				var commentBtns = e.target.parentElement;
	            var btnList = commentBtns.children;
	            for(var i=0; i<btnList.length; i++) {
	                btnList[i].classList.toggle("d-none");
	            };
	            commentBtns.insertAdjacentElement("beforebegin", input);
				
				//답댓글 등록
				var postBtn = commentBtns.querySelector(".post-cmt-btn")
	            postBtn.onclick = function() {
					if (!input.value) {
						alert("내용을 입력해주세요.");
						return false;
					} else {
		                var eleList = commentBtns.children;
		                for (var i=0; i<eleList.length; i++) {
		                    eleList[i].classList.toggle("d-none");
		                };
		
						var replyIdSpan = input.previousElementSibling.previousElementSibling.querySelector(".comment-writer-id");
						var replyId = replyIdSpan.innerText; 
						var request = new XMLHttpRequest();
						request.onload = function() {
							location.href = "./list.html";
						};
						request.open("POST", `/myhome/comment/create?diary-id=${diaryId}`);
						request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
						request.send(`comment-content=${'@'+replyId+')'}+${input.value}&comment-member-id=${memberId}`);
					}
	            };
	
				//답댓글 취소
				var cancleBtn = commentBtns.querySelector(".cancle-cmt-btn");
	            cancleBtn.onclick = function(e) {
					var commentBtns = e.target.parentElement;
	                var btnList = commentBtns.children;
	                for(var i=0; i<btnList.length; i++) {
	                    btnList[i].classList.toggle("d-none");
	                }
					var input = commentBtns.previousElementSibling;
	                var comment = commentBtns.parentElement;
					comment.removeChild(input); 
	            };
			}
	
	        else
	            return;
		}
	}
	//~~ 댓글창 추가 함수 끝

});