
window.addEventListener("load",function(){
    var section = document.querySelector("#content-wrap");
    var addBtn = section.querySelector(".btn-add");

    addBtn.onclick = function(e){
        var overlay = section.querySelector(".overlay");
        var popup = section.querySelector(".popup-wrapper");
        if(overlay.classList.contains("d-none")&&popup.classList.contains("d-none")){
            overlay.classList.remove("d-none");
            popup.classList.remove("d-none");
        }  
    }

    
});

window.addEventListener("load",function(){
    var popup = document.querySelector(".popup-wrapper");
    var hashtagContainer = popup.querySelector(".hashtag-container");
    
    var selected =null;
    
        hashtagContainer.onclick = function(e){
            var target = e.target;
    
            if(!target.classList.contains("hashtag")){
                return;
            }
            
            if(selected !=null&&target!=selected){
                selected.classList.remove("selected-hashtag");
            }
            selected = target;
            target.classList.toggle("selected-hashtag");
        }

    var closeBtn = popup.querySelector(".close-btn");
    closeBtn = closeBtn.querySelector("img");
    var section = document.querySelector("#content-wrap");

    closeBtn.onclick = function(){
        var overlay = section.querySelector(".overlay");
        var popup = section.querySelector(".popup-wrapper");
        if(!overlay.classList.contains("d-none")&&!popup.classList.contains("d-none")){
            overlay.classList.add("d-none");
            popup.classList.add("d-none");
        }  

    }
});