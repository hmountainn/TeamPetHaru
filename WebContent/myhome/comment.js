window.addEventListener("load", function() {
    var section = document.querySelector("#diary-comment-sctn"); //댓글 전체창
	var diaryId = section.querySelector("input[type=hidden]").value;

	var request = new XMLHttpRequest();
	request.onload = function() {
		var commentList = JSON.parse(request.responseText);

		if (commentList.length > 0) {
			
			for (var i = 0; i<commentList.length; i++) {
				var diaryComment = `<section class="diary-comment">
	                                    <h1 class="d-none">일기 개별댓글</h1>
	                                    <section class="comment-info">
	                                        <h1 class="d-none">댓글 작성자 프로필</h1>
	                                        <img src="../images/user.png" alt="profile">
	                                        <span class="comment-member-id">${commentList[i].userId}</span>
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
	};
	
	request.open("GET", `/api/myhome/comment/list?diary-id=${diaryId}`);
	request.send(null);



    /*section.onclick = function(e) {

        //내가 단 댓글 수정
        if (e.target.classList.contains("update-btn")) {
            var writerBtn = e.target.parentElement;
            var content = writerBtn.previousElementSibling; //댓글내용.comment-content
            var contentSpan = content.querySelector("span");
            var contentTxt = contentSpan.innerText;
            var input = document.createElement("input", "text");
            var eleList = writerBtn.children;

            input.value = contentTxt;
            input.style.width = "250px";
            input.style.fontSize = "16px";
            content.replaceChild(input, contentSpan);

            for(var i=0; i<eleList.length; i++) {
                eleList[i].classList.toggle("d-none");
            };

            //등록
            var postBtn = writerBtn.querySelector(".post-cmt-btn");
            postBtn.onclick = function() {
                var eleList = writerBtn.children;
                for (var i=0; i<eleList.length; i++) {
                    eleList[i].classList.toggle("d-none");
                };
                var input = content.querySelector("input");
                contentSpan.innerText = input.value;
                content.removeChild(input);
                content.append(contentSpan);
            };

            //취소
            var cancleBtn = writerBtn.querySelector(".cancle-cmt-btn")
            cancleBtn.onclick = function() {
                var eleList = writerBtn.children;
                for(var i=0; i<eleList.length; i++) {
                    eleList[i].classList.toggle("d-none");
                }
                var input = content.querySelector("input");
                content.removeChild(input);
                content.append(contentSpan);
            };
        }


        //답댓글
        else if (e.target.classList.contains("reply-btn")) {
            var input = document.createElement("input", "text");
            input.style.width = "250px";
            input.style.fontSize = "16px";
            input.style.marginBottom = "10px";
            
            var commentBtn = e.target.parentElement;
            var eleList = commentBtn.children;
            for(var i=0; i<eleList.length; i++) {
                eleList[i].classList.toggle("d-none");
            };
            commentBtn.insertAdjacentElement("beforebegin", input);

            //등록
            var postBtn = commentBtn.querySelector(".post-cmt-btn")
            var comment = commentBtn.parentElement; //개별댓글.diary-comment
            postBtn.onclick = function() {
                var eleList = commentBtn.children;
                for (var i=0; i<eleList.length; i++) {
                    eleList[i].classList.toggle("d-none");
                };
                
                var replyDiv = `<div style="margin-top:15px; margin-left:25px;">
                                    <span>${input.value}</span>
                                </div>`;
                commentBtn.insertAdjacentHTML("afterend", replyDiv);
                comment.removeChild(input);
            };

            //취소
            var cancleBtn = commentBtn.querySelector(".cancle-cmt-btn");
            cancleBtn.onclick = function() {
                var eleList = commentBtn.children;
                for(var i=0; i<eleList.length; i++) {
                    eleList[i].classList.toggle("d-none");
                };
                comment.removeChild(input);
            };
        }


        //삭제
        else if (e.target.classList.contains("del-btn")) {
            var delConfirm = confirm("정말로 삭제하시겠습니까?");
            if (delConfirm == true) {
                var comment = e.target.parentElement.parentElement;
                section.removeChild(comment);
            };
        }

        
        else
            return;
        
    };*/

})