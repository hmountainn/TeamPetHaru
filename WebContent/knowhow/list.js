window.addEventListener("load", function() {
	
	let dogBtn = document.querySelectorAll(".pet-selecting-btn>button")[0];
	let catBtn = document.querySelectorAll(".pet-selecting-btn>button")[1];

	// 클릭한 버튼에 스타일 입히기
	dogBtn.onclick = function(e) {
		catBtn.classList.remove("select");		
		dogBtn.classList.add("select");	
	}
	
	catBtn.onclick = function(e) {
		dogBtn.classList.remove("select");		
		catBtn.classList.add("select");	
	}
	
	// 목록 데이터 불러오기
	/*var knowhowList = document.querySelector(".knowhow-list");
	
	bind("http://localhost:8080/PetharuPrj/api/knowhow/list");
	
	function bind(url) {
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
                        				<span>${list[i].like}</span>
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
                                <span class="id">${list[i].userId}</span>
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