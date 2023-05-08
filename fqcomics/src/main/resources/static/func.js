/**
 * 
 */


const HOST="http://laptop.mydomain:8080";
//const HOST="http://192.168.100.4:8080";
//const HOST="https://fqcomics.herokuapp.com";

document.addEventListener('DOMContentLoaded', function (event) {
  console.log('DOM fully loaded and parsed');
  console.log("buscar all");
		var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function()
        {
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
            {
                //console.log(xmlHttp.responseText);
				//document.getElementById("nombre").value = xmlHttp.responseText;
				var myObject = JSON.parse(xmlHttp.responseText);
				window.bookList = myObject; 
				console.log(myObject);
				console.log(myObject[0].nombre);
			  	
			  	var listNameElement = document.getElementById("combo-options"); 
		
				for(var i = 0; i < myObject.length; i++) {
				    var obj = myObject[i];
				    console.log(obj.nombreCorto);
					
					var newOptionElement = document.createElement("option");
			  		newOptionElement.textContent = myObject[i].nombre;
					newOptionElement.value = myObject[i].isbn;
					listNameElement.appendChild(newOptionElement);
				}
            }
        }
		console.log(API_HOST);
		console.log("jsessionid"+getJSessionId());
		//let url = API_HOST+"/inventory/all?JSESSIONID=1"
		var url = new URL(API_HOST+"/inventory/all?JSESSIONID=1");
        url.searchParams.set('JSESSIONID', getJSessionId());
		
		xmlHttp.open("GET", url);
		//xmlHttp.setRequestHeader('JSESSIONID', 'QWEQWEQWE');
		//xmlHttp.setRequestHeader('Access-Control-Allow-Private-Network', 'true'); 
        xmlHttp.send(); 
});


function getJSessionId(){
	//alert(document.cookie.match(/JSESSIONID=[^;]+/));
    var jsId = document.cookie.match(/JSESSIONID=[^;]+/);
    if(jsId != null) {
        if (jsId instanceof Array)
            jsId = jsId[0].substring(11);
        else
            jsId = jsId.substring(11);
    }
    return jsId;
}

function test(){
	console.log("test");
}

function confirmCart(){

		console.log('confirmar carro');
		var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function()
        {
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
            {
				console.log('save response '+xmlHttp.responseText);
				if(xmlHttp.responseText){
					alert("yuju!");
					window.location.replace("/productos");
				}
            }
        }
        xmlHttp.open("POST", API_HOST+"/presale/payed"); 
		//xmlHttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    	xmlHttp.setRequestHeader('Content-Type', 'application/json');
		
		var obj = new Object();
		//console.log("id "+document.getElementById("id").innerText)
		//console.log("id "+document.getElementById("id").value)
		
		obj.newtotal = document.getElementById("newtotal").value;
		obj.despacho = document.getElementById("despacho").value;
		var jsonString= JSON.stringify(obj);
    	xmlHttp.send(jsonString);
}


function payed(id){

		console.log('pagar '+id);
		var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function()
        {
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
            {
				console.log('save response '+xmlHttp.responseText);
				
            }
        }
        xmlHttp.open("POST", HOST+"/presale/payed"); 
		//xmlHttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    	xmlHttp.setRequestHeader('Content-Type', 'application/json');
		
		var obj = new Object();
		console.log("id "+document.getElementById("id").innerText)
		console.log("id "+document.getElementById("id").value)
		
		obj.id = id;
		
		//const el = document.getElementById("id")
		//const attrArray = Array.from(el.attributes)
		
		// Now you can iterate all the attributes and do whatever you need.
		//const attributes = attrArray.reduce((attrs, attr) => {
		 //   attrs !== '' && (attrs += ' ')
		  //  attrs += `${attr.nodeName}="${attr.nodeValue}"`
		   // return attrs
		//}, '')
		//console.log(attributes)
		
		
		
		var jsonString= JSON.stringify(obj);
    	xmlHttp.send(jsonString);
}

