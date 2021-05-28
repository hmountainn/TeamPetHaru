window.addEventListener("load", function() {
	let petInput = document.querySelector(".pet-selecting-btn>input");
	let dogBtn = document.querySelectorAll(".pet-selecting-btn>span")[0];
	let catBtn = document.querySelectorAll(".pet-selecting-btn>span")[1];
	let uploadBox = document.querySelector(".img-upload-box");
    let selButton = document.querySelector(".btn-sel");
    let fileButton = document.querySelector(".btn-file");

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
	};
	
	fileButton.oninput = function(e) { // 파일 등록버튼 선택
		let file = fileButton.files[0]; // 파일에 대한 정보만 가져온 상태
		console.log(file);
		if(file.type.indexOf("image/") < 0)
			alert("이미지 형식만 사용할 수 있습니다");
			
		// 선택된 파일을 메모리에 올릴 수 있음, 로컬에 파일 로드 가능
		// 웹(원격)이라는 브라우저는 로컬의 문서에 접근하지 못함
		var reader = new FileReader(); // 파일 읽어오기 가능, Reader 하나당 파일 하나 읽기 가능
		reader.onload = function(evt) { // 아직 원격에 올라간 거 아닌데도 웹에서 이미지 보기 가능
			let img = document.createElement("img");
			img.style.width = "270px";
			img.style.height = "270px";
			img.style.borderRadius = "10px";
			img.src = evt.target.result; 	
			uploadBox.insertAdjacentElement("afterbegin", img);
		}
	
		reader.readAsDataURL(file); // 비동기로 읽어옴, 위 코드가 바로 진행되지 않게 onload 이벤트에 넣어주기	
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
		request.open("POST", "/uploader", true);
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


