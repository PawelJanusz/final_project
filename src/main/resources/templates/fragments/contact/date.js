function printDate() {

    let today = new Date();

    let day = today.getDate();
    let month = today.getMonth() + 1;
    let year = today.getFullYear();

    document.getElementById("date").innerHTML = day+"/"+month+"/"+year;


}