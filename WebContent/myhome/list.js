window.addEventListener("load", function() {
	let section = document.querySelector("#main");
	let body = document.querySelector("#body")
	let memberInfo = section.querySelector(".member-info");
	let diaryList = section.querySelector(".diary-list");
	let pager = section.querySelector(".pager");
	let pageNum = pager.querySelector("ul a")

	bind(`../../api/diary/list`);
	
	pager.onclick = function(e) {	
		e.preventDefault();
			
		if(e.target.tagName != "A")
			return;

		let page = e.target.innerText;
		bind(`../../api/diary/list?page=${page}`);
		
		pageNum.classList.remove("text-strong");
		e.target.classList.add("text-strong");
		pageNum = e.target;
	}
	
	function bind(url) {
		let request = new XMLHttpRequest();
		
		request.onload = function() {
			let list = JSON.parse(request.responseText);
			
			if(list.length > 0) {
				memberInfo.innerHTML = "";
				diaryList.innerHTML = "";
				
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
				
				for(let i=0; i<list.length; i++) {
					let diaryContent = 
					    `<div>
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
					
					diaryList.insertAdjacentHTML("beforeend", diaryContent);
				}
			} else {
				let empty = `<p>검색된 결과가 없습니다<p>`
				diaryList.innerHTML = empty;
			}
		}
		
		request.open("GET", url, true);
		request.send(null);
	}
	
	
    let background = document.querySelector(".black-bg");
	let detailSection = document.querySelector(".detail-section");
	let closeBtn = document.querySelector(".close-btn");
	
	diaryList.onclick = function(e) {
		if(!e.target.classList.contains("img-pet") && !e.target.classList.contains("diary-content"))
            return;

		background.classList.remove("d-none");
		detailSection.classList.remove("d-none");
	}
	
	closeBtn.onclick = function(e) {
		e.preventDefault();

		background.classList.add("d-none");
		detailSection.classList.add("d-none");
	}

	
	let header = document.querySelector("#header");
    let modal = document.querySelector(".modal");
    let deleteBtn = document.querySelector(".delete-btn");

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
});