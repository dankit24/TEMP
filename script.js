function createToast(status, toastMessage) {
console.log(status+" and "+toastMessage);
  var toastContainer = createToastContainer(status);
  createToastHeader(status, toastContainer);
  createToastContent(toastContainer, toastMessage);
  initToast(toastContainer);
  setTimeout(function(){ destroyToast(toastContainer); },5000) ;
}

function createToastContainer(status) {
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
  toastContainer.appendChild(toastHeader);
}

function createToastContent(toastContainer, toastMessage){
  var toastContent = document.createElement("div");
  toastContent.setAttribute("id","toastContent");
  toastContent.appendChild(document.createTextNode(toastMessage));
  toastContainer.appendChild(toastContent);
}

function initToast(toastContainer){
  document.body.appendChild(toastContainer);
}

function destroyToast(toastContainer){
  if(document.body.contains(toastContainer)){
  document.getElementById("toast").remove();
  }
}