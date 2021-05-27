window.addEventListener("load", function() {
    let background = document.querySelector(".black-bg");
    let modal = document.querySelector(".modal");
	let editBtn = document.querySelector(".edit-btn");
    let deleteBtn = document.querySelector(".delete-btn");
	
    deleteBtn.onclick = function() {
        background.classList.remove("d-none");
        modal.classList.remove("d-none");
    };

    modal.onclick = function(e) {
        e.preventDefault();

        if(!e.target.classList.contains("modal-close") && !e.target.classList.contains("close-btn"))
            return;

        background.classList.add("d-none");
        modal.classList.add("d-none");
    }
});