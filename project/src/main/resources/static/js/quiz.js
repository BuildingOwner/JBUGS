let quizzes = null; // Set the initial value to null.

const apiUrl = '/api/v2/quizs';

fetch(apiUrl)
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    quizzes = data; // Assign the data to the quizzes variable
    loadQuestion(); // Call the function to load questions
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });

const loadQuestion = () => {
  const quizContainer = document.querySelector(".quiz-container");
  const formTag = quizContainer.querySelector("form");

  for (let i = 0; i < quizzes.data.length; i++) {
    const newQuiz = document.createElement("div");
    let quizContent;
    if (quizzes.data[i].hint !== null) quizContent = blankQuiz(i, quizzes.data[i]);
    else if (quizzes.data[i].selection !== null) {
      quizContent = selectionQuiz(i, quizzes.data[i]);
    }
  else
    quizContent = shortQuiz(i, quizzes.data[i]);
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
  let inputString = quiz.selection;
  let extractedStrings = inputString.match(/'[^']+'/g);
  extractedStrings = extractedStrings.map(str => str.slice(1, -1));

  return `
  <div class="quiz-box" id="quiz${i + 1}">
    <h5 class="question">${i + 1}. ${quiz.question.trim()}</h5>
    <ul class="option">
      <li><input type="radio" name="answer${i}" class="option1" value="1"/> ${extractedStrings[0].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option2" value="2"/> ${extractedStrings[1].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option3" value="3"/> ${extractedStrings[2].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option4" value="4"/> ${extractedStrings[3].trim()}</li>
    </ul>
  </div>
  `;
};

const shortQuiz = (i, quiz) => {
  return `
  <div class="quiz-box" id="quiz${i + 1}">
    <h5 class="question">${i + 1}. ${quiz.question.trim()}</h5>
    답 : <input type="text" name="answer${i}">
  </div>
  `;
};

const blankQuiz = (i, quiz) => {
  let editQuiz = quiz.question;
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

  for (let i = 0; i < quizzes.data.length; i++) {
    const key = `answer${i}`;
    const value = formData.get(key);
    const answer = value !== null ? value.trim() : 'No answer';
    answers.push({question: quizzes.data[i].question, answer});
  }

  const jsonAnswers = JSON.stringify(answers);
  window.location.href = '/quizScore?answers=' + encodeURIComponent(jsonAnswers);
}
