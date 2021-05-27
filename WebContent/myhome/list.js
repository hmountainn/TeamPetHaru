window.addEventListener("load", function() {
	let section = document.querySelector("#main");
	let body = document.querySelector("#body")
	let memberInfo = section.querySelector(".member-info");
	let diarySection = section.querySelector(".diary-list");
	let detailSection = document.querySelector(".detail-section");
	let pager = section.querySelector(".pager");
	let pageNum = pager.querySelector("ul a")
	let background = document.querySelector(".black-bg");
	let header = document.querySelector("#header");
    let modal;
	let deleteSection;
	let diaryId;
	
	// 일기 목록 출력
	showList(`../../api/myhome/list`);
	
	pager.onclick = function(e) {	
		e.preventDefault();
			
		if(e.target.tagName != "A")
			return;

		let page = e.target.innerText;
		console.log(page);
		showList(`../../api/myhome/list?page=${page}`);
		
		pageNum.classList.remove("text-strong");
		e.target.classList.add("text-strong");
		pageNum = e.target;
	}
	
	// 일기 목록 출력
	function showList(url) {
		let request = new XMLHttpRequest();
		
		request.onload = function() {
			let list = JSON.parse(request.responseText);
			console.log(list);

			if(list.length > 0) {
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
								<div class="diary-info">
                            		<ul>
                            			<li>
                            				<img src="../../images/view.png">
                            				<span>${list[i].hit}</span>
                            			</li>
                            			<li>
                            				<img src="../../images/heart.png">
                            				<span>${list[i].likeCount}</span>
                            			</li>
                            			<li>
                            				<img src="../../images/comment.png">
                            				<span>${list[i].commentCount }</span>
                            			</li>
                            		</ul>
                            	</div>
	                            <span class="diary-content">${list[i].content}</span>
	                            <div class="keyword">
	                                <span>${list[i].keyword}</span>
	                            </div>
	                        </div>
	                    </div>`;
					
					diarySection.insertAdjacentHTML("beforeend", diaryList);
				}
			} else {
				let memberContent = 
				   `<div class="img-member"></div>
		            <span class="id">${list.memberId}</span>
		            <div class="friend-info">
		                <span class="follower font">팔로워</span> 
		                <span class="follower-num font">20</span>
		                <span class="follow font">팔로우</span> 
		                <span class="follow-num font">10</span>
		            </div>`;
	
				memberInfo.insertAdjacentHTML("beforeend", memberContent);
			
				let empty = `<p>존재하지 않는 페이지입니다<p>`;
				diarySection.innerHTML = empty;
			}
		}
		
		request.open("GET", url, true);
		request.send(null);
	}
	
	// 일기 클릭 시 일기 세부내용 보여주기
	diarySection.onclick = function(e) {
		if(!e.target.classList.contains("img-pet") && !e.target.classList.contains("diary-content"))
            return;

		background.classList.remove("d-none");
		detailSection.classList.remove("d-none");
		
		// 일기 id 얻어오기
		diaryId = e.target.parentNode.parentNode.firstElementChild.value;
		showDetail(`../../myhome/detail?id=${diaryId}`, commentFnctn);
	}
	
	// 일기 세부내용 출력
	function showDetail(url, commentFnctn) {
		let request = new XMLHttpRequest();
		
		request.onload = function() {
			let diary = JSON.parse(request.responseText);
						
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
								<!-- 일기 아이디 심기 --!>
								<input class="diaryId" type="hidden" name="id" value="${diaryId}">
		                        <h1 class="d-none">버튼</h1>
		                        <a href="edit.html?id=${diaryId}"><button class="btn edit-btn">수정</button></a>
		                        <button class="btn delete-btn">삭제</button>
		                    </section>
		                    <hr>
		                </section>

						<!-- 댓글창 -->
						<section id="diary-comment-sctn">
	                        <h1 class="d-none">일기 댓글창</h1>
	                        
							<section class="diary-comment-write">
	                            <h1 class="d-none">일기 댓글 작성</h1>
	                            <form method="post">
	                               <input type="hidden" name="diary-id" value="${diary.id}">
	                               <input type="hidden" name="comment-member-id" value="1">
	                               <textarea name="comment-content" id="diary-comment-writing" cols="45" rows="3" placeholder="댓글을 작성해주세요."></textarea>
	                               <button class="submit-btn button-2" type="submit">등록</button>
	                            </form>
	                        </section>
						<!-- 댓글창 -->
						
		            </div>
					<div class="modal-close">
			        	<img class="close-btn" src="../images/close-button.png" alt="">
			        </div>`;
				
				detailSection.insertAdjacentHTML("afterbegin", diaryContent);
				
				// 댓글창 추가
				commentLoad(`/api/myhome/comment/list?diary-id=${diaryId}`);
				commentFnctn(`${diaryId}`);
			}
		
		request.open("GET", url, true);
		request.send(null);
	}
	
	document.onclick = function(e) {
		// 일기 세부내용 창 닫기	
		if(e.target.classList.contains("close-btn")) {
			console.log("아자!");
			background.classList.add("d-none");
			detailSection.classList.add("d-none");
			
			// 창 닫을 때 일기 세부내용 엘리먼트 지우기
			detailSection.removeChild(detailSection.firstChild);
			detailSection.removeChild(detailSection.firstChild.nextSibling); 
			
		}
		
		// 일기 삭제 모달창 열기
		if(e.target.classList.contains("delete-btn")) {
			console.log("click");
				
			deleteSection = 
				`<div class="delete-section">
		            <div class="black-bg d-none"></div>
		            <div class="modal">
		                <div class="modal-content">
		                    게시글을 삭제하시겠습니까?
		                </div>
		                <section class="modal-button-menu">
		                    <h1 class="d-none">모달창 버튼</h1>
		                    <button class="modal-btn modal-close">취소</button>
		                    <button class="modal-btn delete">확인</button>
		                </section>
		                <div>
		                    <a class="modal-close" href="#"><img class="close-btn2" src="../images/close-button.png" alt=""></a>
		                </div>
		            </div>
		        </div>`;
			
			detailSection.insertAdjacentHTML("afterend", deleteSection);
		
	        background.classList.remove("d-none");
			detailSection.style.zIndex = 0;
			background.style.opacity = 0.8;
		}
		
		modal = document.getElementsByClassName("modal");
		
		// 일기 삭제하기
		if(e.target.classList.contains("delete")) {
			deleleDiary(`/myhome/del?id=${diaryId}`);
			
			function deleleDiary(url) {
				let request = new XMLHttpRequest();
				
				request.onload = function(){
					location.href = "list.html";
				};
				request.open("GET", url, true);
				request.send(null);
			}	
		}

		// 삭제 확인 모달창 닫기
		if(e.target.classList.contains("modal-close") || e.target.classList.contains("close-btn2")) {
			console.log(modal);
			
			header.style.zIndex = 0;
			background.style.opacity = 0.7;
			background.style.zIndex = 999;
			detailSection.style.zIndex = 1000;
			modal[0].classList.add("d-none");
		}	
	}	
	
});