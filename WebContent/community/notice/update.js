window.addEventListener("load", function() {
    var main = document.querySelector("#main");
	var titleBox = main.querySelector(".notice-title-update");
	var contentBox = main.querySelector("#notice-article-update");
	var hiddenId = main.querySelector("input[type=hidden]");
    var fileSelect = main.querySelector(".file-select");
    var inputFile = main.querySelector('input[type=file]');
	var submitBtn = main.querySelector("button[type=submit]")
	
	
	let params = new URLSearchParams(window.location.search);
	let noticeId = parseInt(params.get("id"));
	var request = new XMLHttpRequest();
	request.onload = function() {
		var notice = JSON.parse(request.responseText);
		titleBox.value = `${notice.title}`;
		contentBox.value = `${notice.content}`;
		hiddenId.value = `${noticeId}`;
	};
	request.open("GET", `./detail?id=${noticeId}`);
	request.send(null);
	
	
	
	submitBtn.onclick = function() {
		var request = new XMLHttpRequest();
		request.onload = function() {
			
		}
		request.open("GET", `./update?id=${noticeId}`);
		request.send(null);
	}


    fileSelect.onclick = function(e) {
        e.preventDefault();
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true,
            'cancelable': true
        });
        inputFile.dispatchEvent(event);
    }

    inputFile.oninput = function() {
        var span = document.createElement("span");
        fileSelect.insertAdjacentElement("afterend", span);
        span.classList.add("file-name");
        span.innerText = inputFile.files[0].name;
    }

})