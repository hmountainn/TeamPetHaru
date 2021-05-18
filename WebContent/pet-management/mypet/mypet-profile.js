window.addEventListener("load",function(){
    var deleteBtn = document.querySelector(".delete");


    deleteBtn.onclick = function(e){
       var answer = confirm("반려동물 정보를 삭제 하시겠습니까?")
        if(answer==true){
            alert("삭제되었습니다.")
        }
        
     };

})