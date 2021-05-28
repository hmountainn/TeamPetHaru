window.addEventListener("load", function() {
	let section = document.querySelector("#main");
	let searchBtn = section.querySelector("input[type=submit]");
	let tbody = section.querySelector("tbody");
	let pager = section.querySelector(".notice-table-pager");
	let searchForm = section.querySelector(".notice-search-form");
	let fieldBox = searchForm.querySelector("#select-notice-search");
	let queryBox = searchForm.querySelector("input[type=text]");
	let pageElement = pager.querySelector("ul a");
	let sortingBox = section.querySelector("#select-main-sorting");
	let sizingBox = section.querySelector("#select-main-sizing");
	let sort = sortingBox.options[sortingBox.selectedIndex].value;
	let size = sizingBox.options[sizingBox.selectedIndex].value;
	let field = fieldBox.value;
	let query = queryBox.value;
	
	bind(`../../api/notice/list?field=${field}&query=${query}`);
	
	sortingBox.onchange = function() {
		sort = sortingBox.options[sortingBox.selectedIndex].value;
		size = sizingBox.options[sizingBox.selectedIndex].value;
		bind(`../../api/notice/list?sort=${sort}&size=${size}&field=${field}&query=${query}`);
	}
	
	sizingBox.onchange = function() {
		sort = sortingBox.options[sortingBox.selectedIndex].value;
		size = sizingBox.options[sizingBox.selectedIndex].value;
		bind(`../../api/notice/list?sort=${sort}&size=${size}&field=${field}&query=${query}`);
	}

	pager.onclick = function(e) {
		e.preventDefault();

		if (e.target.tagName != "A") {
			return;
		};
		
		let page = e.target.innerText;
		bind(`../../api/notice/list?page=${page}&sort=${sort}&size=${size}&field=${field}&query=${query}`);
		
		pageElement.classList.remove("current-pager");
		e.target.classList.add("current-pager");
		pageElement = e.target;
	};

	searchBtn.onclick = function(e) {
		e.preventDefault();

		field = fieldBox.value;
		query = queryBox.value;
		bind(`../../api/notice/list?field=${field}&query=${query}`);
	};
	
	
	function bind(url) {
		let request = new XMLHttpRequest();

		request.onload = function() {
			let list = JSON.parse(request.responseText);
			
			if (list.length > 0) {
				tbody.innerHTML = "";
				for (let i = 0; i<list.length; i++) {
					let tr = `<tr>
							<td class="table-w50">${list[i].id}</td>
							<td><a name="${list[i].id}" href="./detail.html?id=${list[i].id}">${list[i].title}</a></td>
							<td class="table-w50">${list[i].userId}</td>
							<td class="table-w100">${list[i].regdate}</td>
							<td class="table-w50">${list[i].hit}</td>
	                      </tr>`
					tbody.insertAdjacentHTML("beforeend", tr);
				};
			}
			else {
				let trEmpty = `<tr class="trEmpty">
	                            <td colspan="5">검색된 결과가 없습니다.</td>
	                        </tr>`
				tbody.innerHTML = trEmpty;
			};
		};
		request.open("GET", url);
		request.send(null);
		
		
	};
	
	

})