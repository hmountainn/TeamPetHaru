window.addEventListener("load", function() {
	makeCalendar();
	//addSchedule();
	detailSchedule();
});

function getSchedule() {

	var request = new XMLHttpRequest();
	request.onload = function(e) {
		var list = JSON.parse(request.responseText);
		//console.log(request.responseText);
		console.log(list);
		for (var i = 0; i < list.length; i++) {
			var day = list[i].dateTime;
			day = parseInt(day.substring(8, 10));
			//console.log(day);
			var td = document.getElementById(day);

			switch (list[i].scheduleTypeName) {
				case "진료":
					var div = `<div class="id d-none">${list[i].id}</div><div class="schedule" style="background-color:#F5A9A9">${list[i].title}</div>`
					break;
				case "접종":
					var div = `<div class="id d-none">${list[i].id}</div><div class="schedule" style="background-color:#58ACFA">${list[i].title}</div>`
					break;
				case "미용":
					var div = `<div class="id d-none">${list[i].id}</div><div class="schedule" style="background-color:#C0CA33">${list[i].title}</div>`
					break;
				case "기타":
					var div = `<div class="id d-none">${list[i].id}</div><div class="schedule" style="background-color:#9fa6ad">${list[i].title}</div>`
					break;
			}
			td.insertAdjacentHTML("beforeend", div);
		}
	}
	//parameter로 month줘야함 user_id도...
	let month = document.querySelector(".current-year-month");
	month = month.innerText;
	month = month.substring(5, month.length);
	month = Number(month);
	console.log("month:" + month);
	let memberId = 1;
	request.open("GET", `../api/schedule/list?m=${month}&member=${memberId}`, true); //false면 동기, true면 비동기
	request.send(null);
}

function makeCalendar() {
	calendar = document.querySelector(".calendar");
	//calendar테이블을 변수로 정의
	row = calendar.insertRow();
	row.classList.add("first-week");
	row.classList.add("week");
	//calendar에 행을 추가해준다.
	//변수명(row)을 지정해주는 이유 : 후에 cell이 추가될 자리를 알려주기 위해
	for (i = 0; i < firstDay; i++) {
		//first_day에 해당하는 요일까지 열을 만든다.	
		//요일은 0부터 시작하기 때문에 i값도 0에서 시작한다.
		cell = row.insertCell();
		// cell.innerHTML = "HI";
	}


	for (i = 1; i <= lastDate; i++) {
		// 달력은 1일부터 시작하므로 i=1
		if (firstDay != 7) {
			//first_day는 0~6이다. 일주일은 한 줄에 7칸이니까 7이상은 찍히지 않는다.
			cell = row.insertCell();
			//셀추가
			cell.setAttribute('id', [i]);
			cell.classList.add("day");
			//모든 셀에 id를 부여함
			cell.innerHTML = "<div class=\"number\">" + [i] + "</div>";
			//추가된 셀에 i값 입력
			firstDay += 1;
			//요일값이 하루 추가된걸 for문에 알려줌
		}
		else {
			//첫줄의 first_day 값이 7이되면 작동
			row = calendar.insertRow();
			row.classList.add("week");
			//행을 하나 추가
			cell = row.insertCell();
			cell.setAttribute('id', [i]);
			cell.innerHTML = "<div class=\"number\">" + [i] + "</div>";
			//세줄은 위와 같음
			firstDay = firstDay - 6;
			//6을 빼는 이유는 매번 7에서 else문으로 넘어오고, if문이 6번만 하면 되기때문이다.
			//7을 빼버리면 0부터 시작해서 if문이 7번 실행되고 else로 넘어오므로 -6을한다.
		}
	}

	//오늘날짜표시(함수로 빼야함)
	var todayDate = today.getDate();
	var todayYear = today.getFullYear();
	var todayMonth = today.getMonth() + 1;
	var todayYM = todayYear + "." + todayMonth;
	// console.log(todayYM);
	// console.log(currentYM.innerText);

	lastDate = new Date(year, month + 1, 0, 0, 0, 0, 0).getDate();//이번달의 마지막날
	//console.log("lastdate"+lastDate);
	for (i = 1; i <= lastDate; i++) {
		//console.log(i);
		var date = document.getElementById([i]);
		//console.log("date:"+date);
		if (todayDate == date.getAttribute("id") && todayYM == currentYM.innerText) {
			datediv = date.querySelector("div");
			//console.log("datediv:"+datediv);
			datediv.classList.add("today");
			//console.log("hi");
		}

	}

	getSchedule();
}
/*
window.addEventListener("load",function(){//오늘날짜표시
	var todayDate = today.getDate();
	var todayYear = today.getYear();
	var todayMonth = today.getMonth();
	var todayYM = todayYear+"."+todayMonth;
    
	for(i=1; i<=lastDate; i++){
		var date = document.getElementById([i]);
		if(todayDate == date.getAttribute("id") && todayYM==currentYM){
			datediv = date.querySelector("div");
			datediv.classList.add("today");
		}
	    
	}

});*/