function onInput() {
    var val = document.getElementById("combobox").value;
    var opts = document.getElementById('combo-options').childNodes;
    for (var i = 0; i < opts.length; i++) {
      if (opts[i].value === val) {
        // An item was selected from the list!
        // yourCallbackHere()
		//var myObject = window.bookList; 
		//console.log('on click '+myObject[0].nombre);
		console.log('on click '+val);
		
		//
		var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function()
        {
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
            {
				var myObject = JSON.parse(xmlHttp.responseText);
				console.log(myObject);
				console.log(myObject[0].isbn);
				document.getElementById("isbn").value = myObject[0].isbn;
				document.getElementById("pvp").value = myObject[0].precioPiso;
				document.getElementById("stock").value = myObject[0].cantidad;
				document.getElementById("edi").value = myObject[0].editorial;
				document.getElementById("name").value = myObject[0].nombre;
				document.getElementById("nombreCorto").value = myObject[0].nombreCorto;
            }
        }
        
		var url = new URL(API_HOST+"/inventory/"+val+"?JSESSIONID=1");
        url.searchParams.set('JSESSIONID', getJSessionId());
		xmlHttp.open("GET", url);
		
        xmlHttp.send();
		//
		
		
			  	
        //alert(opts[i].text);
        break;
      }
    }
  }


function volverAProductos(){
	window.location.replace("/productos");
}

function guardar(){
	console.log('guardar');
	if(document.getElementById("stock").value == 0){
		return alert('Sin Stock')
	}
	
	var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function()
        {
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
            {
				console.log('save response '+xmlHttp.responseText);
				if(xmlHttp.responseText=="") {
					alert('Sin Stock')	
				}else{
					var myObject = JSON.parse(xmlHttp.responseText);
					console.log(myObject.orderId);
					
					//update stock
					
					//onInput();
					document.getElementById("stock").value = document.getElementById("stock").value - document.getElementById("cantidad").value; 
					
					let orderInfo = "Tu número de orden es: "+myObject.orderId; 
					//if (confirm(orderInfo)) {
					 //   txt = "You pressed OK!";
					//	//
					//	copyText(orderInfo);
						//
					//} else {
					 //   txt = "You pressed Cancel!";
					//}
					
					//update cart quantity
					var badge = document.getElementById("cart_amount");
					console.log("badge:"+badge);
					let value = badge.getAttribute("value");
					console.log("value:"+value);
					//badge.value = badge.value + 1;
					badge.setAttribute("value",parseInt(value) + 1); 
					
				}
				
				//document.getElementById("stock").value = myObject.cantidad;
				
            }
        }
		var url = new URL(API_HOST+"/presale/save?JSESSIONID=1");
        url.searchParams.set('JSESSIONID', getJSessionId());
        xmlHttp.open("POST", url); 
		//xmlHttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    	xmlHttp.setRequestHeader('Content-Type', 'application/json');
		
		var obj = new Object();
   		obj.isbn = document.getElementById("isbn").value;
		obj.nombre = document.getElementById("name").value;
		obj.cantidad = document.getElementById("cantidad").value;
		obj.precioVentaReal = document.getElementById("pvr").value;
		obj.vendedor = document.getElementById("salesman").value;
		obj.cliente = document.getElementById("cliente").value;
		obj.nombreCorto = document.getElementById("nombreCorto").value;
		console.log(document.getElementById("nombreCorto").value);
   		var jsonString= JSON.stringify(obj);
    	xmlHttp.send(jsonString);
        
}

function copyText(orderInfo){
	var textToCopy = orderInfo;					
    var myTemporaryInputElement = document.createElement("input");
    myTemporaryInputElement.type = "text";
    myTemporaryInputElement.value = textToCopy;
    document.body.appendChild(myTemporaryInputElement);
    myTemporaryInputElement.select();
    document.execCommand("Copy");
    document.body.removeChild(myTemporaryInputElement);
}
function onClearSelected(){
	console.log('clear');
	document.getElementById("combobox").value='';

	var inputElements = document.getElementsByTagName('input');
	for (var i=0; i < inputElements.length; i++) {
	    if (inputElements[i].type == 'text') {
	        inputElements[i].value = '';
	    }
	}
}
function keydown(){
	console.log(event.keyCode);
}

function keyup(){
	console.log(event.keyCode);
	
	let nombreField = document.getElementById("nombre").value;
	console.log(nombreField.length);
	
	if(nombreField.length>=3)
	{
		console.log("buscar nombre");
		var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function()
        {
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
            {
                console.log(xmlHttp.responseText);
				document.getElementById("nombre").value = xmlHttp.responseText;
            }
        }
        xmlHttp.open("GET", HOST+"/inventory/"+nombreField); 
        xmlHttp.send(); 
	}
	
}

// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()