window.addEventListener("load", function() {
	var section = document.querySelector("#main");
	var searchBtn = section.querySelector("input[type=submit]");
	var tbody = section.querySelector("tbody");
	var pager = section.querySelector(".notice-table-pager");
	var searchForm = section.querySelector(".notice-search-form");
	var fieldBox = searchForm.querySelector("#select-notice-search");
	var queryBox = searchForm.querySelector("input[type=text]");
	var pageElement = pager.querySelector("ul a");
	
	bind(`../../api/notice/list`);

	pager.onclick = function(e) {
		e.preventDefault();

		if (e.target.tagName != "A") {
			return;
		};
		
		var page = e.target.innerText;
		bind(`../../api/notice/list?page=${page}`);
		
		pageElement.classList.remove("current-pager");
		e.target.classList.add("current-pager");
		pageElement = e.target;
	};

	searchBtn.onclick = function(e) {
		e.preventDefault();

		var field = fieldBox.value;
		var query = queryBox.value;
		bind(`../../api/notice/list?field=${field}&query=${query}`);
	};
	
	
	function bind(url) {
		var request = new XMLHttpRequest();

		request.onload = function() {
			var list = JSON.parse(request.responseText);
			
			if (list.length > 0) {
				tbody.innerHTML = "";
				for (var i = 0; i<list.length; i++) {
					var tr = `<tr>
							<td class="table-w50">${list[i].id}</td>
							<td><a name="${list[i].id}" href="./detail.html?id=${list[i].id}">${list[i].title}</a></td>
							<td class="table-w50">${list[i].adminId}</td>
							<td class="table-w100">${list[i].regDate}</td>
							<td class="table-w50">${list[i].hit}</td>
	                      </tr>`
					tbody.insertAdjacentHTML("beforeend", tr);
				};
			}
			else {
				var trEmpty = `<tr class="trEmpty">
	                            <td colspan="5">검색된 결과가 없습니다.</td>
	                        </tr>`
				tbody.innerHTML = trEmpty;
			};
		};
		request.open("GET", url);
		request.send(null);
		
		
	};
	
	

})