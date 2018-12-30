// @ts-check

function greetUser() {
  // @ts-ignore
  let userName = document.getElementById("userName").value;
  document.getElementById("message").innerHTML = "";
  if (!userName || !userName.trim().length) {
    return;
  }

  fetch("http://localhost:8080/web1/controller/users/greetUser", {
    method: "POST",
    credentials: "same-origin",
    headers: { "Content-Type": "application/json" },
    body: userName
  })
    .then(response => response.json())
    .then(result => {
      document.getElementById("message").innerHTML = result.message;
    })
    .catch(error => { });
}

function findUser() {
  // @ts-ignore
  let userName = document.getElementById("userName").value;
  document.getElementById("message").innerHTML = "";
  if (!userName || !userName.trim().length) {
    return;
  }

  fetch("http://localhost:8080/web1/controller/users/findByName", {
    method: "POST",
    credentials: "same-origin",
    headers: { "Content-Type": "application/json" },
    body: userName
  })
    .then(response => response.json())
    .then(result => {
      document.getElementById("message").innerHTML = result.message;
    })
    .catch(error => { });
}

function addUser() {
  // @ts-ignore
  let userName = document.getElementById("userName").value;
  document.getElementById("message").innerHTML = "";
  if (!userName || !userName.trim().length) {
    return;
  }

  fetch("http://localhost:8080/web1/controller/users/addUser", {
    method: "POST",
    credentials: "same-origin",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name: userName })
  })
    .then(response => response.json())
    .then(result => {
      document.getElementById("message").innerHTML = result.message;
    })
    .catch(error => { });
}

document
  .getElementById("findUserBtn")
  .addEventListener("click", () => findUser());

document
  .getElementById("addUserBtn")
  .addEventListener("click", () => addUser());

  document
  .getElementById("greetUserBtn")
  .addEventListener("click", () => greetUser());
  