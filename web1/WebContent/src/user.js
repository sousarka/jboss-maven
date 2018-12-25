// @ts-check

function getUser() {
  fetch("http://localhost:8080/web1/controller/hello/sayHello", {
    method: "POST",
    credentials: "same-origin",
    headers: { "Content-Type": "application/json" },
    // @ts-ignore
    body: JSON.stringify(document.getElementById("userName").value)
  })
    .then(response => response.json())
    .then(user => {
      document.getElementById("userInfo").innerHTML = user.name;
    })
    .catch(error => {});
}

document
  .getElementById("sayHelloBtn")
  .addEventListener("click", () => getUser());
