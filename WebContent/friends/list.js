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
      //??????????????? ?????????
      let now = new Date(); 
      console.log(now);
      
      //?????? ?????? 
      let writeDay = new Date('2021-05-27 01:15');
     //?????? ??????????????? ????????? ??????????????? ????????? ?????? ??????..
      
      
     let minus;
      //?????? ????????? ??????????????? ?????? ?????? 
      if(now.getFullYear() > writeDay.getFullYear()){
          minus= now.getFullYear()-writeDay.getFullYear();
          //????????? ????????? ????????? ??????
          document.getElementsByClassName("sub")[0].innerHTML = minus+"??? ???";
          console.log(minus+"??? ???");
      }else if(now.getMonth() > writeDay.getMonth()){
      //????????? ?????? ?????? ?????? ???????????? ??????
          minus= now.getMonth()-writeDay.getMonth();
          document.getElementsByClassName("sub")[0].innerHTML = minus+"??? ???";
          console.log(minus+"??? ???");
      }else if(now.getDate() > writeDay.getDate()){
       //?????? ?????? ?????? ?????? ??????
          minus= now.getDate()-writeDay.getDate();
          document.getElementsByClassName("sub")[0].innerHTML = minus+"??? ???";
          console.log(minus+"??? ???");
      }else if(now.getDate() == writeDay.getDate()){
      //????????? ???????????? 
          let nowTime = now.getTime();
          let writeTime = writeDay.getTime();
          if(nowTime>writeTime){
          //????????? ??????
              sec =parseInt(nowTime - writeTime) / 1000;
              day  = parseInt(sec/60/60/24);
              sec = (sec - (day * 60 * 60 * 24));
              hour = parseInt(sec/60/60);
              sec = (sec - (hour*60*60));
              min = parseInt(sec/60);
              sec = parseInt(sec-(min*60));
              if(hour>0){
              //??????????????????
                  document.getElementsByClassName("sub")[0].innerHTML = hour+"?????? ???";
                  console.log(hour+"?????? ???");
              }else if(min>0){
              //???????????????
                  document.getElementsByClassName("sub")[0].innerHTML = min+"??? ???";
                  console.log(min+"??? ???");
              }else if(sec>0){
              //??????????????? ??????
                  document.getElementsByClassName("sub")[0].innerHTML = sec+"??? ???";
                  console.log(sec+"??? ???");
              }
          }
      }
  }


})

//???????????? :?????????????????? - ?????????????????? 
//???????????? :??????
