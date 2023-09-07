document
  .querySelectorAll(".accordion .accordion_item > button")
  .forEach((btn) => {
    btn.addEventListener("click", (e) => {
      let accordion_item = e.currentTarget.parentNode;
      accordion_item.classList.toggle("open");
    });
  });
