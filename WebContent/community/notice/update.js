window.addEventListener("load", function() {
    let main = document.querySelector("#main");
	let titleBox = main.querySelector(".notice-title-update");
	let contentBox = main.querySelector("#notice-article-update");
	let hiddenId = main.querySelector("input[type=hidden]");
    let fileSelect = main.querySelector(".file-select");
    let inputFile = main.querySelector('input[type=file]');
	let submitBtn = main.querySelector("button[type=submit]")
	
	
	let params = new URLSearchParams(window.location.search);
	let noticeId = parseInt(params.get("id"));
	
	let request = new XMLHttpRequest();
	request.onload = function() {
		let notice = JSON.parse(request.responseText);
		titleBox.value = `${notice.title}`;
		contentBox.value = `${notice.content}`;
		hiddenId.value = `${noticeId}`;
	};
	request.open("GET", `./detail?id=${noticeId}`);
	request.send(null);
	
	
	submitBtn.onclick = function() {
		let title = titleBox.value;
		let content = contentBox.value;
		if (!title || !content) {
			alert("내용을 입력해주세요.");
			return false;
		} else {
			let request = new XMLHttpRequest();
			request.onload = function() {
				location.href = `./detail.html?id=${noticeId}`;
			}
			request.open("POST", `./update?id=${noticeId}`);
			request.send(null);
		}
	}


    fileSelect.onclick = function(e) {
        e.preventDefault();
        let event = new MouseEvent("click", {
            'view': window,
            'bubbles': true,
            'cancelable': true
        });
        inputFile.dispatchEvent(event);
    }

    inputFile.oninput = function() {
        let span = document.createElement("span");
        fileSelect.insertAdjacentElement("afterend", span);
        span.classList.add("file-name");
        span.innerText = inputFile.files[0].name;
    }

})