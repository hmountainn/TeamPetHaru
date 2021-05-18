window.addEventListener("load",function(){
    var listBox = document.querySelector(".list-box");
    var buttons = listBox.querySelectorAll(".button");
    var num = listBox.querySelector(".num");

    var selected = null;

    listBox.onclick = function(e){
       if(!e.target.classList.contains("button"))//클래스명이 box 포함됐는지 
            return;     
        selected = e.target;
        selected.innerText="follow";
        console.log(selected);
        selected.classList.toggle("selected");

        if(!e.target.classList.contains("selected"))
            selected.innerText="following";

    };
})



