const apiUrl = '/api/v2/quizs';

// const quizs = {
//   "questions": [
//     {
//       "Question": " LinkedList에 대한 traverse는?",
//       "Answer": " 순회"
//     },
//     {
//       "Question": " _는 데이터의 구조, 특성 또는 속성의 측면을 나타냅니다.",
//       "Answer": " order",
//       "Hint": [
//         "order"
//       ]
//     },
//     {
//       "Question": "노드는 다음 중 어느것에 해당하는가?",
//       "Answer": "1",
//       "Selection": [
//         "데이터 값과 다른 노드 사이의 연결 고리",
//         "저장공간",
//         "인덱스",
//         "연산"
//       ]
//     },
//     {
//       "Question": " 실행 시 반복적으로 노드와 그 부모 노드를 비교하는 알고리즘은 무엇인가?",
//       "Answer": " 3",
//       "Selection": [
//         "트리 정렬",
//         "탐색 알고리즘",
//         "이진 검색 방법",
//         "단순 비교 알고리즘"
//       ]
//     },
//     {
//       "Question": " left_node의 의미는?",
//       "Answer": "왼쪽노드"
//     },
//     {
//       "Question": " head가 가지고 있는 값의 유형은 무엇인가?",
//       "Answer": " 주소"
//     },
//     {
//       "Question": " 다음 중 데이터 구조의 정의에 맞지 않은 것은?",
//       "Answer": " 3",
//       "Selection": [
//         "더 최적화된 방법으로 데이터를 다루는 기법  ",
//         "문자, 숫자 등의 정보를 구조화하는 작업  ",
//         "데이터를 저장하고 가공하기 위한 창고  ",
//         "어떤 작업을 처리하여 어떤 결과값을 얻는 기법"
//       ]
//     },
//     {
//       "Question": "List는 순서가 있는 저장 공간으로 구성된 것이다. 다음중 잘못된 것은? ",
//       "Answer": "2",
//       "Selection": [
//         "List는 각 위치에 데이터를 저장하는 순차형 자료 구조다. ",
//         "List는 동일한 데이터 값이 하나 이상 존재할 수 없다.",
//         "List는 데이터의 순서가 바뀌면 데이터 접근에 유리한 구조다.",
//         "List는 새로운 데이터 삽입과 제거가 빠르다. "
//       ]
//     },
//     {
//       "Question": " 다음 중 Node의 역할이 적절하지 않은것은?",
//       "Answer": "4",
//       "Selection": [
//         "그래프를 구성하는 요소",
//         "데이터를 담는 저장공간",
//         "하나의 데이터를 열거하는 데 사용하는 개념",
//         "다음 노드로 이동하는 경로"
//       ]
//     },
//     {
//       "Question": "link에 대해 설명하라.",
//       "Answer": " 2",
//       "Selection": [
//         " 하나의 메모리 블럭을 구성하는 연속된 메모리 셀",
//         " 다른 주소에 존재하는 메모리를 가리키는 값",
//         " 데이터 항목 사이에 논리적 상관관계를 만들기 위해 기존 데이터 항목을 연결하는 것",
//         " 데이터를 특정 데이터의 순서에 따라 이동할 수 있게 하는 구조"
//       ]
//     }
//   ]
// };

let quizs;

function processJSON(jsonData) {
  const questionsList = document.getElementById('questionsList');

  // JSON 데이터를 JavaScript 객체로 파싱
  quizs = JSON.parse(jsonData);
}

// JSON 파일을 로드하기 위한 XMLHttpRequest 사용
const xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
  if (xhttp.readyState == 4 && xhttp.status == 200) {
    const jsonText = xhttp.responseText;
    processJSON(jsonText);
  }
};
xhttp.open("GET", "/quizModule/generateQuestion/resources/questions.json", true);
xhttp.send();

const loadQuistion = () => {
  const quizContainer = document.querySelector(".quiz-container");
  const formTag = quizContainer.querySelector("form");

  for (let i = 0; i < quizs.questions.length; i++) {
    const newQuiz = document.createElement("div");
    let quizContent;
    if (quizs.questions[i].Hint !== undefined) quizContent = blankQuiz(i, quizs.questions[i]);
    else if (quizs.questions[i].Selection !== undefined) quizContent = selectionQuiz(i, quizs.questions[i]);
    else quizContent = shortQuiz(i, quizs.questions[i]);
    newQuiz.innerHTML = quizContent;

    formTag.appendChild(newQuiz);

    const remote = document.querySelector(".quiz-control");
    const newRenote = document.createElement("div");
    newRenote.classList.add("remote");
    newRenote.addEventListener("click", () => {
      window.location.href = `#quiz${i + 1}`;
    })
    newRenote.innerText = `${i + 1}`;
    remote.appendChild(newRenote);
  }
};

const selectionQuiz = (i, quiz) => {
  return `
  <div class="quiz-box" id="quiz${i + 1}">
    <h5 class="question">${i + 1}. ${quiz.Question.trim()}</h5>
    <ul class="option">
      <li><input type="radio" name="answer${i}" class="option1" value="1"/> ${quiz.Selection[0].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option2" value="2"/> ${quiz.Selection[1].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option3" value="3"/> ${quiz.Selection[2].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option4" value="4"/> ${quiz.Selection[3].trim()}</li>
    </ul>
  </div>
  `;
};

const shortQuiz = (i, quiz) => {
  return `
  <div class="quiz-box" id="quiz${i + 1}">
    <h5 class="question">${i + 1}. ${quiz.Question.trim()}</h5>
    답 : <input type="text" name="answer${i}">
  </div>
  `;
};

const blankQuiz = (i, quiz) => {
  let editQuiz = quiz.Question;
  let input = `<input type="text" name="answer${i}">`
  return `
  <div class="quiz-box" id="quiz${i + 1}">
    <h5 class="question">${i + 1}. ${editQuiz.replace("_", input).trim()}</h5>
  </div>
  `
}

function submitForm() {
  const form = document.querySelector('form');
  const formData = new FormData(form);
  const answers = [];

  for (let i = 0; i < 10; i++) {
    const key = `answer${i}`;
    const value = formData.get(key);
    const answer = value !== null ? value.trim() : '답변 없음';
    answers.push({question: key, answer});
  }

  const jsonAnswers = JSON.stringify(answers);
  window.location.href = '/quizScore?answers=' + encodeURIComponent(jsonAnswers);
}


loadQuistion()

document.getElementById('videoButton').addEventListener('click', async (event) => {
  try {
    const videoPath = '!/resources/input.mp4';
    const videoSubject = '/datastructure'
    videoJson = await fetch('http://localhost:5500' + videoSubject + videoPath);
  } catch (error) {
    console.error('An error occurred:', error);
    document.getElementById('output').textContent = 'An error occurred during chat execution.';
  }
})
document.getElementById('getVideoKeyword').addEventListener('click', async (event) => {
  try {
    // Fetch 요청
    const response = await fetch('http://localhost:5500/getVideoKeyword');

    // 응답이 성공적인 경우
    if (response.ok) {
      videoJson = await response.json(); // JSON 데이터 추출
      console.log(videoJson);
    } else {
      throw new Error('An error occurred: ' + response.statusText);
    }
  } catch (error) {
    console.error('An error occurred:', error);
    document.getElementById('output').textContent = 'An error occurred during chat execution.';
  }
})
