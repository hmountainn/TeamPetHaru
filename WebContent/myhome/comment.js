window.addEventListener("load", function() {
    var section = document.querySelector("#diary-comment-sctn"); //댓글 전체창
	var diaryId = section.querySelector("input[name=diary-id]").value;
	var newCommentBtn = section.querySelector(".submit-btn");
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
		
					section.insertAdjacentHTML("beforeend", diaryComment);;
				}
				
			}
		}
	};
	
	request.open("GET", `/api/myhome/comment/list?diary-id=${diaryId}`);
	request.send(null);
	
	
	newCommentBtn.onclick = function() {
		var content = section.querySelector(".diary-comment-write textarea").value;
		if (!content) {
			alert("내용을 입력해주세요.");
			return false;
		} else {
			var request = new XMLHttpRequest();
			request.onload = function() {
				location.href = "./comment.html";
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
						location.href = "./comment.html";
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


})