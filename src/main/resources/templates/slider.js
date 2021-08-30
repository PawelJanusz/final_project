let number = Math.floor(Math.random()*5)+1;

function hide(){
    $("#advertisement").fadeOut(500);
}

function changePicture(){
    number++;
    if (number>5) {
        number = 1;
    }
    let file  = "<img src=\"src/main/resources/static/images/rtx" + number + ".jpg\"/>";

    document.getElementById("advertisement").innerHTML = file;
    $("#advertisement").fadeIn(500);
    setTimeout("changePicture()", 5000);
    setTimeout("hide()",4500);
}
