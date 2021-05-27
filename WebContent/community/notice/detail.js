window.addEventListener("load", function() {
	let section = document.querySelector("#main");
	let title = section.querySelector("h1");
	let id = section.querySelector(".notice-info .id");
	let userId = section.querySelector(".notice-info .user-id");
	let regdate = section.querySelector(".notice-info .reg-date");
	let hit = section.querySelector(".notice-info .hit");
	let article = section.querySelector(".notice-article div")
	let upPager = section.querySelector(".article-pager .up-article-pager");
	let downPager = section.querySelector(".article-pager .down-article-pager");
	let updateBtn = section.querySelector(".article-button .update-btn");
	let deleteBtn = section.querySelector(".article-button .delete-btn");
	let thumbnail = section.querySelector(".thumbnail");
	let img = thumbnail.querySelector("img")

	let params = new URLSearchParams(window.location.search);
	let noticeId = parseInt(params.get("id"));
	
	let request = new XMLHttpRequest();
	request.onload = function() {
		let notice = JSON.parse(request.responseText);
		title.innerHTML += `${notice.title}`;
		id.innerHTML += `${notice.id}`;
		userId.innerHTML += `${notice.userId}`;
		regdate.innerHTML += `${notice.regdate}`;
		hit.innerHTML += `${notice.hit}`;
		article.innerHTML += `${notice.content}`;
		
		if (`${notice.files}` != "undefined") {
			thumbnail.href = `/community/notice/upload/${notice.files}`;
			img.src = `/community/notice/upload/${notice.files}`;
		}
		
		if (`${notice.upId}` == 0) {
			
			upPager.innerHTML = `<span>▲ 다음글</span>
                            <div>다음글이 없습니다.</div>`
			downPager.innerHTML = `<span>▼ 이전글</span>
                            <div><a href="./detail.html?id=${notice.downId}">${notice.downTitle}</a></div>`

		} else if (`${notice.downId}` == 0) {
			
			upPager.innerHTML = `<span>▲ 다음글</span>
                            <div><a href="./detail.html?id=${notice.upId}">${notice.upTitle}</a></div>`
			downPager.innerHTML = `<span>▼ 이전글</span>
                            <div>이전글이 없습니다.</div>`

		} else {
			
			upPager.innerHTML = `<span>▲ 다음글</span>
	                            <div><a href="./detail.html?id=${notice.upId}">${notice.upTitle}</a></div>`
			downPager.innerHTML = `<span>▼ 이전글</span>
	                            <div><a href="./detail.html?id=${notice.downId}">${notice.downTitle}</a></div>`

		}
		
		let updateATag = updateBtn.firstChild;
		updateATag.href = `./update.html?id=${noticeId}`;
	};
	
	request.open("GET", `./detail?id=${noticeId}`);
	request.send(null);
	
	
	deleteBtn.onclick = function(e) {
		if(confirm("정말로 삭제하시겠습니까?")) {
			let request = new XMLHttpRequest();
			request.onload = function() {
				location.href = "./list.html";
			};
			request.open("GET", `./delete?id=${noticeId}`);
			request.send(null);
		} else
			e.preventDefault();
	};

})