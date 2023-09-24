let files = [
  {
    week: 1,
    filePath: "/file/3/1/file/asd.pdf",
    filename: "asd"
  }
];

let reloadLib;

apiUrl = '/api/v2/homeworks'; // Replace with your API endpoint URL

// Fetch data from the API
fetch(apiUrl)
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    // Handle the data received from the API
    files = data
    reloadLib = () => {

      const select = document.querySelector("#classes");

      let selectClass = select.options[select.selectedIndex].text;

      for (let i = 0; i < files.length; i++) {
        let libWeek = `.lib${files[i].week}`;
        let lib = document.querySelector(libWeek);
        let libPanel = lib.querySelector(".panel");

        libPanel.innerHTML = "";

        if(files[i] != null){
          let libContent = document.createElement("div");
          libContent.innerHTML = `
      <div class="class-content"><i class="bi bi-file-earmark-arrow-down-fill"></i> ${files[i].filename}</div>
    `;
          libContent.addEventListener("click", () => {
            window.location.href = `${files[i].filePath}`;
          });
          libPanel.appendChild(libContent);
        }
      }
    }
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });