window.addEventListener("load", function() {
	let knowhowList = document.querySelector(".knowhow-list");
	let dogBtn = document.querySelectorAll(".pet-selecting-btn>a")[0];
	let dogBtnText = document.querySelectorAll(".pet-btn-text")[0];
	let catBtn = document.querySelectorAll(".pet-selecting-btn>a")[1];
	let catBtnText = document.querySelectorAll(".pet-btn-text")[1];


	// 클릭한 버튼에 스타일 입히기
	dogBtn.onclick = function(e) {		
		catBtn.classList.remove("select-bg");		
		catBtnText.classList.remove("select-t")
		dogBtn.classList.add("select-bg");	
		dogBtnText.classList.add("select-t")
	}
	
	catBtn.onclick = function(e) {		
		dogBtn.classList.remove("select-bg");	
		dogBtnText.classList.remove("select-t")	
		catBtn.classList.add("select-bg");
		catBtnText.classList.add("select-t")
	}
		
	
	// 목록 데이터 불러오기
/*	bind("http://localhost:8080/api/knowhow/list");
*/	
	
	/*function bind(url) {
		var request = new XMLHttpRequest();
		
		request.onload = function() {
			
			var list = JSON.parse(request.responseText);
			
			for(var i=0; i<list.length; i++) {
				var div = 
					`<div>
                        <div class="img-area">
                            <a href="detail.html?id=${list[i].id}">
                            <img class="img-pet" src="../images/cat-rest1.jpg">
                            </a>
                        </div>
                        <div class="text-area">
                        	<div class="knowhow-info">
                        		<ul>
                        			<li>
                        				<img src="../images/view.png">
                        				<span>${list[i].hit}</span>
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
                        	</div>
                            <div class="knowhow-title"><a href="detail.html?id=${list[i].id}">${list[i].title}</a></div>
                            <section class="flex">
                                <div class="img-member"></div>
                                <span class="id">${list[i].memberId}</span>
                            </section>
                        </div>
                     </div>`;
				
				knowhowList.insertAdjacentHTML("beforeend", div);
			}
			
		}
		
		request.open("GET", url, true);
		request.send(null);
	}*/
	
});