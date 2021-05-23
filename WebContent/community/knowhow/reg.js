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
	
	// 이미지 업로드하기
	let uploadBox = document.querySelector(".img-upload-box");
    let selButton = document.querySelector(".btn-sel");
    let fileButton = document.querySelector(".btn-file");

	// DND
	uploadBox.ondragover = function(e) { 
        e.preventDefault(); 
        
        var valid = e.dataTransfer.types.indexOf("Files") >= 0 // 배열에 해당 값이 없으면 -1 반환

        if(!valid) // 유효하지 않은 데이터일 때
            uploadBox.style.backgroundColor = "rgb(224, 223, 223)";
        else 
            uploadBox.style.backgroundColor = "#ffe680";

    }

	uploadBox.ondrop = function(e) { // 파일은 event 객체에 포함되어 있음
        uploadBox.style.backgroundColor = "rgb(224, 223, 223)";
        e.preventDefault(); // 링크를 열지 않게 하기 위해 기본 행위 막기
        
        console.log(e.dataTransfer.files[0].name);
    }

	// 버튼 클릭해서 업로드
	selButton.onclick = function(e) {
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true, // 이벤트 버블링: true
            'cancelable': true
        });

       fileButton.dispatchEvent(event); // 이벤트 위임 - fileButton에게 이벤트가 발생했다고 알려주는 것: 트리거
    }
});


