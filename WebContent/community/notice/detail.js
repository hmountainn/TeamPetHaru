window.addEventListener("load", function() {
	var section = document.querySelector("#main");
	var title = section.querySelector("h1");
	var id = section.querySelector(".notice-info .id");
	var adminUserId = section.querySelector(".notice-info .admin-user-id");
	var regDate = section.querySelector(".notice-info .reg-date");
	var hit = section.querySelector(".notice-info .hit");
	var article = section.querySelector(".notice-article div")
	var updateBtn = section.querySelector(".article-button .update-btn");
	var deleteBtn = section.querySelector(".article-button .delete-btn");

	let params = new URLSearchParams(window.location.search);
	let noticeId = parseInt(params.get("id"));
	
	var request = new XMLHttpRequest();
	request.onload = function() {
		var notice = JSON.parse(request.responseText);
		title.innerHTML += `${notice.title}`;
		id.innerHTML += `${notice.id}`;
		adminUserId.innerHTML += `${notice.adminId}`;
		regDate.innerHTML += `${notice.regDate}`;
		hit.innerHTML += `${notice.hit}`;
		article.innerHTML += `${notice.content}`;
		
		var updateATag = updateBtn.firstChild;
		updateATag.href = `./update.html?id=${noticeId}`;
	};
	
	request.open("GET", `./detail?id=${noticeId}`);
	request.send(null);
	
	
	deleteBtn.onclick = function() {
		if(confirm("정말로 삭제하시겠습니까?")) {
			var request = new XMLHttpRequest();
			request.onload = function() {
			};
			request.open("GET", `./delete?id=${noticeId}`);
			request.send(null);
		};
	};

})