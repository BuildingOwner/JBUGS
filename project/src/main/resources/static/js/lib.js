const reloadLib = () => {
  let files = [
    {
      week: 1,
      filePath: "/file/3/1/파일이름",
      filename: "asd"
    }
  ];

  const select = document.querySelector("#classes");

  let selectClass = select.options[select.selectedIndex].text;

  for (let i = 0; i < files.length; i++) {
    let libWeek = `.lib${i}`;
    let lib = document.querySelector(libWeek);
    let libPanel = lib.querySelector(".panel");
    let libContent = document.createElement("div");
    libContent.innerHTML = `
      <div class="class-content"><i class="bi bi-file-earmark-arrow-down-fill"></i> ${files[i].filename}</div>
    `;
    libContent.addEventListener("click", () => {
      window.location.href = `${files[i].filesrc}`;
    });
  }
}