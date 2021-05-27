window.addEventListener("load", function() {
    let main = document.querySelector("#main");
    let inputFile = main.querySelector('input[type=file]');
	let submitBtn = main.querySelector("button[type=submit]");
	let thumbnailDiv = main.querySelector(".thumbnail");
	let filePath = "";
	
	submitBtn.onclick = function() {
		let title = main.querySelector(".notice-title-create").value;
		let content = main.querySelector("#notice-article-create").value;
		
		if (!title || !content) {
			alert("내용을 입력해주세요.");
			return false;
		} else {
			let request = new XMLHttpRequest();
			request.onload = function() {
			}
			request.open("GET", `./create`);
			request.send(null);
		}
	};

    inputFile.oninput = function(e) {
        let file = inputFile.files[0];
		if(file.type.split("/")[0] != "image") {
			alert("이미지 파일만 첨부할 수 있습니다.");
			inputFile.value = "";
		}
		
		let reader = new FileReader(); //파일 리더기
		reader.onload = function(event) { //동기적으로 처리하기 위해 파일이 읽어지면 실행되는 이벤트 onload 사용
			let img = document.createElement("img");
			img.src = event.target.result;
			thumbnailDiv.insertAdjacentElement("afterbegin", img);
		}
		reader.readAsDataURL(file);
		
		let formData = new FormData();
		formData.append("file", file);
		formData.append("path", "/community/notice/upload");
		
		let request = new XMLHttpRequest();
		request.onload = function() {
			filePath = request.responseText;
		}
		request.open("POST", "./upload");
		request.send(formData);
    };

})