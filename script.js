function createToast(status, toastMessage) {
console.log(status+" and "+toastMessage);
  var toastContainer = createToastContainer(status);
  createToastHeader(status, toastContainer);
  createToastContent(toastContainer, toastMessage);
  initToast(toastContainer);
  // setTimeout(function(){ destroyToast(toastContainer); },5000) ;
}

function createToastContainer(status) {
  console.log("creating container");
  var toastContainer = document.createElement("div");
  toastContainer.setAttribute("id","toast");
   toastContainer.setAttribute("onclick","this.remove();");
  toastContainer.classList.add("toastContainer")
  if (status == "success") {
    toastContainer.classList.add("toastContainerSuccess");
  } else if(status == "error"){
    toastContainer.classList.add("toastContainerError");
  } else if(status == "warning"){
    toastContainer.classList.add("toastContainerWarning");
  } else if(status == "info"){
    toastContainer.classList.add("toastContainerInfo");
  }
  return toastContainer;
}

function createToastHeader(status, toastContainer){
  console.log("creating toast header");
  var toastHeader = document.createElement("div");
  if (status == "success") {
    toastHeader.className = "toastContainerSuccess";
  } else if(status == "error"){
    toastHeader.className = "toastContainerError";
  } else if(status == "warning"){
    toastHeader.className = "toastContainerWarning";
  } else if(status == "info"){
    toastHeader.className = "toastContainerInfo";
  }
  toastHeader.setAttribute("id","toastHeader");
  toastHeader.appendChild(document.createTextNode(status.toUpperCase()));
  toastHeader.className = "div-table-row";
  toastContainer.appendChild(toastHeader);
}

function createToastContent(toastContainer, toastMessage){
  console.log("creating toast content");
  var toastContent = document.createElement("div");
  toastContent.setAttribute("id","toastContent");
  toastContent.appendChild(document.createTextNode(toastMessage));
  toastContainer.appendChild(toastContent);
}

function initToast(toastContainer){
  console.log("initialising toast");
  if(document.getElementsByTagName("main").length === 0 && document.getElementsByTagName("app-login").length !== 0){
    console.log("main tag not found nut app-login found");
    var mainelement = document.getElementsByTagName("app-login")[0];
    mainelement.appendChild(toastContainer);
  }
  else if(document.getElementsByTagName("main").length !== 0){
    console.log("main tag found");
  var mainelement = document.getElementsByTagName("main")[0];
  mainelement.appendChild(toastContainer);
  }
  else{
    console.log("appending in body");
    document.body.appendChild(toastContainer);
  }
}

function destroyToast(toastContainer){
  console.log("destroying toast");
  if(document.body.contains(toastContainer)){
  document.getElementById("toast").remove();
  }
}
