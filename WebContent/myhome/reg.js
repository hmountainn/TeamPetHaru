window.addEventListener("load", function() {
	let uploadBox = document.querySelector(".img-upload-box");
    let selButton = document.querySelector(".btn-sel");
    let fileButton = document.querySelector(".btn-file");

	uploadBox.onclick = function() {
		console.log("test");
	}
	
	uploadBox.onclick = function() {
		console.log("test1");
	}

	// 이미지 업로드 DND
	uploadBox.ondragover = function(e) { 
        e.preventDefault(); 
		let dt = e.dataTransfer;        

        var valid = dt.types.indexOf("Files") >= 0; // 배열에 해당 값이 없으면 -1 반환
        if(valid) { // 유효한 데이터일 때
			uploadBox.style.backgroundColor = "rgb(245, 222, 76)";
            // uploadBox.classList.add("valid");
        } else {	
			uploadBox.style.backgroundColor = "rgb(224, 223, 223)";
            // uploadBox.classList.add("invalid");
		} 
    };

	uploadBox.ondrop = function(e) { // 파일은 event 객체에 포함되어 있음
        e.preventDefault(); // 링크를 열지 않게 하기 위해 기본 행위 막기

        /*uploadBox.classList.remove("valid");			
		uploadBox.classList.remove("invalid");*/
		uploadBox.style.backgroundColor = "rgb(224, 223, 223)";
        
        console.log(e.dataTransfer.files[0].name);

		let dt = e.dataTransfer;
		if(dt.files.length > 1) {
			alert("파일은 1개만 업로드 가능합니다.");
			return;	
		}
		
		if(dt.files[0].size > 500*1024*1024) {
			alert("업로드 가능한 파일 크기를 초과했습니다.");
		}
			
		let formData = new FormData(); // 추가되는 데이터마다 파트가 나눠져서 개별적으로 보내짐
		formData.append("p", "/upload/test");
		formData.append("f", dt.files[0]); // 키값은 name값이라고 생각하기
		
		let request = new XMLHttpRequest();
		request.onload = function(e) {
			let filePath = request.responseText;			
			let img = `<img style="width: 270px; height: 270px; border-radius: 10px" src="${filePath}">`;
			
			uploadBox.insertAdjacentHTML("afterbegin", img);	
		};
		
		request.upload.onprogress = function(e) { // request.upload는 진척도 이벤트를 가지고 있음
			console.log(`total: ${e.total}, load: ${e.loaded}`); // e.total: 보내야 할 전체 바이트 수, e.loaded: 올라간 바이트 수
		}
		request.open("POST", "/uploader", true); // UploaderController로 보냄
		request.send(formData);
    };

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