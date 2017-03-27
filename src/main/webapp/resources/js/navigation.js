/**
 * @author disha
 */
function openNav() {
	    document.getElementById("mySidenav").style.width = "250px";
	    document.getElementById("main").style.marginRight = "250px";
	}

function closeNav() {
	    document.getElementById("mySidenav").style.width = "0";
	    document.getElementById("main").style.marginRight= "0px";
}

function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}
function redirectSearch(){
	alert("hi");
	document.getElementById('action').value = 'Search';
	document.getElementById('opForm').submit();
}


function update(){
	document.getElementById('action').value = 'Edit';
	document.getElementById('opForm').submit();
}