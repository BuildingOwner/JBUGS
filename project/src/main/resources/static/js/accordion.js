//아코디언 클릭 이벤트 정의
// document
//   .querySelectorAll(".accordion .accordion_item > button")
//   .forEach((btn) => {
//     btn.addEventListener("click", (e) => {
//       let accordion_item = e.currentTarget.parentNode;
//       accordion_item.classList.toggle("open");
//     });
//   });

var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function () {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    }
  });
}
