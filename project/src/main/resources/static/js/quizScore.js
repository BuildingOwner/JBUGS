let quizzes = null;

let answer
document.addEventListener('DOMContentLoaded', function() {
  const urlParams = new URLSearchParams(window.location.search);
  const answers = urlParams.get('answers');
  answer = JSON.parse(decodeURIComponent(answers));

  // Now, you can use `parsedAnswers` to access the form data.
});

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
    for(let i=0;i<quizzes.data.length;i++){
      if(quizzes.data[i].id.toString() === searchParam('classesId') && quizzes.data[i].week === searchParam('week')){
        quizzes = JSON.parse(quizzes.data[i].question);
        break;
      }
    }
    loadQuestion(); // Call the function to load questions
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });


const loadQuestion = () => {
  const quizContainer = document.querySelector(".quiz-container");
  const formTag = quizContainer.querySelector("form");

  console.log(formTag)

  for (let i = 0; i < quizzes.questions.length; i++) {
    const newQuiz = document.createElement("div");
    let quizContent;
    if(quizzes.questions[i].Hint !== undefined) quizContent = blankQuiz(i, quizzes.questions[i]);
    else if(quizzes.questions[i].Selection !== undefined) quizContent = selectionQuiz(i, quizzes.questions[i]);
    else quizContent = shortQuiz(i, quizzes.questions[i]);
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
  const userAnswer = answer[i].answer;
  const correctAnswer = quiz.Answer.trim()[0];
  const isCorrect = userAnswer === correctAnswer;

  const backgroundColor = isCorrect ? 'var(--safe)' : 'var(--warning)';

  return `
  <div class="quiz-box" id="quiz${i + 1}">
    <h4 class="question">${i + 1}. ${quiz.Question.trim()}</h4>
    <ul class="option">
      <li><input type="radio" name="answer${i}" class="option1" value="1"/> ${quiz.Selection[0].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option2" value="2"/> ${quiz.Selection[1].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option3" value="3"/> ${quiz.Selection[2].trim()}</li>
      <li><input type="radio" name="answer${i}" class="option4" value="4"/> ${quiz.Selection[3].trim()}</li>
    </ul>
    제출 : ${answer[i].answer}
    <div class="correct" style="background-color: ${backgroundColor};">답 : ${quiz.Answer.trim()}</div>
  </div>
  `;
};

const shortQuiz = (i, quiz) => {
  const userAnswer = answer[i].answer;
  const correctAnswer = quiz.Answer.trim();
  const isCorrect = userAnswer === correctAnswer;

  const backgroundColor = isCorrect ? 'var(--safe)' : 'var(--warning)';

  return `
  <div class="quiz-box" id="quiz${i + 1}">
    <h4 class="question">${i + 1}. ${quiz.Question.trim()}</h4>
    제출 : ${answer[i].answer}
    <div class="correct" style="background-color: ${backgroundColor};">답 : ${quiz.Answer.trim()}</div>
  </div>
  `;
};

const blankQuiz = (i, quiz) => {
  let editQuiz = quiz.Question;
  let input = `<input type="text" name="answer">`
  const userAnswer = answer[i].answer;
  const correctAnswer = quiz.Answer.trim();
  const isCorrect = userAnswer === correctAnswer;

  const backgroundColor = isCorrect ? 'var(--safe)' : 'var(--warning)';

  return `
  <div class="quiz-box" id="quiz${i + 1}">
    <h4 class="question">${i + 1}. ${editQuiz.replace("_", input).trim()}</h4>
    제출 : ${answer[i].answer}
    <div class="correct" style="background-color: ${backgroundColor};">답 : ${quiz.Answer.trim()}</div>
  </div>
  `
}

function searchParam(key) {
  return new URLSearchParams(location.search).get(key);
}