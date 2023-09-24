let files = [];

let reloadLib;

apiUrl = '/api/v2/course'; // Replace with your API endpoint URL

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
      let fileClass = [];

      const select = document.querySelector("#classes");

      let selectClass = select.options[select.selectedIndex].value;

      for(let i=0;i<files.data.length;i++){
        if(selectClass === files.data[i].id.toString() && files.data[i].filePath !== null){
         fileClass.push(files.data[i])
        }
      }


      for (let i = 0; i < fileClass.length; i++) {
        let libWeek = `.lib${fileClass[i].week}`;
        let lib = document.querySelector(libWeek);
        let libPanel = lib.querySelector(".panel");

        libPanel.innerHTML = "";

        if(fileClass[i] != null){
          let libContent = document.createElement("div");
          libContent.innerHTML = `
      <div class="class-content"><i class="bi bi-file-earmark-arrow-down-fill"></i> ${fileClass[i].fileName}</div>
    `;
          libContent.addEventListener("click", () => {
            window.location.href = `/file/${fileClass[i].filePath}`;
          });
          libPanel.appendChild(libContent);
        }
      }
    }
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });