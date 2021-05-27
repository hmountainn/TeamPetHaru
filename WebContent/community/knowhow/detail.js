window.addEventListener("load", function() {
	
	// 모달창 띄우기
    var background = document.querySelector(".black-bg");
    var modal = document.querySelector(".modal");
    var deleteBtn = document.querySelector(".button-menu .delete-btn");

    deleteBtn.onclick = function(e) {	
        background.classList.remove("d-none");
        modal.classList.remove("d-none");
    };

    modal.onclick = function(e) {
        if(!e.target.classList.contains("modal-close") && !e.target.classList.contains("close-btn"))
            return;

        background.classList.add("d-none");
        modal.classList.add("d-none");
    }
	
	// ------------------------------------------------------------
	
	// 상세 데이터 불러오기
/*	var knowhowHeader = document.querySelector(".knowhow-header");
	var memberInfo = document.querySelector(".member-info");
	var content = document.querySelector(".write-content");*/
	
	// list에서 url의 쿼리 스트링으로 전달받은 id값 얻기
/*	var qs = getQueryStringObject();
	var id = Number(qs.id);*/
	
	// list에서 전달받은 노하우 게시글의 아이디를 url에 같이 전달하기
	/*bind(`../PetharuPrj/api/knowhow/list?id=${id}`);

	function bind(url) {
		var request = new XMLHttpRequest();
		
		request.onload = function() {
			
			// url에 id를 전달해서 얻은 결과
			var list = JSON.parse(request.responseText);
			
			for(var i=0; i<list.length; i++) {
				var div = 
				   `<h1 class="title">${list[i]}</h1>
					<div class="knowhow-info">
						<ul>
							<li>
								<img src="../images/view.png">
								<span>26</span>
							</li>
							<li>
								<img src="../images/heart.png">
								<span>7</span>
							</li>
							<li>
								<img src="../images/comment.png">
								<span>3</span>
							</li>
						</ul>
					</div>`;
				
				knowhowList.insertAdjacentHTML("beforeend", div);
			}
			
		}
		
		request.open("GET", url, true);
		request.send(null);   
	}*/
	
});