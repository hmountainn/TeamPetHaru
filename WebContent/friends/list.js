// Popup
window.addEventListener("load",function(){
  /*------follow&following----- */
  let followers = document.querySelector('.followers');
  let following  = document.querySelector('.following');
  let outlinePopup = document.querySelector('.outline-popup');
  let selected = null;
  let listBox = document.querySelector(".list-box");
  let buttons = listBox.querySelectorAll(".button");
  let num = listBox.querySelector(".num");
     
  
  /*---------requests------------*/  
  let requests = document.querySelector(".requests");
  
  requests.onclick = function(){
    document.getElementById("popup-3").classList.add("active");
  };
  /*---------Accept & decline---------*/
  const acceptBtn = document.querySelector(".accept");
  const declineBtn = document.querySelector(".decline");
  
  /*------------follower pop up-----------*/
  followers.onclick = function(){
    document.getElementById("popup-1").classList.add("active");
  };
  /*---------refollow , unfollow------------*/
  outlinePopup.onclick = function(e){
    console.log("outline-popup");
    
    let target = e.target;
    selected = e.target;
    
    //closing pop up
    if(target.parentNode.parentNode.classList.contains("popup")){
      target.parentNode.parentNode.classList.remove("active");
      
    }
    //unfollow
    else if(target.classList.contains("button")){
      if(selected.classList.contains("unfollow")){
        selected.classList.remove("unfollow");
        console.log("refollowing");
        selected.innerText="Following";
      }else{
        console.log("unfollow");
        selected.innerText="Follow";
        selected.classList.add("unfollow");
        
      }
    }
    /*-------------refollow , unfollow-----------------*/
    else if(target.classList.contains("accept")){
      console.log("Accepted")
      selected.innerText = 'Accepted';
    }
    else if(target.classList.contains("decline")){
      console.log("Declined")
      selected.innerText = 'Declined';
    }
    
  };
  
  //following pop up
  following.onclick = function(){
    console.log("following");
    document.getElementById("popup-2").classList.add("active");
  };
  
  /*----------------showDiary--------------------------*/ 
  let bigBox = document.querySelector(".big-box");
  
  bigBox.onclick = function(e){
    console.log(e.target)
    e.preventDefault();
    

      if(e.target.classList.contains("diary-img")){    
        let showDiary = e.target.parentNode.parentNode.querySelector(".showDiary")
      console.log(showDiary);
      showDiary.classList.toggle("active"); 
    }
    if(e.target.classList.contains("close-btn")){
      let showDiary = e.target.parentNode.parentNode
      showDiary.classList.toggle("active");    
      console.log(e.target);

    }




  }//bixbox

  timeBefore();
  function timeBefore(){
      //현재시간을 가져옴
      let now = new Date(); 
      console.log(now);
      
      //글쓴 시간 
      let writeDay = new Date('2021-05-27 01:15');
     //또는 파라미터로 시간을 넘겨받아서 계산할 수도 있음..
      
      
     let minus;
      //현재 년도랑 글쓴시간의 년도 비교 
      if(now.getFullYear() > writeDay.getFullYear()){
          minus= now.getFullYear()-writeDay.getFullYear();
          //두개의 차이를 구해서 표시
          document.getElementsByClassName("sub")[0].innerHTML = minus+"년 전";
          console.log(minus+"년 전");
      }else if(now.getMonth() > writeDay.getMonth()){
      //년도가 같을 경우 달을 비교해서 출력
          minus= now.getMonth()-writeDay.getMonth();
          document.getElementsByClassName("sub")[0].innerHTML = minus+"달 전";
          console.log(minus+"달 전");
      }else if(now.getDate() > writeDay.getDate()){
       //같은 달일 경우 일을 계산
          minus= now.getDate()-writeDay.getDate();
          document.getElementsByClassName("sub")[0].innerHTML = minus+"일 전";
          console.log(minus+"일 전");
      }else if(now.getDate() == writeDay.getDate()){
      //당일인 경우에는 
          let nowTime = now.getTime();
          let writeTime = writeDay.getTime();
          if(nowTime>writeTime){
          //시간을 비교
              sec =parseInt(nowTime - writeTime) / 1000;
              day  = parseInt(sec/60/60/24);
              sec = (sec - (day * 60 * 60 * 24));
              hour = parseInt(sec/60/60);
              sec = (sec - (hour*60*60));
              min = parseInt(sec/60);
              sec = parseInt(sec-(min*60));
              if(hour>0){
              //몇시간전인지
                  document.getElementsByClassName("sub")[0].innerHTML = hour+"시간 전";
                  console.log(hour+"시간 전");
              }else if(min>0){
              //몇분전인지
                  document.getElementsByClassName("sub")[0].innerHTML = min+"분 전";
                  console.log(min+"분 전");
              }else if(sec>0){
              //몇초전인지 계산
                  document.getElementsByClassName("sub")[0].innerHTML = sec+"초 전";
                  console.log(sec+"초 전");
              }
          }
      }
  }


})

//기존검색 :로컬스토리지 - 자바스크립트 
//신규검색 :서버
