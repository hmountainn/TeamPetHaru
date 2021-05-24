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
	
	var pet;
	pet = document.querySelector(`.pet-id-${petId.value}`);
	if (pet.classList.contains('d-none')) {
		pet.classList.remove('d-none');	
	}

  }
//수정하기  
  function updatePopup(id){
    console.log("update");
	let inputId = document.querySelector('.hiddenId');
	
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
    console.log("confirmPopup");
	console.log(id);
    document.getElementById(`popup-4-${id}`).classList.toggle("active");
    //if(e.target.contains("cancel"))
    //document.getElementById(`popup-4-${id}`).classList.remove("active");
  }
  //삭제결과팝업
  function resultPopup(id){
    console.log("resultPopup");
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
    var deleteButton = document.querySelector(".delete");
    var cancel = document.querySelector(".cancel");
    
    // deleteButton.onclick = function(e){
    //   var target = e.target;
    //   console.log("삭제버튼눌림");
    //   //삭제여부묻기
    //   document.getElementById("popup-4").classList.toggle("active");
    //   console.log(target);
    // }
    // cancel.onclick =function(e){
    //   console.log("취소버튼눌림");
    //   document.getElementById("popup-4").classList.toggle("active");
    // }

window.addEventListener("load", function() {    
/*-------------------사진업로드----------------------*/
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
})