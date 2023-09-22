// const Homeworks = [
//   {
//     classTitle: "모바일&스마트시스템",
//     homeworkTitle: "라즈베리파이 연결 동영상 제출",
//     deadline: "2023-10-13T23:55:00",
//     isSummit: 'Y'
//   },
//   {
//     classTitle: "네트워크프로그래밍",
//     homeworkTitle: "해보기 문제 결과 제출",
//     deadline: "2023-10-10T23:55:00",
//     isSummit: 'N'
//   },
//   {
//     classTitle: "고급모바일프로그래밍",
//     homeworkTitle: "커스텀뷰 과제",
//     deadline: "2023-09-27T23:55:00",
//     isSummit: 'Y'
//   },
// ];

let Homeworks

// JavaScript code in your script.js file

const apiUrl = '/api/v2/homeworks'; // Replace with your API endpoint URL

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
    console.log(Homeworks); // You can process and use the data here
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });




const addHomework = () => {
  const homeworkBoard = document.querySelector(".get-homework");
  // homeworkBoard.innerHTML = "";

  for (let i = 0; i < Homeworks.length; i++) {
    const newHomework = document.createElement("div");
    newHomework.className = "homework-content";

    let check = 'invisible';
    let no = 'invisible';
    if(Homeworks[i].isSummit === 'Y') check = ''
    else no = ''

    const deadline = diffDay(i);

    newHomework.innerHTML = `
    <div class="isSummit">
      <i class="bi bi-check-lg ${check}"></i>
      <i class="bi bi-x-circle ${no}"></i>
    </div>
    <div class="homework-info">
      <div class="homework-class">${Homeworks[i].classTitle}</div>
      <div class="homework-title">${Homeworks[i].homeworkTitle}</div>
      <div class="duration">${deadline} 남음..</div>
    </div>
    <div class="homework-icon"><i class="bi bi-chevron-right"></i></div>`;

    homeworkBoard.appendChild(newHomework);
  }
};

function diffDay(i) {
  const masTime = new Date(Homeworks[i].deadline);
  const todayTime = new Date();
  
  const diff = masTime - todayTime;

  const diffDay = Math.floor(diff / (1000*60*60*24));
  const diffHour = Math.floor((diff / (1000*60*60)) % 24);
  const diffMin = Math.floor((diff / (1000*60)) % 60);
  const diffSec = Math.floor(diff / 1000 % 60);
  
  return `${diffDay}일 ${diffHour}시간 ${diffMin}분 ${diffSec}초`;
}