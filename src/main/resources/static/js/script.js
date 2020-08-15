'use strict';
function search() {
    let value = document.getElementById("search-input").value;
    if(value.length === 0){
        return;
    }else{
        window.location.href = '/search/'+value;
    }

};

let input = document.getElementById("search-input");
input.addEventListener("keyup",function (event) {
    if(event.keyCode === 13){
        event.preventDefault();
        document.getElementById("btn-search").click();
    }

});



