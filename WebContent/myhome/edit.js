window.addEventListener("load", function() {
	
	// url의 파라미터 받는 함수
	function getParameter(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
		
	// url로 전달된 id값 가져오기	
	let diaryId = getParameter("id");
	let form = document.querySelector("#main form");
	
	showEditPage(`/myhome/detail?id=${diaryId}`);
	console.log(diaryId);
	
	function showEditPage(url) {
		let request = new XMLHttpRequest();
		
		request.onload = function() {
			let diary = JSON.parse(request.responseText);
						
				// 일기 세부내용 보여주기
				let diaryContent = 
					`<section class="write-content">
                            <section>
                                <h1>이미지 등록</h1>
								<input type="hidden" name="id" value="${diaryId}">
                                <span class="required">*</span>
                                <div class="img-pet">
                                    <img src="../images/puppy1.jpg">
                                    <button class="img-upload-btn d-none">이미지 업로드</button>
                                    <div class="trash-btn">
                                        <img src="../images/trash.png">
                                    </div>
                            </section>
                            <section>
                                <h1>일기 작성</h1>
                                <span class="required">*</span>
                                <textarea name="content" placeholder="내용을 입력해주세요">${diary.content}</textarea>
                            </section>
                        </section>
                        <section class="write-keyword">
                            <h1>키워드 입력</h1>
                            <div>
                                <input class="keyword font" type="text" name="keyword" placeholder="#" value="${diary.keyword}">
                            </div>
                        </section>
                        <hr class="line">
                        <section class="button-menu">
                            <h1 class="d-none">버튼</h1>
                            <button><a class="font" href="list.html">취소하기</a></button>
                            <button class="font">등록하기</button>
                        </section>`;
				
				form.insertAdjacentHTML("afterbegin", diaryContent);
			}
		
		request.open("GET", url, true);
		request.send(null);
	}
});