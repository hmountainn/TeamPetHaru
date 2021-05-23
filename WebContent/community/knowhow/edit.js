window.addEventListener("load", function() {
	
	let petInput = document.querySelector(".pet-selecting-btn>input");
	let dogBtn = document.querySelectorAll(".pet-selecting-btn>span")[0];
	let catBtn = document.querySelectorAll(".pet-selecting-btn>span")[1];

	// select라는 클래스를 가지는 태그의 name 속성과 p값 추가하기
	dogBtn.onclick = function(e) {
		catBtn.classList.remove("select");		
		dogBtn.classList.add("select");	
		petInput.removeAttribute('value', '고양이');
		petInput.setAttribute('value', '강아지');
	}
	
	catBtn.onclick = function(e) {
		dogBtn.classList.remove("select");		
		catBtn.classList.add("select");	
		petInput.removeAttribute('value', '강아지');
		petInput.setAttribute('value', '고양이');
	}
	
});


