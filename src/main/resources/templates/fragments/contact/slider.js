let number = Math.floor(Math.random()*5)+1;

function hide(){
    $("#tile5").fadeOut(500);
}

function changeImage(){
    number++;
    if (number>5) {
        number = 1;
    }
    let file  = "<img src=\"image/logo" + number + ".jpg\"/>";

    document.getElementById("tile5").innerHTML = file;
    $("#tile5").fadeIn(500);
    setTimeout("changeImage()", 5000);
    setTimeout("hide()",4500);
}