//이전버튼
window.addEventListener("load", function() {
	var prevBtn = document.querySelector(".prev-month");
	prevBtn.onclick = function() {
		while (calendar.rows.length > 2) {
			//2줄이 남을 때 까지 줄을 지워줌
			//버튼과 요일이 남아야 하기 때문에 2줄만 남기고 지운다.
			calendar.deleteRow(calendar.rows.length - 1);
			//length-1 = 아래서부터 지우라는 뜻
		}
		month = month - 1
		//한달씩 뒤로감
		if (month === -1) {
			//0월이 되었을 때 이전연도 12월로 가도록 작업
			//js에서 0월 = 실제 1월 이므로 -1로 맞춰야한다.
			year = year - 1;
			month = month + 12;
		}
		YM = year + "." + (month + 1);
		currentYM.innerHTML = YM;
		firstDate = new Date(year, month, 1).getDate();
		lastDate = new Date(year, month + 1, 0).getDate();
		firstDay = new Date(year, month, 1).getDay();
		makeCalendar();
	}
});

//다음달버튼
window.addEventListener("load", function() {
	var nextBtn = document.querySelector(".next-month");
	nextBtn.onclick = function() {
		while (calendar.rows.length > 2) {
			calendar.deleteRow(calendar.rows.length - 1);
		}
		month = month + 1
		//한달씩 증가함
		if (month === 12) {
			//13월이 되었을 때 다음연도 1월로 가도록 작업
			//js에서 11월 = 실제 12월 이므로 12로 맞춰야한다.
			year = year + 1;
			month = month - 12;
		}

		YM = year + "." + (month + 1);
		currentYM.innerHTML = YM;
		firstDate = new Date(year, month, 1).getDate();
		lastDate = new Date(year, month + 1, 0).getDate();
		firstDay = new Date(year, month, 1).getDay();
		makeCalendar();
	}
});



/*function addSchedule(){
	
	var calendar = document.querySelector(".calendar");
	var day = document.getElementById("15");
	console.log(day);
	var div = document.createElement("div");
	div.classList.add("schedule")
	div.innerText = "15:30 진료";
	div.style.backgroundColor="#F5A9A9";
	day.append(div);
}*/


function detailSchedule() {
	var section = document.querySelector("#content-wrap");
	var calendar = section.querySelector(".calendar");
	var scheduleDetail = section.querySelector(".schedule-detail");

	//console.log(scheduleDetail);
	calendar.onclick = function(e) {
		var target = e.target;
		//console.log(target);
		if (target.classList.contains("schedule")) {
			scheduleDetail.classList.remove("d-none");
			let scheduleId = target.previousSibling.innerText;
			console.log(scheduleId);
			detailBind(scheduleId);

		} else {
			return;
		}
	}

}
function detailBind(scheduleId) {
	let request = new XMLHttpRequest();
	let scheduleDetail = document.querySelector(".schedule-detail");
	request.onload = function(e) {
		scheduleDetail.innerHTML="";
		//스케줄 get해서 그거 안에있는거 html 적어서 넣기
		let schedule = JSON.parse(request.responseText);
		let dateTime = schedule.dateTime;
		let day = parseInt(dateTime.substring(8, 10));
		let time = dateTime.substring(11);
		console.log(schedule);
		
		let div = `<div class="detail-date-day">
                                <span class="detail-date">
                                    ${day}
                                </span>
                                
                            </div>
                            <div class="detail-hashtag-content">
                                <div class="detail-hashtag">
                                    # ${schedule.scheduleTypeName}
                                </div>
                                <div class="detail-content">
                                    ${time} ${schedule.content}
                                </div>
                            </div>
                            <div class="detail-buttons">                              
								<a href="edit?id=${scheduleId}">수정 | </a>
                   
                                <a href="del?id=${scheduleId}" onclick="if(!confirm('삭제하시겠습니까?'))return false;"> 삭제</a>                 		
                            </div>`

	scheduleDetail.insertAdjacentHTML("beforeend", div);	
	}
	//parameter로 month줘야함 user_id도...
	
	request.open("GET", `/pet-manager/schedule/detail?id=${scheduleId}`, true); //false면 동기, true면 비동기
	request.send(null);
}