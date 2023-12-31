// const Homeworks = [
//   {
//     // classTitle: "알고리즘",
//     homeworkTitle: "수시시험1",
//     deadline: "2023-10-13T23:55:00",
//     isSummit: 'Y'
//   },
//   {
//     // classTitle: "자료구조",
//     homeworkTitle: "수시시험2",
//     deadline: "2023-10-10T23:55:00",
//     isSummit: 'N'
//   },
//   {
//     // classTitle: "안드로이드 프로그래밍",
//     homeworkTitle: "수시시험3",
//     deadline: "2023-09-27T23:55:00",
//     isSummit: 'Y'
//   },
// ];

let Homeworks

// JavaScript code in your script.js file

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
    Homeworks = data
    addHomework();
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });

const addHomework = () => {
  const homeworkBoard = document.querySelector(".get-homework");
  // homeworkBoard.innerHTML = "";

  const title = document.querySelector(".title");

  const titleText = title.querySelector("h2");

  for (let i = 0; i < Homeworks.data.length; i++) {

    if (titleText.innerText === Homeworks.data[i].classTitle) {
      const newHomework = document.createElement("div");
      // newHomework.className = "homework-content";

      newHomework.classList.add("homework-content");

      let check = 'invisible';
      let no = 'invisible';
      if (Homeworks.data[i].isSummit === 'Y') check = ''
      else no = ''

      const deadline = diffDay(i);

      newHomework.innerHTML = `
    <div class="isSummit">
      <i class="bi bi-check-lg ${check}"></i>
      <i class="bi bi-x-circle ${no}"></i>
    </div>
    <div class="homework-info">
<!--      <div class="homework-class">${Homeworks.data[i].classTitle}</div>-->
      <div class="homework-title">${Homeworks.data[i].homeworkTitle}</div>
      <div class="duration">${deadline} 남음..</div>
    </div>
    <div class="homework-icon"><i class="bi bi-chevron-right"></i></div>`;

      homeworkBoard.appendChild(newHomework);
    }
  }
};

function diffDay(i) {
  const masTime = new Date(Homeworks.data[i].deadline);
  const todayTime = new Date();

  const diff = masTime - todayTime;

  const diffDay = Math.floor(diff / (1000 * 60 * 60 * 24));
  const diffHour = Math.floor((diff / (1000 * 60 * 60)) % 24);
  const diffMin = Math.floor((diff / (1000 * 60)) % 60);
  const diffSec = Math.floor(diff / 1000 % 60);

  return `${diffDay}일 ${diffHour}시간 ${diffMin}분 ${diffSec}초`;
}