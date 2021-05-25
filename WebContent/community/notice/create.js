window.addEventListener("load", function() {
    var main = document.querySelector("#main");
    var fileSelect = main.querySelector(".file-select");
    var inputFile = main.querySelector('input[type=file]');
	var submitBtn = main.querySelector("button[type=submit]");
	
	submitBtn.onclick = function() {
		var title = main.querySelector(".notice-title-create").value;
		var content = main.querySelector("#notice-article-create").value;
		
		if (!title || !content) {
			alert("내용을 입력해주세요.");
			return false;
		} else {
			var request = new XMLHttpRequest();
			request.onload = function() {
				location.href = "./list.html";
			}
			request.open("POST", `./create`);
			request.send(null);
		}
	};


    fileSelect.onclick = function(e) {
        e.preventDefault();
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true,
            'cancelable': true
        });
        inputFile.dispatchEvent(event);
    };

    inputFile.oninput = function() {
        var span = document.createElement("span");
        fileSelect.insertAdjacentElement("afterend", span);
        span.classList.add("file-name");
        span.innerText = inputFile.files[0].name;
    };

})