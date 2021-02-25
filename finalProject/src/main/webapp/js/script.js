window.addEventListener("load",function(){
    if(localStorage.getItem("hiddenLinksStyle"))
        document.getElementById("hiddenLinks").style.display = localStorage.getItem("hiddenLinksStyle");
    if(localStorage.getItem("notHiddenLinksStyle"))
        document.getElementById("notHiddenLinks").style.display = localStorage.getItem("notHiddenLinksStyle");
    // перезаписываем страницу при загрузке

    for (var i = 0; i < document.getElementsByClassName('changeOnClick').length; i++){
        document.getElementsByClassName('changeOnClick')[i].addEventListener('click', function () {
            document.getElementById("notHiddenLinks").style.display = (document.getElementById("notHiddenLinks").style.display !== "none") ? "none" : "block";
            document.getElementById("hiddenLinks").style.display = (document.getElementById("hiddenLinks").style.display !== "block") ? "block" : "none";
        }, false);
    }

    window.addEventListener("click",function(){
        localStorage.setItem("hiddenLinksStyle", document.getElementById("hiddenLinks").style.display);
        localStorage.setItem("notHiddenLinksStyle", document.getElementById("notHiddenLinks").style.display);
    }); // перезаписываем страницу при каждом клике
});


var input = document.querySelectorAll('input')
  ,value = input.value;

input.addEventListener('input', onInput);

function onInput(e){
  var newValue = e.target.value;
  if( newValue.match(/[^a-zA-Zа-яА-Я0-9]/g)) {
     input.value = value;
     return;
  }
  value = newValue;
}
//<input type="text" id="in-txt">
