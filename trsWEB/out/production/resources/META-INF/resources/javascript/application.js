
focusOnFirstInput = function() {

	var forms = document.forms;
	var len = forms.length;

	for ( var i = 0; i < len; i++) {
		var form = forms[i];
		for ( var j = 0; j < form.length; j++) {
			var input = form[j];
			if (input.type != "hidden" && input.type != "button"
					&& input.type != "submit") {

				if (!input.disabled) {
					input.focus();
					if(input.type=="text"){
						input.select();
					}
					return;
				}
			}
		}
	}
};

//openHelp functions
function openHelp(url) {
	try {
		var win = window.open(url, 'help', 'dependent=no,directories=no,hotkeys=no,menubar=no,personalbar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no');
		return false;
		
	} catch(error) {
		logError(error, "openHelp");
	}
}

function getBrowserContentHeight(){
	//var viewportwidth;
	var viewportheight;
	// the more standards compliant browsers (mozilla/netscape/opera/IE7) use
	// window.innerWidth and window.innerHeight
	if (typeof window.innerWidth != 'undefined') {
		// viewportwidth = window.innerWidth,
		viewportheight = window.innerHeight
	} else if (typeof document.documentElement != 'undefined' && 
			typeof document.documentElement.clientWidth != 'undefined' && 
			document.documentElement.clientWidth != 0) {
		// viewportwidth = document.documentElement.clientWidth,
		viewportheight = document.documentElement.clientHeight
	}
	// older versions of IE
	else {
		// viewportwidth = document.getElementsByTagName('body')[0].clientWidth,
		viewportheight = document.getElementsByTagName('body')[0].clientHeight
	}
	return viewportheight;
}


function setMenuState(){
	if(!hasClass('menu-button','active-menu')){
		document.getElementById("appMenuForm:app_menu").className += " changePosition";
		document.getElementById("appMenuContent").style.display="block";
		document.getElementById("appMenu").style.position="absolute";
		document.getElementById("appMenu").className=" overlay";
		document.getElementById("menu-button").className = " Animated1MenuClose active-menu";
		document.getElementById("menuline1").className = " Animated05MenuClose";
		document.getElementById("menuline2").className = " Animated05MenuClose";
		document.getElementById("menuline3").className = " Animated05MenuClose";
	}else{
		document.getElementById("appMenuContent").style.display="none";
		document.getElementById("appMenu").style.position="static";
		document.getElementById("appMenu").className=" ";
		document.getElementById("menu-button").className = " Animated1MenuOpen";
		document.getElementById("menuline1").className = " Animated05MenuOpen";
		document.getElementById("menuline2").className = " Animated05MenuOpen";
		document.getElementById("menuline3").className = " Animated05MenuOpen";
	}
}
function hasClass(id,cls) {
	var ele = document.getElementById(id);
    return ele.className.match(new RegExp('(\\s|^)'+cls+'(\\s|$)'));
}

function removeClass(id,cls) {
	alert('"'+id+'"');
	alert(document.getElementById('"'+id+'"'));
	var ele = document.getElementById(id);
	alert(ele);
        if (hasClass(''+ele,''+cls)) {
            var reg = new RegExp('(\\s|^)'+cls+'(\\s|$)');
            ele.className=ele.className.replace(reg,' ');
        }
    }

function overrideIframeAttrs() {
	document.getElementsByTagName("iframe")[0].setAttribute("sandbox",
			"allow-same-origin allow-scripts allow-popups allow-forms");
}
