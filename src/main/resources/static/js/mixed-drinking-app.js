const menuButton = document.querySelector(".nav-menu");
menuButton.addEventListener("click", function () {
  var menuList = document.querySelector("nav ul");
  if (menuList.style.display === "block") {
    menuList.style.display = "none";
  } else {
    menuList.style.display = "block";
  }
});
