window.addEventListener("load", function() {
    let main = document.querySelector("#main");
    let fileSelect = main.querySelector(".file-select");
    let inputFile = main.querySelector('input[type=file]');
	let submitBtn = main.querySelector("button[type=submit]");
	
	submitBtn.onclick = function() {
		let title = main.querySelector(".notice-title-create").value;
		let content = main.querySelector("#notice-article-create").value;
		
		if (!title || !content) {
			alert("내용을 입력해주세요.");
			return false;
		} else {
			let request = new XMLHttpRequest();
			request.onload = function() {
			}
			request.open("GET", `./create`);
			request.send(null);
		}
	};


    fileSelect.onclick = function(e) {
        e.preventDefault();
        let event = new MouseEvent("click", {
            'view': window,
            'bubbles': true,
            'cancelable': true
        });
        inputFile.dispatchEvent(event);
    };

    inputFile.oninput = function() {
        let span = document.createElement("span");
        fileSelect.insertAdjacentElement("afterend", span);
        span.classList.add("file-name");
        span.innerText = inputFile.files[0].name;
    };

})