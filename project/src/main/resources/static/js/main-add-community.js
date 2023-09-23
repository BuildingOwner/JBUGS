let RecoContents

// JavaScript code in your script.js file

let apiUrl = '/api/v2/communities'; // Replace with your API endpoint URL

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
      RecoContents = data
    })
    .catch(error => {
      console.error('There was a problem with the fetch operation:', error);
    });

const addCommunity = () => {
  const recoList = document.querySelector(".reco-list");
  recoList.innerHTML = "";

  for (let i = 0; i < RecoContents.data.length; i++) {
    const newCommunity = document.createElement("div");
    newCommunity.className = "reco-contents";
    newCommunity.innerHTML = `
      <div class="img-center">
        <img src="${RecoContents.data[i].imgsrc}" alt="reco1Img" />
      </div>
      <h5 class="reco1-title">${RecoContents.data[i].title}</h5>
      <span class="reco1-discription">${RecoContents.data[i].discription}</span>
      <span class="reco1-people">${RecoContents.data[i].people}명 참여중</span>`;

    recoList.appendChild(newCommunity);
  }
};