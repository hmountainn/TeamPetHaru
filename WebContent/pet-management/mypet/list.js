//종류묻기
function askPet(){
  console.log("askPet");
  document.getElementById("popup-6").classList.toggle("active");
}

//등록하기
  function addPopup(){
    console.log("addPopup");
    document.getElementById("popup-3").classList.toggle("active");

  }

//상세보기 popup-3-1
  function togglePopup(id){
    console.log("profile");
	console.log(id);
    document.getElementById(`popup-1-${id}`).classList.toggle("active");
	let petId = document.querySelector('#petId');
	
	if(id) 
	petId.value = `${id}`;
	console.log(petId.value);
	
	let pet;
	pet = document.querySelector(`.pet-id-${petId.value}`);
	if (pet.classList.contains('d-none')) {
		pet.classList.remove('d-none');	
	}

  }
//수정하기  
  function updatePopup(id){
    console.log("update");
	const inputId = document.querySelector('.hiddenId');
	
	console.log(inputId.value);
	
	inputId.value=id;
	
    document.getElementById(`popup-2-${id}`).classList.toggle("active");
    document.getElementById(`popup-1-${id}`).classList.remove("active");
	/*let petId = document.querySelector('#petId');
	let pet;
	pet = document.querySelector(`.pet-id-${petId.value}`);
	pet.classList.toggle('d-none');*/
  }
//삭제확인팝업
  function confirmPopup(id){
	//event.preventDefault();
    console.log("confirmPopup");
	console.log(id);
    document.getElementById(`popup-4-${id}`).classList.toggle("active");
    //if(e.target.contains("cancel"))
    //document.getElementById(`popup-4-${id}`).classList.remove("active");
  }
  //삭제결과팝업
  function resultPopup(id){
    console.log("resultPopup");
	location.href = `del?id=${n.id}`;
    document.getElementById(`popup-1-${id}`).classList.remove("active");
    document.getElementById(`popup-4-${id}`).classList.remove("active");
    document.getElementById(`popup-5-${id}`).classList.toggle("active");
  }

/*
  window.addEventListener("load",function(){
	var petList = document.querySelector('.pet-list');
	console.log(petList);
	
	bind("http://localhost:8080/api/pet-management/mypet/list");
	
	function bind(url) {
		var request = new XMLHttpRequest();

		request.onload = function() {
			
			//자식지우는 트릭
			petList.innerHTML = "";
			//새로운목록채우는코드
			var list = JSON.parse(request.responseText);
			console.log(request.responseText);
			for (var i = 0; i < list.length; i++) {
				var divBox =`<div class="box">
                      <a class="" href="">
                          <div class="img-box"><img src="https://static.parastorage.com/services/instagram-cdn/1.691.0/assets/ig-templates-accounts/Editor/Dogs%20Apparel/03.jpg"></div>
                       </a>
                          <div class="diary-content">
                              <h4>${list[i].name}</h4>
                                 <div class="button detail-btn" id="detail-button"onclick="togglePopup()" >
                                  상세보기
                                  </div>
                            </div><!--diary-content-->
                     </div><!--box--> `;
				
				petList.insertAdjacentHTML("beforeend",divBox);
			}
			
		}//onload
		request.open("GET", url, true);//false 동기
		request.send(null);
	}	
	

    /*---------------반려 동물 삭제---------------------*/
    const deleteButton = document.querySelector(".delete");
    const cancel = document.querySelector(".cancel");


window.addEventListener("load", function() {    
/*-------------------사진업로드----------------------*/
	const uploadBox = document.querySelector("#upload-box");
	const uploadBox2 = document.querySelector("#upload-box2");
	const fileInput = document.querySelector(".form input[type='file']");
	const fileInput2 = document.querySelector("#upload-box2 input[type='file']");
//	const progressStatusDiv = document.querySelector(".progress-status");
	var fileButton = document.querySelector(".file-button"); //가 실행
	var fileTriggetButtons = document.querySelectorAll(".file-trigger-button");//가 클릭되지만
console.log(fileTriggetButtons);

	for(let i = 0; i < fileTriggetButtons.length; i++) {
		fileTriggetButtons[i].onclick = function() {
			var event = new MouseEvent("click", {
				'view': window,
				'bubbles': true,
				'cancelable': true
			});
			fileButton.dispatchEvent(event);//이벤트전달
		};	
	}
	
	console.log(fileButton);
	fileButton.oninput = function(e){
		let file = fileButton.files[0];
		if(file.type.indexOf("image/") <0)
			alert("이미지 형식만 사용 할 수 있습니다.");
		//미리보기	
		var reader = new FileReader();
		reader.onload = function(evt){
			let img = document.createElement("img");
			img.src = evt.target.result;
			
			fileInput.insertAdjacentElement("afterend",img);
		};
		reader.readAsDataURL(file);
	}
	
	uploadBox.ondragenter = function(){
		console.log("enter");
	}
	
	uploadBox.ondragleave = function(){
		console.log("leave");
		uploadBox.classList.remove("valid");
		uploadBox.classList.remove("invalid");
	}
	
	uploadBox.ondragover = function(e){
		e.preventDefault();
		//파일형식
		var valid = e.dataTransfer.types.indexOf("Files") >= 0;
		
		if(valid){
			uploadBox.classList.add("valid");
		}
		else{
			uploadBox.classList.add("invalid");
		}
		
		console.log("over");
	}
	
	uploadBox.ondrop = function(e){
		console.log("uploadBox");
		e.preventDefault();
		
		uploadBox.classList.remove("valid");//파일형식
		uploadBox.classList.remove("invalid");		
		
		let dt = e.dataTransfer;//드래그 앤 드롭 조작을 통해 데이터를 전달
		if(dt.files.length>1){
			alert("파일은 하나씩만 전송이 가능합니다.");
			return;
		};
		if(dt.files[0].size > 50*1024*1024){
			alert("죄송합니다. 50MByte를 넘는 파일은 전송 할 수 없습니다.");
			return;
		};
		//페이지 전환 없이 폼 데이터를 제출하고 싶을 때 바로 FormData 객체를 사용
		let formData = new FormData();
		formData.append("p","/upload");
		formData.append("f",dt.files[0]);
		//파일경로
		let request = new XMLHttpRequest();
		request.onload = function(e){
			console.log(request.responseText);
			let filePath = request.responseText;
			let img = `<img style="width: 340px; height: 340px; border-radius: 5px" src="${filePath}">`;
			
			uploadBox.insertAdjacentHTML("afterbegin", img);
			console.log("DND완료");
		};
			request.upload.onprogress = function(e) { // request.upload는 진척도 이벤트를 가지고 있음
			console.log(`total: ${e.total}, load: ${e.loaded}`); // e.total: 보내야 할 전체 바이트 수, e.loaded: 올라간 바이트 수
		}
		
		request.open("POST","/uploader",true);//업로드콘트롤러연결
		request.send(formData);		
		console.log("drop");
	};	


})